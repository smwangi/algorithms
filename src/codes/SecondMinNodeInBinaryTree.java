import java.util.*;
/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes. More formally,
 * the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 * Example 2:
 *
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinNodeInBinaryTree {


    public static void main(String[] args) {

        SecondMinNodeInBinaryTree binaryTree = new SecondMinNodeInBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(binaryTree.findSecondMinimumValue(root));
    }
    /**
     * Approach #1: Brute Force [Accepted]
     * Intuition and Algorithm
     *
     * Traverse the tree with a depth-first search, and record every unique value in the tree using a Set structure uniques.
     *
     * Then, we'll look through the recorded values for the second minimum. The first minimum must be root.val.
     */
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        uniques.forEach(System.out::println);
        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans)
                ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
