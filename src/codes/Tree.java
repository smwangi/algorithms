import java.util.Stack;

/**
 * Tree
 */
public class Tree {

    public static void main(String[] args) {
        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");
        Node<String> G = new Node<String>("G");
        Node<String> H = new Node<String>("H");
        Node<String> I = new Node<String>("I");
        Node<String> J = new Node<String>("J");
        Node<String> K = new Node<String>("K");

        //Root and Building  of the tree
        Node<String> root = A;
        A.left  =   B; A.right = C;
        B.left  =   D; B.right = E;
        D.left  =   H; D.right = I;
        E.left  =   J; 
        C.left  =   F; C.right = G;
        G.left  =   K;

        preOrder(root);
        iterativePreOrder(root);

        System.out.println("In Order: Left, Root, Right");
        inOrder(root);
        System.out.println("In Order: Left, Root, Right");
        iterativeInOrderTraverse(root);
    }

    //Root Left Right
    //Recursive Function
    public static <T> void preOrder(Node<T> node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Displaying data 
     * Pushing its right child in the Stack
     * Pushing its left child in the Stack
     * @param <T>
     * @param data
     */
    public static <T> void iterativePreOrder(Node<T> data){
        if(data ==  null)
            return;
        
        //Create an empty stack and push root node to it
        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(data);

        // We pop all items one by one. 
        // For each item, we make the following steps : print data, push its right child, push its left child
        // We push right child in first for that left is processed first
        while(!nodeStack.empty()){
            Node<T> currentNode = nodeStack.pop();
            System.out.print(currentNode.data+" ");

            if(currentNode.right != null){
                nodeStack.push(currentNode.right);
            }

            if(currentNode.left != null){
                nodeStack.push(currentNode.left);
            }
        }
    } 

    //Left, Root, Right
    public static <T> void inOrder(Node<T> node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    /**
     * 
     */
    public static <T> void iterativeInOrderTraverse(Node<T> node){
        if(node == null)
            return;
        //Create an empty stack
        Stack<Node<T>> nodeStack = new Stack<>();

        Node<T> currentNode = node;
        //Traverse the tree
        while(currentNode != null || nodeStack.size() > 0){
            //Reach the leftmost node of the current node
            while(currentNode != null){
                //We add pointer  to the  stack before traversing  the left node
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            //Current node is null at this point
            currentNode = nodeStack.pop();
            System.out.print(currentNode.data+" ");
            //Visit the right node
            currentNode = currentNode.right;
        }
    }
}