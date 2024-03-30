import org.junit.jupiter.api.Test;

public class DiameterBinaryTree {

    @Test
    public void BinaryTreeDiameterTest() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
    }

    @Test
    public void inorderTest() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();
        binaryTreeDiameter.inorder(node);
    }
}
