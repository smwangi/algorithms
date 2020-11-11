import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class TreeFindMode {
    Integer prev = null;
    int max = Integer.MIN_VALUE;
    int cnt = 0;

    public static void main(String[] args) {
        TreeFindMode fMode = new TreeFindMode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        fMode.findMode(root);
    }
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        int[] res = new int[ans.size()];
        for(int i=0; i < ans.size();i++)
            res[i] = ans.get(i);

        System.out.println(Arrays.toString(res));
        return res;
    }
    private void inOrder(TreeNode root, List<Integer> ans){
        if(root == null)
            return;

        inOrder(root.left,ans);
        if (prev == null || root.val != prev) cnt = 1;
        else if (prev == null || root.val == prev) cnt++;
        prev = root.val;
        if (cnt > max) {
            ans.clear();
            ans.add(prev);
            max = cnt;
        }
        else if (cnt == max){
            ans.add(prev);
        }
        inOrder(root.right, ans);
    }
}
