/**
 * The worst case time complexity of search and insert operations is O(h) where h is the height of the Binary Search Tree.
 * In the worst case, we may have to travel from root to the deepest leaf node. The height of a skewed tree may become n and the
 * time complexity of search and insert operations may become O(n).
 *
 * Inorder traversal of BST always produces sorted output.
 *
 * We can construct a BST with only Preorder or Postorder or Level Order traversal. Note that we can always get inorder
 * traversal by sorting the only given traversal.
 */
public class BST {
    Node root;
    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);
        tree.inorder();
    }
    
    /**
     *
     * 1. Start from the root.
     * 2. Compare the searching element with root, if less than root, then recurse for left, else recurse for right.
     * 3. If the element to search is found anywhere, return true, else return false.
     *
     */
    Node search(Node root, int key) {
        if (root == null || root.val == key)
            return root;
        
        if (root.val < key) {
            return search(root.right, key);
        }
        // Key is smaller than root val
        return search(root.left, key);
    }
    
    /**
     * Insertion of a key
     * A new key is always inserted at the leaf. We start searching a key from the root until we hit a leaf node.
     * Once a leaf node is found, the new node is added as a child of the leaf node.
     */
    
    void insert(int key) {
        root = insert(root, key);
    }
    Node insert(Node root, int key) {
        //if tree is empty return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // Otherwise recur down the tree
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.left, key);
        }
        return root;
    }
    
    void insertLoop(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node prev = null;
        Node temp = root;
        while (temp != null) {
            if (temp.val > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.val < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.val > key)
            prev.left = node;
        else prev.right = node;
    }
    
    // This method mainly calls InorderRec()
    void inorder()
    {
        inorderRec(root);
    }
    
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.val);
            inorderRec(root.right);
        }
    }
    
    class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
}

