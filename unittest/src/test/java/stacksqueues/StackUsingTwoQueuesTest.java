package stacksqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackUsingTwoQueuesTest {

    @Test
    void popsInLastInFirstOutOrder() {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void popOnEmptyStackReturnsMinusOne() {
        assertEquals(-1, new StackUsingTwoQueues().pop());
    }
}
