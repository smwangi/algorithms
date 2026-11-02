import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackUsingTwoQueuesTest {

    @Test
    public void canUseTwoQueuesAsStack() {
        StackUsingTwoQueues twoQueues = new StackUsingTwoQueues();
        twoQueues.push(1);
        twoQueues.push(2);
        twoQueues.push(3);

        Assertions.assertEquals(3, twoQueues.pop());
    }
}
