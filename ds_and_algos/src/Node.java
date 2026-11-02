/**
 * Node
 */
public class Node<T> {

    T data;
    Node<T> left;//Left node
    Node<T> right; // Right node

    public Node(T data) {
        this.data = data;
    }
    
    public boolean isLeaf() {
        return left == null ? right == null:false;
    }
}