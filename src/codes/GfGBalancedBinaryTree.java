/* Java program to determine if binary tree is
   height balanced or not */

/* A binary tree node has data, pointer to left child,
   and a pointer to right child */
/*
* To check if a tree is height-balanced, get the height of left and right subtrees.
* Return true if difference between heights is not more than 1 and left and right subtrees are balanced,
* otherwise return false.
* */


public class GfGBalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new GfGBalancedBinaryTree(). new BinaryTree();
        tree.root = new GfGBalancedBinaryTree().new Node(1);
        tree.root.left = new GfGBalancedBinaryTree().new Node(2);
        tree.root.right = new GfGBalancedBinaryTree().new Node(3);
        tree.root.left.left = new GfGBalancedBinaryTree().new Node(4);
        tree.root.left.right = new GfGBalancedBinaryTree().new Node(5);
        tree.root.left.left.left = new GfGBalancedBinaryTree().new Node(8);

        if(tree.isBalanced(tree.root))
            System.out.println("Tree is Balances");
        else
            System.out.println("Tree is not Balanced");

        Height height = new GfGBalancedBinaryTree().new Height();
        BinaryTreeOptimized tree1 = new GfGBalancedBinaryTree().new BinaryTreeOptimized();
        tree1.root = new GfGBalancedBinaryTree().new Node(1);
        tree1.root.left = new GfGBalancedBinaryTree().new Node(2);
        tree1.root.right = new GfGBalancedBinaryTree().new Node(3);
        tree1.root.left.left = new GfGBalancedBinaryTree().new Node(4);
        tree1.root.left.right = new GfGBalancedBinaryTree().new Node(5);
        tree1.root.right.right = new GfGBalancedBinaryTree().new Node(6);
        tree1.root.left.left.left = new GfGBalancedBinaryTree().new Node(7);

        if (tree1.isBalanced(tree1.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            left=right=null;
        }

    }
    //Create a Binary tree
    class BinaryTree{
        Node root;
        //Time Complexity: O(n^2) Worst case occurs in case of skewed tree.
        boolean isBalanced(Node node){
            int lh;//Left tree height.
            int rh;//Right tree height.

            //if tree is empty return true;
            if(node == null)
                return true;

            lh = height(node.left);
            rh = height(node.right);

            if(Math.abs(lh-rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
                return true;

            return false;
        }
    }
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(Node node){
        //Base case if tree is empty
        if(node == null)
            return 0;
        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1+ Math.max(height(node.left),height(node.right));
    }

    /**
     * Optimized implementation: Above implementation can be optimized by calculating the height
     * in the same recursion rather than calling a height() function separately.
     */
    class Height{
        int height = 0;
    }

    class BinaryTreeOptimized{
        Node root;
        boolean isBalanced(Node root, Height height){
            if(root == null){
                height.height = 0;
                return true;
            }
            //Get heights of left and right sub trees
            Height lheight = new Height();
            Height rheight = new Height();
            boolean l = isBalanced(root.left,lheight);
            boolean r = isBalanced(root.right,rheight);

            int lh = lheight.height;
            int rh = rheight.height;

            /* Height of current node is max of heights of
           left and right subtrees plus 1*/
            height.height = (lh > rh ? lh : rh)+1;

            /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
            if(Math.abs(lh - rh) >= 2)
                return false;
            else
                return l && r;
        }
    }
}
