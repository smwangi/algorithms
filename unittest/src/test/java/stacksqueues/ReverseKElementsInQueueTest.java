package stacksqueues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseKElementsInQueueTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 3, List.of(3, 2, 1, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 5, List.of(5, 4, 3, 2, 1)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 1, List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 0, List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(7), 1, List.of(7))
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void reversesFirstKElements(List<Integer> input, int k, List<Integer> expected) {
        LinkedList<Integer> queue = new LinkedList<>(input);
        assertEquals(expected, new ReverseKElemInQueue().reverseKElements(queue, k));
    }
}
