/**
 * Given a binary tree compute the length of the tree's diameter. The diameter of a binary tree
 * is the length of the longest path between any two nodes. This path may or may not pass through the root.
 */

public class BinaryTreeDiameter {

    /*
        POST Order Traversal
     * Traverse the tree recursively in POST Order (Left -> right then root)
     * At every node, calculate height of left and right subtrees
     * Calculate diameter using above.
     * return height of current node to previous recursive call.
     */
    public  int diameterOfBinaryTree(TreeNode root) {
        int diameter = Integer.MIN_VALUE;
        heightOfBinaryTree(root, diameter);
        return diameter;
    }

    private int heightOfBinaryTree(TreeNode node, int diameter) {

        if (node == null) {
            return 0;
        }

        int lh = heightOfBinaryTree(node.left, diameter);
        int rh = heightOfBinaryTree(node.right, diameter);

        diameter = Math.max(diameter, lh+rh);

        return 1 + Math.max(lh, rh);
    }

    public int inorder(TreeNode root) {
        //height(root, 0, 0);
        //inorderHelper(root);
        int diameter = Integer.MIN_VALUE;
        heightOfBinaryTree(root, diameter);
        return -1;
    }

    public int height(TreeNode node, int l, int r) {
        if (node == null) return 0;

        height(node.left, l+1, r);
        height(node.right, l, r+1);

        int diameter = l + r;
        System.out.println("Node Val= "+node.val+" LH= "+l+" RH= "+r+ " Diameter= "+diameter);
        System.out.println();

        return diameter;
    }

    private int inorderHelper(TreeNode root) {

        if (root == null) return 0;

        int lh = inorderHelper(root.left);

        int rh = inorderHelper(root.right);

        int height = 1 + Math.max(lh, rh);
        System.out.println("Node Val= "+root.val+" LH= "+lh+" RH= "+rh+ " Height= "+height);
        System.out.println();
        return height;
    }

}
