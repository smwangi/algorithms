package codes;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */
public class MinAbsDiffBST {

    int minDiff;
    Integer prev = 0;
    public static void main(String[] args) {

        TreeNode node = new TreeNode();
        node.val = 1;
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(2);
        MinAbsDiffBST minAbsDiffBST = new MinAbsDiffBST();
        minAbsDiffBST.getMinimumDifference(node);
    }

    private int getMinimumDifference(TreeNode root){
       prev = null;
       minDiff = Integer.MAX_VALUE;
       inOrder(root);
       System.out.println(minDiff);
        return minDiff;
    }

    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(prev != null && Math.abs(prev - root.val) < minDiff)
            minDiff = Math.abs(prev - root.val);
        prev = root.val;
        inOrder(root.right);
    }
}
