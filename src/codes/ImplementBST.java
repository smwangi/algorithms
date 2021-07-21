public class ImplementBST {
    TreeNode root;
    public ImplementBST() {
        root = null;
    }
    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 6, 4, 3};
    }
    
    static void implementBST(int[] nums) {
    
    }
    public void insert(int key) {
        this.root = insertRec(this.root, key);
    }
    
    TreeNode insertRec(TreeNode currentNode, int key) {
        if (currentNode == null) {
            currentNode = new TreeNode(null, null, key);
            return currentNode;
        }
        if (key < currentNode.getVal()) {
            currentNode.setLeft(insertRec(currentNode.getLeft(), key));
        } else if (key > currentNode.getVal()) {
            currentNode.setRight(insertRec(currentNode.getRight(), key));
        }
        return currentNode;
    }
    
    public void remove(int key) {
        this.root = removeRec(this.root, key);
    }
    
    TreeNode removeRec(TreeNode currentNode, int key) {
        if (currentNode == null) {
            return currentNode;
        }
        if (key < currentNode.getVal()) {
            currentNode.setLeft(removeRec(currentNode.getLeft(), key));
        } else if (key > currentNode.getVal()) {
            currentNode.setRight(removeRec(currentNode.getRight(), key));
        } else {
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            }
            currentNode.setVal(minVal(currentNode.getRight()));
            currentNode.setRight(removeRec(currentNode.getRight(), currentNode.getVal()));
        }
        return currentNode;
    }
    
    private int minVal(TreeNode currentNode) {
        int min = currentNode.getVal();
        while (currentNode.getLeft() != null) {
            min = currentNode.getLeft().getVal();
            currentNode = currentNode.getLeft();
        }
        return min;
    }
    
    class TreeNode {
        TreeNode left, right;
        int val;
        
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    
        public int getVal() {
            return val;
        }
    
        public void setVal(int val) {
            this.val = val;
        }
    
        public TreeNode getLeft() {
            return left;
        }
    
        public void setLeft(TreeNode left) {
            this.left = left;
        }
    
        public TreeNode getRight() {
            return right;
        }
    
        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
