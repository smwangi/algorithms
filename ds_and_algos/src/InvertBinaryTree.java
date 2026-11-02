import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {
    public static void main(String[] args) {
    /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
    
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(invertTree(root));
        System.out.println(invertIterative(root).toString());
        preorder(invertIterative(root));
    }
    //Recursive
    //The time complexity of this solution is O(n), where n is the total  number of nodes in the binary tree.
    //The program requires O(h) extra space for the call stack, where h  is the height of the tree.
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        
        return root;
    }
    
    //Iterative approach
    private static TreeNode invertIterative(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        // maintain a queue and push the root node
        if (root != null) {
            queue.add(root);
        }
        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node
            TreeNode p = queue.poll();
            // enqueue left child of the popped node
            if(p.left != null) {
                queue.add(p.left);
            }
            // enqueue right child of the popped node
            if (p.right != null) {
                queue.add(p.right);
            }
            // swap the left child with the right child
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        return root;
    }
    //Using Stack
    private static TreeNode usingStack(TreeNode root) {
        if(root == null) return null;
    
        Deque<TreeNode> stack = new ArrayDeque<>();
        //add root to stack
        stack.add(root);
        //loop till stack is empty
        while (!stack.isEmpty()) {
            // pop the top node from the stack
            TreeNode curr = stack.pollLast();
            
            //swap the left with the right child
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
    
            // enqueue right child of the popped node
            if(curr.right != null) stack.add(curr.right);
            // push the left child of the popped node into the stack
            if(curr.left != null) stack.add(curr.left);
        }
        return root;
    }
    
    private static void preorder(TreeNode root) {
        if(root == null)return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
