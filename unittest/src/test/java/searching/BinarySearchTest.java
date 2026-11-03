package searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private static final int[] SORTED = {2, 3, 4, 10, 40};

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(SORTED, 2, 0),
                Arguments.of(SORTED, 3, 1),
                Arguments.of(SORTED, 10, 3),
                Arguments.of(SORTED, 40, 4),
                Arguments.of(SORTED, 1, -1),     // below range
                Arguments.of(SORTED, 50, -1),    // above range
                Arguments.of(SORTED, 5, -1),     // gap
                Arguments.of(new int[]{7}, 7, 0),
                Arguments.of(new int[]{}, 7, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsIndexOfKey(int[] sorted, int key, int expected) {
        assertEquals(expected, BinarySearch.iterative(sorted, key));
        assertEquals(expected, BinarySearch.recursive(sorted, key));
    }
}
