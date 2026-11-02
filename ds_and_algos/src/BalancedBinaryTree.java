/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        TreeNode root = new TreeNode();
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right =  new TreeNode(7);

        System.out.println(balancedBinaryTree.isBalanced(root));
        System.out.println(maxDepth(root));
    }

    public boolean isBalanced(TreeNode root) {

        int lh = 0, rh = 0;
        if (root == null)
            return true;

        lh = height(root.left);
        rh = height(root.right);
        
        if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    private int height(TreeNode node){

        if(node == null)
            return 0 ;

        return 1 + Math.max(height(node.left), height(node.right));
    }
    boolean balance = true;
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return balance;
        }
        isBalancedHelper(root);
        return balance;
    }
    
    public int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        
        if (Math.abs(left - right) > 1) balance = false;
        return 1 + Math.max(left, right);
    }
    
    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }
}
