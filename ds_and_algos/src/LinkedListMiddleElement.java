/**
 *
 */
public class LinkedListMiddleElement {
    Node head;
    Node tail;
    public static void main(String[] args) {
        LinkedListMiddleElement middleElement = new LinkedListMiddleElement();
        /*for(int i = 5; i > 0; i--)
        {
            middleElement.push(i);
        }*/
        middleElement.push(1);
        middleElement.push(2);
        middleElement.push(3);
        middleElement.push(4);
        middleElement.push(5);
        middleElement.push(6);
        middleElement.push(7);
        middleElement.printMiddle(middleElement.head);
        //middleElement.printMiddle2();
    }
    /**
     * Method 1:
     * Traverse the linked list using two pointers. Move one pointer by one and the other pointers by two. When the fast pointer
     * reaches the end, slow pointer will reach the middle of the linkedlist
     */
    Node printMiddle(Node node) {
        if (node == null)
            return null;
        
        Node slow = head, fast = head;
        
        if (node != null) {
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            
        }
        System.out.println("(printMiddle) The middle element is ["+slow.data+"]");
        return slow;
    }
    
    /**
     * Method 2:
     * Initialize the mid element as head and initialize a counter as 0. Traverse the list from head, while traversing increment
     * the counter and change mid to mid->next whenever the counter is odd. So mid will move only half of the total length of the list.
     */
    void printMiddle2() {
        int count = 0;
        Node mid = head;
        while (head != null) {
            //update middle when count is odd number
            if (count % 2 == 0) {
                mid = mid.next;
            }
            count++;
            head = head.next;
        }
        if (mid != null)
            System.out.println("(printMiddle2) The middle element is [" +
                    mid.data + "]\n");
    }
    //push new element to the top of linkedlist
    
    /**
     * Check if head is null, which means the list is empty
     * if list is empty, both head and tail will point to the newly added node.
     * if the list is not empty, then create temp node which will point to head
     * Add the new node as head of the list
     * Temp which was pointing to the old head will be added after the new head
     * @param data
     */
    void push(int data) {
        // Allocate node and put in the data
        Node new_node = new Node(data);
        if (head == null) {
            // if list is empty both head and tail will point to new node
            head = new_node;
            tail = new_node;
        } else {
            //Node temp will point to head
            Node temp = head;
            //new_node will become the head of the list
            head = new_node;
            //Node temp (previous node) will be added after new head
            head.next = temp;
        }
    }
    
    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }
}
