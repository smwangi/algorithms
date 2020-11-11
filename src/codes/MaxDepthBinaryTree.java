
public class MaxDepthBinaryTree {

    public static void main(String[] args) {

        MaxDepthBinaryTree depthBinaryTree = new MaxDepthBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right =  new TreeNode(7);

        System.out.println(depthBinaryTree.maxDepth(root));
        System.out.println(depthBinaryTree.minDepth(root));
    }

    public int maxDepth(TreeNode root) {

        if(root == null)return 0;

        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {

        if(root == null)return 0;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;

        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}
