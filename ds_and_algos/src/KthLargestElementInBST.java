/**
 * The second largest element is second last element in inorder traversal and second element in reverse inorder traversal.
 * We traverse given Binary Search Tree in reverse inorder and keep track of counts of nodes visited. Once the count becomes 2,
 * we print the node.
 */
public class KthLargestElementInBST {

    //Node Count
    int count  = 0;

    /**
     * /* Let us create following BST
     *               50
     *            /     \
     *           30      70
     *          /  \    /  \
     *        20   40  60   80
     *
     *        Time complexity of the above solution is O(h) where h is height of BST.
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new KthLargestElementInBST().new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);

        KthLargestElementInBST kth = new KthLargestElementInBST();
        kth.secondLargestUtil(binarySearchTree.root);
    }
    void secondLargestUtil(Node node){
        //Bases avoid unnecessary recursive calls
        if(node == null || count >= 2)
            return;

        //Follow reverse inorder traversal so that the largest element is visited first
        this.secondLargestUtil(node.right);

        //increment count of visited node
        count++;
        //If count becomes k, this is the 2nd largest
        if(count == 2){
            System.out.println("2nd Largest element is "+node.value);
            return;
        }
        //Recur for the left tree
        this.secondLargestUtil(node.left);
    }
    class Node{
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            left = right = null;
        }
    }

    class BinarySearchTree{

        //Root node
        Node root;

        //Constructor
        BinarySearchTree(){
            root = null;
        }
        //function to insert new nodes
        public void insert(int value){
            this.root = this.insertRec(this.root,value);
        }

        /* A utility function to insert a new node with given
        key in BST */
        Node insertRec(Node node, int value){
            /* If the tree is empty, return a new node */
            if(node == null){
                this.root = new Node(value);
                return this.root;
            }
            //Otherwise recur down  the tree
            if(value < node.value){
                node.left = this.insertRec(node.left,value);
            }else {
                node.right = this.insertRec(node.right,value);
            }
            return node;
        }

    }
}
