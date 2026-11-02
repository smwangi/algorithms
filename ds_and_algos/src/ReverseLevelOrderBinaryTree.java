/**
 * Given a binary tree, print its nodes level by level in reverse order.
 *
 * Simple solution would to print all nodes of level h first, followed by h-1, until level 1, where h is the
 * tree's height. We can print all nodes present in a level by modifying the preorder traversal on the tree.
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
public class ReverseLevelOrderBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        ReverseLevelOrderTraversal(root);
    }

    static void ReverseLevelOrderTraversal(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //Create an empty Queue and enqueue the root node
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        //Create a stack to reverse level order nodes
        Deque<Integer> stack = new ArrayDeque<>();
        // loop till queue is empty
        while (!queue.isEmpty()) {
            // process each node in the queue and enqueue their children
            TreeNode curr = queue.poll();
            // push the current node into the stack
            stack.push(curr.val);
            //Process the right node before the left node
            if (curr.right != null) {
                queue.add(curr.right);
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
        }
        //pop all nodes from stack
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
    }
}
