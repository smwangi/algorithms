import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree, print its left view.
 */
public class LeftViewBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        LeftView(root);
    }

    /**
     * iterative Implementation
     * In the iterative version, perform a level order traversal on the tree. If the current node is the first
     * node of the current level, print it.
     */
    public static void LeftView(TreeNode root) {
        //Base case
        if (root == null) {
            return;
        }
        //Create an empty tree and enqueue root node
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode curr;

        while (!queue.isEmpty()) {
            // Calculate the total number of nodes at the current level
            int size = queue.size();
            int i = 0;
            //process every node of the current level and enqueue their
            //non-empty left and right child
            while (i++ < size) {
                curr = queue.poll();
                // if this is the first node of the current level, print it.
                if (i == 1) {
                    System.out.print(curr.val+ " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}
