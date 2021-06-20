import java.util.*;

public class BinaryTree {
    int max_width;
    HashMap<Integer, Integer> leftmost_positions;
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node<String> root = new Node<>("a");
        root.left = new Node<>("b");
        root.right = new Node<>("f");
        root.left.left = new Node<>("c");
        root.left.right = new Node<>("e");
        root.left.left.left = new Node<>("d");
        root.right.left = new Node<>("g");
        root.right.right = new Node<>("h");
        root.right.right.right = new Node<>("k");
    
    
        // construct the tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);      // leaf node
        root2.right.right = new Node(6);     // leaf node
        root2.left.left.left = new Node(7);  // leaf node
    
        // construct a circular doubly linked list from leaves
        Node first = root2.left.left.left;
        Node second = root2.left.right;
        Node third = root2.right.right;
    
        // set previous and next pointers of the linked list
        // (left and right child of a binary tree node, respectively)
        first.left = third;
        first.right = second;
    
        second.left = first;
        second.right = third;
    
        third.left = second;
        third.right = first;
    
        System.out.println("The height of the binary tree is " + height(root2));
    
        Node<Integer> tree = new Node<>(2);
        tree.left = new Node(7);
        tree.right = new Node(5);
        tree.left.right = new Node(6);
        tree.left.right.left = new Node(1);
        tree.left.right.right = new Node(11);
        tree.right.right = new Node(9);
        tree.right.right.left = new Node(4);
        System.out.println("findMax: "+bt.findMax(tree));
        
