public class ImplementBST {
    TreeNode root;
    Node nRoot;
    public ImplementBST() {
        root = null;
        nRoot = null;
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
    
    //delete a node from BST
    void deleteKey(int key) {
        nRoot = delete_recursive(nRoot, key);
    }
    Node delete_recursive(Node root, int key) {
        // tree is empty
        if (root == null) {
            return root;
        }
        // traverse the tree
        if (key < root.key) {//traverse the left subtree
            root.left = delete_recursive(root.left, key);
        } else if (key > root.key) { // traverse the right subtree
            root.right = delete_recursive(root.right, key);
        } else {
            // node contains only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // node has two children
            // get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);
            // delete the inorder successor
            root.right = delete_recursive(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root) {
       // initially minVal = root.
       int minVal = root.key;
       while (root.left != null) {
           minVal = root.left.key;
           root = root.left;
       }
       return minVal;
    }
    //Insert node in BST
    void nodeInsert(int key) {
        nRoot = nodeInsert_recursive(nRoot, key);
    }
    Node nodeInsert_recursive(Node root, int key) {
        // tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // traverse the tree
        if (key < root.key) { // insert in the left subtree
            root.left = nodeInsert_recursive(root.left, key);
        } else if (key > root.key) { // insert in the right subtree
            root.right = nodeInsert_recursive(root.right, key);
        }
        return root;
    }
    
    boolean search(int key) {
        nRoot = search_recursively(nRoot, key);
        if (nRoot != null)
            return true;
        else
            return false;
    }
    
    Node search_recursively(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }
        // if root val is greater than root's key
        if (root.key > key) {
            return search_recursively(root.left, key);
        }
        return search_recursively(root.right, key);
    }
    
    // inorder traversal of BST
    void inorder() {
        inorder_recursive(nRoot);
    }
    void inorder_recursive(Node nRoot) {
        if (nRoot != null) {
            inorder_recursive(nRoot.left);
            System.out.println(nRoot.key);
            inorder_recursive(nRoot.right);
        }
    }
    
    // Post order traversal: - Left -> Right -> root
    void postOrder(Node nRoot) {
        if (nRoot == null)
            return;
        // traverse left subtree recursively
        postOrder(nRoot.left);
        // then traverse right subtree recursively
        postOrder(nRoot.right);
        // process the root
        System.out.println(nRoot.key);
    }
    
    void preOrder(Node nRoot) {
        if (nRoot == null)
            return;
        // first print root node first
        System.out.println(nRoot.key+" ");
        preOrder(nRoot.left);
        preOrder(nRoot.right);
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
    
    class Node {
        int key;
        Node left, right;
        
        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
