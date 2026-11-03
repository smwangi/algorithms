package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{2, 0, 6, 1, 5, 3, 7}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{1, 2, 2, 3}, 3),   // duplicates count once
                Arguments.of(new int[]{-1, 0, 1}, 3),
                Arguments.of(new int[]{5}, 1),
                Arguments.of(new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsLongestRun(int[] nums, int expected) {
        assertEquals(expected, LongestConsecutive.boundaryMap(nums));
        assertEquals(expected, LongestConsecutive.setLookup(nums));
    }
}
