
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBST {

    Integer prev = null;
    boolean ans = true;

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        validateBST.isValidBST(root);
    }
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        System.out.println(ans);
        return ans;
    }
    
    /**
     * Since inorder traversal of BST is ascending, so we can check the sequence. Time is O(n) and space is O(h).
     * h is the height of the stack which is the tree's height.
     * @param root
     */
    private void inOrder(TreeNode root){
        if(root ==  null) return;

        inOrder(root.left);
        if(prev != null)
            if(root.val <= prev){
                ans = false;
                return;
            }
        System.out.println(prev+" <> "+root.val);
        prev = root.val;
        //System.out.println(prev+" <> "+root.val);
        inOrder(root.right);
    }
    
    /**
     * Java Solution 1 - Recursive
     *
     * All values on the left sub tree must be less than parent and parent's parent,
     * and all values on the right sub tree must be greater than parent and parent's parent.
     * So we just check the boundaries for each node.
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
    public boolean isValidBST2(TreeNode p, double min, double max) {
        if (p == null) {
            return true;
        }
        
        if(p.val <= min || p.val >= max) return false;
        
        return isValidBST2(p.left, min, p.val) && isValidBST2(p.right, p.val, max);
    }
    
    
}
