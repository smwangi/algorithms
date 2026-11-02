import java.util.LinkedList;
import java.util.Queue;

/**
 * Reversing a Queue using another Queue
 * Given a queue. The task is to reverse the queue using another another empty queue.
 *
 * Examples:
 *
 * Input: queue[] = {1, 2, 3, 4, 5}
 * Output: 5 4 3 2 1
 *
 * Input: queue[] = {10, 20, 30, 40}
 * Output: 40 30 20 10
 *
 * Approach:
 *
 * Given a queue and an empty queue.
 * The last element of the queue should be the first element of the new queue.
 * To get the last element there is a need to pop the queue one by one and add it to the end of the queue, size – 1 times.
 * So after that, we will get the last element in front of the queue. Now pop that element out and add it to the new queue.
 * Repeat the steps s – 1 times where s is the original size of the queue.
 */
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Insert elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
    
        q = reverse(q);
    
        // Print the queue
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
    static Queue<Integer> reverse(Queue<Integer> q) {
        // Size of queue
        int s = q.size();
        // Second Queue
        Queue<Integer> ans = new LinkedList<>();
        for (int i = 0; i < s; i++) {
            // Get the last element to the front of queue
            for (int j = 0; j < q.size() - 1; j++) {
                int x = q.peek();
                q.remove();
                q.add(x);
            }
            // Get the last element and add it to the new queue
            ans.add(q.peek());
            q.remove();
        }
        return ans;
    }
}
