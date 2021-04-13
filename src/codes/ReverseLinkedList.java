public class ReverseLinkedList {
    static public Node head;
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
        
        list.reverseList(head);
        list.reverseRecursively(head);
    }
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
        //Reverse
        public Node reverse(Node node) {
            Node prev = null;
            Node current = node;
            Node next = null;
            
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }
        
    Node reverseList(Node head) {
        Node prev = null;
        while (head != null) {
            Node next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }
        return prev;
    }
    
    /**
     * Reverse a singly linked list using recursion. In recursion Stack is
     * used to store data.
     * 1. Traverse linked list till we find the tail,
     * that would be new head for reversed linked list.
     */
    private Node reverseRecursively(Node node) {
        Node newHead;
        //base case -  tail of original linked list
        if ((node.next == null))
            return node;
        newHead = reverseRecursively(node.next);
        //reverse the link e.g C->D->null will be null
        node.next.next = node;
        node.next = null;
        return newHead;
    }
    
    /**
     * Reverse linked list using 3 pointers approach in O(n) time
     * It basically creates a new list by reversing direction, and
     * subsequently insert the element at the start of the list.
     */
    private void reverseIteratively() {
        Node current = head;
        Node prev = null;
        Node forward = null;
        
        //traversing the linked list until there is no more element
        while (current.next != null) {
            //Saving reference of next node, since we are changing current node
            forward = current.next;
            
            //Inserting node at start of new list
            current.next = prev;
            prev = current;
            
            //Advancing to the next node
            current = forward;
        }
        head = current;
        head.next = prev;
    }
    
    static public void printList(Node node) {
        while (node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }
}
