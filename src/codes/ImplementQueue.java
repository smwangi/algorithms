import java.util.Stack;

public class ImplementQueue {
    public static void main(String[] args) {
        QueueImp queueImp = new ImplementQueue().new QueueImp(new Node(1), new Node(2));
        /*queueImp.enqueue(1);
        queueImp.enqueue(2);
        queueImp.enqueue(3);
        queueImp.enqueue(4);*/
        
        System.out.println(queueImp.dequeue());
        System.out.println(queueImp.dequeue());
        
        int[] keys = {1, 2, 3, 4, 5};
        Queue<Integer> q = new ImplementQueue().new Queue<>();
        for (int key : keys) {
            q.enqueue(key);
        }
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
    
    public class QueueImp {
        Node first, last;
        
        public QueueImp() {}
        
        public QueueImp(Node first, Node last) {
            this.first = first;
            this.last = last;
        }
        
        public void enqueue(int data) {
            if (first == null) {
                last = new Node(data);
                first = last;
            }
        }
        
        public int dequeue() {
            if (first != null) {
                int item = first.data;
                first = first.next;
                return item;
            }
            return -1;
        }
    }
    static class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }
    
    /**
     * Implement Queue using two stacks
     * The idea is to implement the queue's enqueue operation so that the first entered element always ends up at the top of the stack
     * To achieve this, we need an additional stack
     *
     * 1. To enqueue an item into the queue, first move all elements from the first stack to the second stack, push the item
     * into the first stack, and finally move all elements back to the first stack. This ensures that the new item lies at the bottom of the
     * stack and hence would be the last one to be removed
     *
     * 2. To dequeue an item from the queue, return the top item from the first stack
      */
    
    class Queue<T> {
        private Stack<T> s1, s2;
        Queue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        // Add item to the queue
        public void enqueue(T data) {
            // Move all items from the stack 1 to stack 2
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
            //push item into the first stack
            s1.push(data);
            
            // Move all elements back to the first stack from the second stack
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        
        // Remove an item from the queue
        public T dequeue() {
            // if the first stack is empty
            if (s1.isEmpty()) {
                System.out.println("Underflow!");
                System.exit(0);
            }
            //return the top item from the first stack
            return s1.pop();
        }
    }
    
    /**
     * Improved Version
     * The elements are exchanged between the stacks twice for every enqueue operation. This can impact performance if enqueue operations
     * are frequent.
     *
     * 1. To enqueue an item into the queue push the item into the first stack.
     * 2. To dequeue an item from the queue, move elements from the first stack to the second stack if it is empty, and return the top item
     *    from the second stack.
     */
    class Queue2<T> {
        private Stack<T> s1, s2;
        
        Queue2() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        // Add item to the queue
        public void enqueue(T data) {
            // push item into the first stack
            s1.push(data);
        }
        
        // Remove an item from the queue
        public T dequeue() {
            // if both stacks are empty
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Underflow!");
                System.exit(0);
            }
            // if the second stack is empty, move elements from the first stack to it
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // return the top item from the second stack
            return s2.pop();
        }
    }
    
    /**
     * Using one Stack with call stack
     * We can also use an implicit stack (call stack) and an actual stack for constructing a queue. The dequeue operation pops all elements
     * from the stack and stores them in the call stack. When the stack is left with a single item, remove and return that item, Finally, push
     * all elements back into the stack from the call stack as the recursion unfolds.
     */
    class Queue3<T> {
        private Stack<T> s;
        
        Queue3() {
            s = new Stack<>();
        }
        
        //Add item to the queue
        public void enqueue(T data) {
            //push item into the first stack
            s.push(data);
        }
        // Remove an item from the queue
        public T dequeue() {
            // if the stack is empty
            if (s.isEmpty()) {
                System.out.println("Underflow!!");
                System.exit(0);
            }
            // Pop an item from the stack
            T top  = s.pop();
            // if the stack becomes empty, return the popped ite,
            if (s.isEmpty()) {
                return top;
            }
            
            // Recur
            T item = dequeue();
            // push popped item back into the stack
            s.push(top);
            //return the result of `dequeue()` call
            return item;
        }
    }
    
    /**
     * See here for example the canonical use case of queues, a breadth-first search, from wikipedia:
     *
     * 1  procedure BFS(G,v) is
     * 2      create a queue Q
     * 3      create a vector set V
     * 4      enqueue v onto Q
     * 5      add v to V
     * 6      while Q is not empty loop
     * 7         t ← Q.dequeue()
     * 8         if t is what we are looking for then
     * 9            return t
     * 10        end if
     * 11        for all edges e in G.adjacentEdges(t) loop
     * 12           u ← G.adjacentVertex(t,e)
     * 13           if u is not in V then
     * 14               add u to V
     * 15               enqueue u onto Q
     * 16           end if
     * 17        end loop
     * 18     end loop
     * 19     return none
     * 20 end BFS
     */
    
    /**
     * Algorithm👨‍🎓
     *
     *     We have to use two Stacks to represent the operation of a single Queue.
     *     One Stack is L and the other one is R
     *     For push Operation. Insert it into the R stack.
     *     For Pop Operation. Pop all the elements of the R Stack and push it into the L stack.
     *     Now Pop the L stack. This will be the first element entered into the queue.
     *     For Peek Operation. Pop all the elements of the R Stack and push it into the L stack. Peek the last element of the L stack.
     *     For empty(). Check the isempty() condition of l and r stack and return the value.
     */
    class MyQueue {
        Stack<Integer> l;
        Stack<Integer> r;
        /** Initialize your data structure here. */
        public MyQueue() {
            l =new Stack();
            r = new Stack();
        }
    
        /** Push element x to the back of queue. */
        public void push(int x) {
            r.push(x);
        }
    
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            reverse();
            return l.pop();
        
        }
    
        /** Get the front element. */
        public int peek() {
            reverse();
            return l.peek();
        
        }
    
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return l.isEmpty() && r.isEmpty();
        }
    
        public void reverse()
        {
        
            if(l.isEmpty())
                while(!r.isEmpty())
                {
                    l.push(r.pop());
                }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
