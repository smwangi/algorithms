import java.util.Queue;

public class ReverseKElemInQueue {

    public Queue<Integer> reverseKElements(Queue<Integer> q, int k) {
        if (q.isEmpty() || q.size() == 1)
            return q;

        reverseFirstK(q, k);
        int s = q.size() - k;

        while (s-- > 0) {
            int val = q.poll();
            q.add(val);
        }
        return q;
    }

    //Holding values on stack
    private void reverseFirstK(Queue<Integer> queue, int k) {
        if (k == 0) return;

        int val = queue.poll();
        reverseFirstK(queue, k-1);
        queue.add(val);
    }
}
