import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, print its nodes level by level in spiral order.
 * All nodes present at level 1 should be printed first from left to right, followed by nodes of level 2 from right to left,
 * followed by nodes of level 3 from left to right and so on.
 * i.e odd levels should be printed from left to right, even levels should be printed from right to left.
 */
public class SpiralOrderBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        SpiralLevelOrderTraversal(root);
    }
    public static void SpiralLevelOrderTraversal(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //Create a double-ended queue and enqueue the root node
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        //Flag is used to differentiate between odd and even
        boolean flag = true;
        //loop till deque is empty
        while (!deque.isEmpty()) {
            //calculate the number of nodes at current level
            int nodeCount = deque.size();

            //print left to right
            if (flag) {
                // process each node of the current level and enqueue their non-empty
                // left and right child to deque
                while (nodeCount > 0) {
                    // pop from the front if the flag is true
                    TreeNode current = deque.pollFirst();
                    System.out.print(current.val + " ");
                    // push the left child into the back followed by the right child.
                    if (current.left != null) {
                        deque.addLast(current.left);
                    }
                    if (current.right != null) {
                        deque.addLast(current.right);
                    }
                    nodeCount--;
                }
            }
            //print right to left
            else {
                //process each node of the current level and enqueue their non-empty right and left child.
                while (nodeCount > 0) {
                    //pop from the back
                    TreeNode current = deque.pollLast();
                    System.out.print(current.val + " ");
                    //push the right node to the front followed by left node
                    if (current.right != null) {
                        deque.addFirst(current.right);
                    }
                    if (current.left != null) {
                        deque.addFirst(current.left);
                    }
                    nodeCount--;
                }
            }
            // flip the flag for the next level
            flag = !flag;
            System.out.println();
        }
    }
}
