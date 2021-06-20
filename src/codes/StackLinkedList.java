import static java.lang.System.exit;

/**
 * Implement a stack using single linked list concept. all the single linked list operations perform based on Stack operations
 * LIFO(last in first out) and with the help of that knowledge we are going to implement a stack using single linked list.
 * using single linked lists so how to implement here it is linked list means what we are storing the information
 * in the form of nodes and we need to follow the stack rules and we need to implement using single linked list nodes
 * so what are the rules we need to follow in the implementation of a stack a simple rule that is last in first out and all the operations
 * we should perform so with the help of a top variable only with the help of top variables are how to insert the elements.
 *
 * A stack can be easily implemented through the linked list. In stack Implementation, a stack contains a top pointer.
 * which is “head” of the stack where pushing and popping items happens at the head of the list.
 * first node have null in link field and second node link have first node address in link field and so on and last node address in
 * “top” pointer.
 * The main advantage of using linked list over an arrays is that it is possible to implements a stack that can shrink or grow as much
 * as needed. In using array will put a restriction to the maximum capacity of the array which can lead to stack overflow.
 * Here each new node will be dynamically allocate. so overflow is not possible.
 * Stack Operations:
 *
 * push() : Insert the element into linked list nothing but which is the top node of Stack.
 * pop() : Return top element from the Stack and move the top pointer to the second node of linked list or Stack.
 * peek(): Return the top element.
 * display(): Print all element of Stack.
 *
 * Time Complexity:
 *
 * The time complexity for all push(), pop(), and peek() operations is O(1) as we are not performing any kind of traversal over the list.
 * We perform all the operations through the current pointer only.
 */
public class StackLinkedList {
    public static void main(String[] args) {
        StackLinkedList list = new StackLinkedList();
        list.push(11);
        list.push(22);
        list.push(33);
        list.push(44);
        // print Stack elements
        list.display();
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", list.peek().data);
        // Delete top element of Stack
        list.pop();
        list.pop();
        list.display();
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", list.peek().data);
    }
    private class Node {
        int data; // integer data
        Node link; // reference variable Node type
    }
    Node top;
    StackLinkedList() {
        this.top = null;
    }
    
    // Utility function to add an element x in the stack
    public void push(int x) { // insert at the beginning
        // create new node temp and allocate memory
        Node temp = new Node();
        // Check if stack (heap) is full. Then inserting an element would lead to stack overflow
        if (temp == null) {
            System.out.println("\nHeap Overflow");
            return;
        }
        // Initialize data into temp data field
        temp.data  = x;
        // Put top reference into temp link
        temp.link = top;
        // update top reference
        top = temp;
    }
    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == null;
    }
    // Utility to return top element in a stack
    public Node peek() {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack underflow");
            return null;
        }
        // update the top pointer to point to the next node
        top = (top).link;
        return top;
    }
    // Utility function to pop top element from the Stack
    public void pop() { // Remove at the beginning
        // check for Stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
    }
    public void display() {
        // check for stack underflow
        if (top == null) {
            System.out.printf("\nStack Underflow");
            exit(1);
        } else {
            Node temp = top;
            while (temp != null) {
                // print node data
                System.out.printf("%d->", temp.data);
                // assign temp link to temp
                temp = temp.link;
            }
        }
    }
}
