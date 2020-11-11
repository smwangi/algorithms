
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
    private void inOrder(TreeNode root){
        if(root ==  null)return;

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
}
