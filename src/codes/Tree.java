import java.util.*;

/**
 * Tree
 */
public class Tree {
    static  int maxPath;
    public static void main(String[] args) {
        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");
        Node<String> G = new Node<String>("G");
        Node<String> H = new Node<String>("H");
        Node<String> I = new Node<String>("I");
        Node<String> J = new Node<String>("J");
        Node<String> K = new Node<String>("K");

        //Root and Building  of the tree
        Node<String> root = A;
        A.left  =   B; A.right = C;
        B.left  =   D; B.right = E;
        D.left  =   H; D.right = I;
        E.left  =   J; 
        C.left  =   F; C.right = G;
        G.left  =   K;

        preOrder(root);
        iterativePreOrder(root);

        System.out.println("In Order: Left, Root, Right");
        inOrder(root);
        System.out.println("In Order: Left, Root, Right");
        iterativeInOrderTraverse(root);
        
        Node<Integer> pathSum = new Node<>(5);
        pathSum.left = new Node<>(4);
        pathSum.left.left = new Node<>(11);
        pathSum.left.left.left = new Node<>(7);
        pathSum.left.left.right = new Node<>(2);
        pathSum.right = new Node<>(8);
        pathSum.right.left = new Node<>(13);
        pathSum.right.right = new Node<>(4);
        pathSum.right.right.right = new Node<>(1);
        
        int sum = 22;
        System.out.println(hasPathSum(pathSum, sum));
        System.out.println(hasPathSumRecursion(pathSum, sum));
        //[3,9,20,null,null,15,7]
        Node<Integer> minDepthNode = new Node<>(3);
        minDepthNode.left = new Node<>(9);
        minDepthNode.right = new Node<>(20);
        minDepthNode.right.left = new Node<>(15);
        minDepthNode.right.right = new Node<>(7);
        System.out.println(minimumDepth(minDepthNode));
        //Max Path Sum
        TreeNode maxPathSumNode = new TreeNode(1);
        maxPathSumNode.left = new TreeNode(2);
        maxPathSumNode.right = new TreeNode(3);
        System.out.println("Max Path Sum: "+maxPathSum(maxPathSumNode));
        
        TreeNode postOrder = new TreeNode(1);
        postOrder.left = new TreeNode(2);
        postOrder.right = new TreeNode(3);
        postOrder.left.left = new TreeNode(4);
        postOrder.left.right = new TreeNode(5);
        postOrder.left.right.left = new TreeNode(6);
        
        postOrderTraversal(postOrder).forEach(x -> System.out.print(x+" "));
        System.out.println();
        postOrderTraversal2(postOrder).forEach(x -> System.out.print(x+" "));
        System.out.println();
    }