        Node tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);
        tree2.right.left = new Node(8);
    
        bt.printKDistant(tree2, 2);
        
        System.out.println(countLeaves(root));
        System.out.println(countLeavesIteratively(root));
        printLeafNodes(root);
        printLeafNodesIteratively(root);
        preorderIterative(root);
    
        Node root3 = new Node(10);
        root3.left = new Node(2);
        root3.right = new Node(3);
        root3.left.left = new Node(7);
        root3.left.right = new Node(8);
        root3.right.right = new Node(15);
        root3.right.left = new Node(12);
        root3.right.right.left = new Node(14);
    
        rightViewUtil(root3);
    }
    
    /**
     * Recursive
     *
     * Here are the actual steps to follow:
     *
     * 1) If the node is null return 0, this is also the base case of our recursive algorithm
     * 2) If a leaf node is encountered then return 1
     * 3) Repeat the process with left and right subtree
     * 4) Return the sum of leaf nodes from both left and right subtree
     */
    private static int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.isLeaf())
            return 1;
        else
            return countLeaves(node.left) + countLeaves(node.right);
    }
    
    /**
     * Iterative
     *
     * 1) if the root is null then return zero.
     * 2) Start the count with zero
     * 3) push the root into Stack
     * 4) loop until Stack is not empty
     * 5) pop the last node and push left and right children of the last node if they are not null.
     * 6) Increase the count
     *
     * At the end of the loop, the count contains the total number of leaf nodes. Here is the sample code based upon the above logic and algorithm:
     */
    private static int countLeavesIteratively(Node node) {
        if (node == null)
            return 0;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        int count = 0;
        
        while (!stack.isEmpty()) {
            Node treeNode = stack.pop();
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.isLeaf())
                count++;
        }
        return count;
    }
    
    private static void printLeafNodes(Node node) {
        //base case
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.printf("%s ",node.data);
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }
    
    private static void printLeafNodesIteratively(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node<String>> stack = new Stack();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left == null && node.right == null) {
                System.out.printf("%s ",node.data);
            }
        }
        System.out.println();
    }
    
    /**
     * Anyway, here are the exact steps of iterative pre-order traversal in Java:
     *
     *     Create an empty stack
     *     Push the root into Stack
     *     Loop until Stack is empty
     *     Pop the last node and print its value
     *     Push right and left node if they are not null
     *     Repeat from step 4 to 6 again.
     * @param root
     */
    private static void preorderIterative(Node root) {
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        
        while (!nodes.isEmpty()) {
            Node current = nodes.pop();
            System.out.printf("%s ",current.data);
            
            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }
        System.out.println();
    }
    
    /**
     * Closest Binary Search Tree Value -> Recursion
     *
     * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target
     */
    static int goal;
    static double min = Double.MAX_VALUE;
    public static int closestValue(Node root, double target) {
        helper(root, target);
        return goal;
    }
    private static void helper(Node<Double> root, double target) {
        if (root == null) return;
        if (Math.abs(root.data - target) < min) {
            min = Math.abs(root.data - target);
            goal = root.data.intValue();
        }
        if (target < root.data) {
            helper(root.left, target);
        } else {
            helper(root.right, target);
        }
    }
    
    /**
     * Closest Binary Search Tree Value -> Iteration
     * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target
     */
    public int closestValueIteration(Node<Double> root, double target) {
        double min = Double.MAX_VALUE;
        int result = root.data.intValue();
        
        while (root != null) {
            if (target > root.data) {
                double diff = Math.abs(root.data - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.data.intValue();
                } else if (target < root.data) {
                    if (diff < min) {
                        min = Math.min(min, diff);
                        result = root.data.intValue();
                    }
                } else {
                    return root.data.intValue();
                }
            }
        }
        return result;
    }
    
    /**
     * Preorder binary tree traversal is a classic interview problem. The key to solve this problem is using a stack to
     * store left and right children, and push right child first so that it is processed after the left child.
     * @param root
     * @return
     */
    public static ArrayList<Integer> preorderTraversal(Node<Integer> root) {
        ArrayList<Integer> list =  new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();
            list.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
    
    public static ArrayList<Integer>preorder2(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> S = new Stack<>();
        if (root == null) return res;
        Node curr = root;
        S.push(curr);
        
        while (S.size() > 0) {
            curr = S.pop();
            res.add((int)curr.data);
            if (curr.right != null)
                S.push(curr.right);
            if (curr.left != null)
                S.push(curr.left);
        }
        return res;
    }
    
    public static ArrayList<Integer> postOrderIterativeTraversal(Node<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
        
        }
        return list;
    }
    
    /**
     * Height of a binary tree is the total number of nodes present on the longest path from the root to a leaf node.
     * The idea is traverse the tree in a postorder fashion and calculate the left and right subtree's height.
     * The height of a subtree rooted at any node will be one more than the maximum height of its left and right subtree. Recusively apply
     * this property to all tree nodes in a bottom-up manner (postorder) and return the maximum height of the subtree
     * rooted at that node.
     *
     * For typical binary trees, the left and right children of a leaf node are null pointers. But here, the left and right child of a leaf
     * nodes act like the previous and next pointer of the circular doubly linked list. For a node to be a leaf node, check if its
     * left's right and right's left are pointing to the node itself.
     */
    // Recursive function to calculate the height of a binary tree with
    // leaf nodes forming a circular doubly linked list
    public static int height(Node node)
    {
        // base case: if the node is null
        if (node == null) {
            return 0;
        }
    
        // node is a leaf if its left's right and right's left
        // are pointing to the node itself
        if ((node.left != null && node.left.right == node) &&
                (node.right != null && node.right.left == node)) {
            return 1;
        }
    
        // recur for the left and right subtree and consider maximum depth
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    /**
     * Find minumum depth of a binary tree
     * Given a binary tree, find its minimum depth. The depth is the total number of nodes along the shortest path
     * from the root node down to the nearest lead node.
     *
     * The idea is to traverse the tree in a bottom up manner using post order traversal and calculate the minimum depth
     * of left and right subtree for each encountered node. The minimum depth of the subtree rooted at any node is one more
     * than the minumum depth of its left and right subtree. if either left or right subtree does not exist for a node, consider
     * the minumym depth returned by the other subtree.
     */
    int findMinDepth(Node root) {
        //base case
        if (root == null) {
            return 0;
        }
        
        //find the minimum depth of the left subtree
        int l = findMinDepth(root.left);
        
        //find the minimum depth of the right subtree
        int r = findMinDepth(root.right);
        
        //if the left child does not exist, consider the depth returned by the right subtree
        if (root.left == null)
            return 1 + r;
        
        // if the right child does not exist, consider the depth returned by the left subtree
        if (root.right == null)
            return 1 + l;
        
        //otherwise, choose the minimum depth returned by the left and right subtree
        return Math.min(l, r) + 1;
    }
    
    /**
     * The idea is to traverse the tree using BFS instead of DFS. Then the procedure can be terminated upon
     * encountering the first leaf node closest to the root.
     *
     * The standard algorithm for performing BFS on trees is level order traversal.
     */
    int findMinDepth2(Node root) {
        // base case
        /*if (root == null) {
            return 0;
        }
    
        // create an empty queue and push the root node with a depth of 1
        Queue<QueueNode> q = new ArrayDeque<>();
        q.add(new QueueNode(root, 1));
    
        // run till queue is empty`
        while (!q.isEmpty())
        {
            // dequeue front node
            Node node = q.peek().node;
            int depth = q.peek().depth;
        
            q.poll();
        
            // if the popped node is a leaf node, return its depth
            if (isLeaf(node)) {
                return depth;
            }
        
            // enqueue left child of the popped node with +1 depth
            if (node.left != null) {
                q.add(new QueueNode(node.left, depth + 1));
            }
        
            // enqueue right child of the popped node with +1 depth
            if (node.right != null) {
                q.add(new QueueNode(node.right, depth + 1));
            }
        }*/
        return 0;
    }
    boolean isBalancedTree(Node root) {
        //base case
        if (root == null)
            return true;
        
        int l = height2(root.left);
        int r = height2(root.right);
        
        if (Math.abs(l -r ) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right)) {
            return true;
        }
        return false;
    }
    
    int height2(Node node) {
        if (node == null)
            return 0;
        
        return 1 + Math.max(height2(node.left), height2(node.right));
    }
    
    int findMax(Node<Integer> node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }
    void printKDistant(Node node, int k) {
        if (node == null) return;
        
        if (k == 0) {
            System.out.print(node.data+" ");
            return;
        } else {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }
    
    int widthOfBinaryTree(Node node) {
        max_width = 0;
        leftmost_positions = new HashMap<>();
        get_width(node, 0, 0);
        return max_width;
    }
    void get_width(Node node, int depth, int position) {
        if (node == null) return;
        leftmost_positions.computeIfAbsent(depth, x -> position);
        max_width = Math.max(max_width, position-leftmost_positions.get(depth) +1);
        get_width(node.left, depth+1, position*2);
        get_width(node.right, depth+1, position*2+1);
    }
    
    /**
     * Print Right View of a Binary Tree
     * Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.
     *
     * Right view of following tree is 1 3 7 8
     *
     *           1
     *        /     \
     *      2        3
     *    /   \     /  \
     *   4     5   6    7
     *                   \
     *                    8
     *
     *  The Right view contains all nodes that are last nodes in their levels.
     *  A simple solution is to do level order traversal and print the last node in every level.
     *
     * The problem can also be solved using simple recursive traversal. We can keep track of level of a node by passing a parameter to all recursive calls.
     * The idea is to keep track of maximum level also. And traverse the tree in a manner that right subtree is visited before left subtree.
     * Whenever we see a node whose level is more than maximum level so far, we print the node because this is the last node in its level (Note that we traverse the right subtree before left subtree).
     */
    static void rightViewUtil(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                // print the right most element at the level
                if (i == n)
                    System.out.print(temp.data+" ");
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }
    /**
     * Print Nodes in Top View of Binary Tree
     * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
     * Given a binary tree, print the top view of it. The output nodes can be printed in any order.
     *
     * A node x is there in output if x is the topmost node at its horizontal distance.
     * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
     *
     *        1
     *     /     \
     *    2       3
     *   /  \    / \
     *  4    5  6   7
     * Top view of the above binary tree is
     * 4 2 1 3 7
     *
     *         1
     *       /   \
     *     2       3
     *       \
     *         4
     *           \
     *             5
     *              \
     *                6
     * Top view of the above binary tree is
     * 2 1 3 6
     *
     * The idea is to do something similar to vertical Order Traversal.
     * Like vertical Order Traversal, we need to put nodes of same horizontal distance together.
     * We do a level order traversal so that the topmost node at a horizontal node is visited before any other node of same horizontal distance below it.
     * Hashing is used to check if a node at given horizontal distance is seen or not.
     */
    static void topView(Node root) {
    
    }
    /**
     * Approach 1
     * Lowest Common Ancestor
     * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
     * The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
     * Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree:
     * the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.
     *
     * Approach 1: Recursive Approach
     * Intuition
     *
     * The approach is pretty intuitive. Traverse the tree in a depth first manner. The moment you encounter either of the nodes p or q, return some boolean flag. The flag helps to determine if we found the required nodes in any of the paths. The least common ancestor would then be the node for which both the subtree recursions return a True flag. It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.
     *
     * Let us look at the formal algorithm based on this idea.
     *
     * Algorithm
     *
     * Start traversing the tree from the root node.
     * If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
     * If either of the left or the right branch returns True, this means one of the two nodes was found below.
     * If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
     *
     * 1 --> 2 --> 4 --> 8
     * BACKTRACK 8 --> 4
     * 4 --> 9 (ONE NODE FOUND, return True)
     * BACKTRACK 9 --> 4 --> 2
     * 2 --> 5 --> 10
     * BACKTRACK 10 --> 5
     * 5 --> 11 (ANOTHER NODE FOUND, return True)
     * BACKTRACK 11 --> 5 --> 2
     *
     * 2 is the node where we have left = True and right = True and hence it is the lowest common ancestor.
     */
    private TreeNode ans;
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
    
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }
    
        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
    
        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
    
        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
    
    
        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
    
        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
    /**
     * Approach 2
     * Iterative using parent pointers
     * Intuition
     *
     * If we have parent pointers for each node we can traverse back from p and q to get their ancestors. The first common node we get during this traversal would be the LCA node. We can save the parent pointers in a dictionary as we traverse the tree.
     *
     * Algorithm
     *
     * Start from the root node and traverse the tree.
     * Until we find p and q both, keep storing the parent pointers in a dictionary.
     * Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
     * Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p, this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
    
        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();
    
        parent.put(root, null);
        stack.push(root);
    
        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
        
            TreeNode node = stack.pop();
        
            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
    
        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();
    
        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
    
        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
    
    /**
     * Given the root of a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     * Input: root = [1,2,3,null,5,null,4]
     * Output: [1,3,4]
     * Example 2:
     *
     * Input: root = [1,null,3]
     * Output: [1,3]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     * @param root
     * @return
     */
    static List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    static void rightView(Node current, List<Integer> result, int curDepth) {
        if (current == null)
            return;
        if (curDepth == result.size())
            result.add((Integer) current.data);
        rightView(current.right, result, curDepth + 1);
        rightView(current.left, result, curDepth + 1);
    }
    
}

/**
 * https://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
 * https://www.programcreek.com/2014/04/leetcode-binary-tree-longest-consecutive-sequence-java/
 * https://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
 * https://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/
 *
 * https://medium.com/@zhongjie.ruan/leetcode-76-minimum-window-substring-b4798b5827fd
 * https://leetcode.com/problems/minimum-window-substring/solution/
 * https://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/
 * https://www.techiedelight.com/Category/Trees/Binary-Tree/page/4/
 */
