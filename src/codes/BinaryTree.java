import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
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
        
        System.out.println(countLeaves(root));
        System.out.println(countLeavesIteratively(root));
        printLeafNodes(root);
        printLeafNodesIteratively(root);
        preorderIterative(root);
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
 */