    //Root Left Right
    //Recursive Function
    public static <T> void preOrder(Node<T> node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Displaying data 
     * Pushing its right child in the Stack
     * Pushing its left child in the Stack
     * @param <T>
     * @param data
     */
    public static <T> void iterativePreOrder(Node<T> data){
        if(data ==  null)
            return;
        
        //Create an empty stack and push root node to it
        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(data);

        // We pop all items one by one. 
        // For each item, we make the following steps : print data, push its right child, push its left child
        // We push right child in first for that left is processed first
        while(!nodeStack.empty()){
            Node<T> currentNode = nodeStack.pop();
            System.out.print(currentNode.data+" ");

            if(currentNode.right != null){
                nodeStack.push(currentNode.right);
            }

            if(currentNode.left != null){
                nodeStack.push(currentNode.left);
            }
        }
    } 

    //Left, Root, Right
    public static <T> void inOrder(Node<T> node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    /**
     * 
     */
    public static <T> void iterativeInOrderTraverse(Node<T> node){
        if(node == null)
            return;
        //Create an empty stack
        Stack<Node<T>> nodeStack = new Stack<>();

        Node<T> currentNode = node;
        //Traverse the tree
        while(currentNode != null || nodeStack.size() > 0){
            //Reach the leftmost node of the current node
            while(currentNode != null){
                //We add pointer  to the  stack before traversing  the left node
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            //Current node is null at this point
            currentNode = nodeStack.pop();
            System.out.print(currentNode.data+" ");
            //Visit the right node
            currentNode = currentNode.right;
        }
    }
    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
     * that adding up all the values along the path equals the given sum.
     *
     * Java Solution 1 - Using Queue
     *
     * Add all node to a queue and store sum value of each node to another queue.
     * When it is a leaf node, check the stored sum value.
     *
     * For the tree above, the queue would be: 5 - 4 - 8 - 11 - 13 - 4 - 7 - 2 - 1.
     * It will check node 13, 7, 2 and 1. This is a typical breadth first search(BFS) problem.
     */
    static boolean hasPathSum(Node<Integer> root, int sum) {
        if(root == null) return false;
    
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Integer> vals = new LinkedList<>();
        nodes.add(root);
        vals.add(root.data);
        
        while (!nodes.isEmpty()) {
            
            Node curr = nodes.poll();
            int sumVal = vals.poll();
            
            if (curr.left == null && curr.right == null && sumVal == sum) {
                return true;
            }
            if(curr.left != null) {
                nodes.add(curr.left);
                vals.add(sumVal+(int)curr.left.data);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                vals.add(sumVal + (int) curr.right.data);
            }
        }
        return false;
    }
    
    static boolean hasPathSumRecursion(Node<Integer> root, int sum) {
        if (root == null) return false;
        if(root.data == sum && root.left == null && root.right == null)
            return true;
        return hasPathSumRecursion(root.left, sum - root.data)
                || hasPathSumRecursion(root.right, sum - root.data);
    }
    
    static int minimumDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> nodes = new LinkedList<>();
        
        nodes.offer(root);
        int level = 1;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            System.out.println("Size: "+size);
            for (int i = 0; i < size; i++) {
                Node curr = nodes.poll();
                System.out.println("Curr: "+curr.toString());
                
                if (curr.left == null && curr.right == null) return level;
                if (curr.left != null) {
                    nodes.offer(curr.left);
                }
                if (curr.right != null) {
                    nodes.offer(curr.right);
                }
            }
            level++;
        }
        return level;
    }
    
    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     * Example 2:
     *
     * Input: root = [1]
     * Output: [[1]]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(nodes.peek().left != null) nodes.offer(nodes.peek().left);
                if(nodes.peek().right != null) nodes.offer(nodes.peek().right);
                sub.add(nodes.poll().val);
            }
            res.add(sub);
        }
        return res;
        /**
         *  List<List<Integer>> list=new ArrayList();
         *         if(root==null)
         *             return list;
         *         Queue<TreeNode> queue=new LinkedList();
         *         queue.add(root);
         *         int level=0;
         *         while(!queue.isEmpty()){
         *             // level++;
         *             int size=queue.size();
         *             List<Integer> levelList=new ArrayList();
         *             while(size>0){
         *                 size--;
         *                 TreeNode node = queue.poll();
         *                 levelList.add(node.val);
         *                 if(node.left!=null)
         *                     queue.add(node.left);
         *
         *                 if(node.right!=null)
         *                     queue.add(node.right);
         *             }
         *             list.add(levelList);
         *
         *
         *         }
         *         return list;
         */
    }
    
    /**
     * Binary Tree Maximum Path Sum
     * Analysis
     *
     * 1) Recursively solve this problem
     * 2) Get largest left sum and right sum
     * 2) Compare to the stored maximum
     *
     *
     */
    
    public static int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        calculateSum(root);
        return maxPath;
    }
    public static int calculateSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, calculateSum(root.left));
        int right = Math.max(0, calculateSum(root.right));
        maxPath = Math.max(maxPath,left + right + root.val);
        return Math.max(left, right) + root.val;
    }
    
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = node;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.add(p.val); //Add before going to children
                p = p.left;
            } else {
                TreeNode node1 = stack.pop();
                p = node1.right;
            }
        }
        return result;
    }
    
    public static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val); //Reverse the process of preorder
                p = p.right; // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
    
    /**
     * The order of "Postorder" is: left child -> right child -> parent node.
     * Find the relation between the previously visited node and the current node
     * Use a stack to track nodes
     * As we go down the tree to the lft, check the previously visited node.
     * If the current node is the left or right child of the previous node, then keep going down the tree,
     * and add left/right node to stack when applicable. When there is no children for current node, i.e.,
     * the current node is a leaf, pop it from the stack. Then the previous node become to be under the current node for next loop.
     * You can using an example to walk through the code.
     * @param node
     * @return
     */
    public static List<Integer> postOrderTraversal2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            } else {
                if(temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
                if(temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return res;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val); //Add after all left children
                p = node.right;
            }
        }
        return result;
    }
}

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}