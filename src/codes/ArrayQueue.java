/**
 * In queue, insertion and deletion happen at the opposite ends, so implementation is not as simple as stack.
 * To implement a queue using array, create an array arr of size n and take two variables front and rear
 * both of which will be initialized to 0 which means the queue is currently empty.
 * Element rear is the index upto which the elements are stored in the array and front is the index of the
 * first element of the array. Now, some of the implementation of queue operations are as follows:
 *
 *
 * Enqueue: Addition of an element to the queue. Adding an element will be performed after checking whether the queue is full or not.
 * If rear < n which indicates that the array is not full then store the element at arr[rear] and increment rear by 1 but
 * if rear == n then it is said to be an Overflow condition as the array is full.
 * Dequeue: Removal of an element from the queue. An element can only be deleted when there is at least an element to delete i.e. rear > 0.
 * Now, element at arr[front] can be deleted but all the remaining elements have to shifted to the left by one position in order
 * for the dequeue operation to delete the second element from the left on another dequeue operation.
 * Front: Get the front element from the queue i.e. arr[front] if queue is not empty.
 * Display: Print all element of the queue. If the queue is non-empty, traverse and print all the elements from index front to rear.
 */
public class ArrayQueue {
    private static int front, rear, capacity;
    private static int queue[];
    
    ArrayQueue(int c) {
        front = rear = 0;
        capacity = c;
        queue = new int[c];
    }
    // function to insert an element
    // at the rear of the queue
    static void enqueue(int data) {
        // check queue is full or not
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }
        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }
    // function to delete an element
    // from the front of the queue
    static void dequeue() {
        // if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
        }
        // shift all the elements from index 2 till rear
        // to the right by one
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;
            // decrement rear
            rear--;
        }
        return;
    }
    // print queue elements
    static void display() {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <--", queue[i]);
        }
        return;
    }
    // print front og queue
    static void queueFront() {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }
    static class StaticQueue {
        public static void main(String[] args) {
            // Create a queue of capacity 4
            ArrayQueue q = new ArrayQueue(4);
            // print Queue elements
            ArrayQueue.display();
            // inserting elements in the queue
            ArrayQueue.enqueue(20);
            ArrayQueue.enqueue(30);
            ArrayQueue.enqueue(40);
            ArrayQueue.enqueue(50);
            // print Queue elements
            ArrayQueue.display();
            ArrayQueue.enqueue(60);
            ArrayQueue.display();
    
            ArrayQueue.display();
            ArrayQueue.display();
            System.out.printf("\n\nafter two node deletion\n\n");
    
            // print Queue elements
            ArrayQueue.display();
    
            // print front of the queue
            q.queueFront();
        }
    }
}
