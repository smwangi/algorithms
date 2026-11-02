import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int a) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        q1.add(a);

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    int pop() {
        if (!q1.isEmpty()) {
            return q1.remove();
        }
        return -1;
    }
}
