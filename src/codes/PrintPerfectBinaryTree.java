import java.util.ArrayDeque;
import java.util.Queue;
/**
 * Given a perfect binary tree, print the values of alternating left and right nodes for each level in a
 * top-down and bottom-up manner
 */
public class PrintPerfectBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * The Idea is to maintain two queues. We process two nodes each from one queue and enqueue the left and right child
     * of the first popped node into the first queue and the right and left child of the second popped node into the second queue.
     * @param root
     */
    static void PrintNodesTopDown(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        //print the root node
        System.out.print(root.val+ " ");

        //Create two empty queues and enqueue root's left and right child respectively.
        Queue<TreeNode> first = new ArrayDeque<>();
        Queue<TreeNode> second = new ArrayDeque<>();
    }
}
