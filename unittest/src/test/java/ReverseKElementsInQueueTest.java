import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseKElementsInQueueTest {

    @Test
    public void canReverseKElementsInQueue() {
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

//        Queue<Integer> expected = new LinkedList<>();
//        q.add(3);
//        q.add(2);
//        q.add(1);
//        q.add(4);
//        q.add(5);

        ReverseKElemInQueue reverseKElemInQueue = new ReverseKElemInQueue();
        reverseKElemInQueue.reverseKElements(q, k);

        //Assert.assertEquals(expected, q);
    }
}
