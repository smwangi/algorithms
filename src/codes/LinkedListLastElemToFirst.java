/**
 * Write a function that moves the last element to the front in a given Singly Linked List.
 * For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.
 * Algorithm:
 * Traverse the list till the last node. Use two pointers: one store the address of the last node and the other the address of
 * the second last node.
 * After the end of the loop do following operations:
 * Make second last as last (secLast -> next = null)
 * Set next of last as head (last->next = *head_ref)
 * Make the last as head (*head_ref = last)
 */
public class LinkedListLastElemToFirst {
    Node head;
    
    public static void main(String[] args) {
        LinkedListLastElemToFirst lastElemToFirst = new LinkedListLastElemToFirst();
        lastElemToFirst.push(5);
        lastElemToFirst.push(4);
        lastElemToFirst.push(3);
        lastElemToFirst.push(2);
        lastElemToFirst.push(1);
    
        System.out.println("Linked List before moving last to front ");
        lastElemToFirst.printList();
    
        lastElemToFirst.moveFirst();
    
        System.out.println("Linked List after moving last to front ");
        lastElemToFirst.printList();
    }
    
    void moveFirst() {
        // if linked list is empty or it contains only one node then simply return
        if (head == null || head.next == null) {
            return;
        }
        // Initialize last and second last pointers
        Node secLast = null;
        Node last = head;
        /** After this loop secLast contains address of
           second last  node and last contains address of
           last node in Linked List
         */
        while (last != null && last.next != null) {
            secLast = last;
            last = last.next;
        }
            //set the next of second last as null
            secLast.next = null;
            // set the next of last head
            last.next = head;
            //change head to point to last node
            head = last;
        
    }
    
    void push(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node temp = head;// points to head
            head = new_node;
            head.next = temp;
        }
    }
    
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
