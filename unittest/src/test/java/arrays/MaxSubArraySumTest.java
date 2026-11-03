package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArraySumTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{-1, -2}, -1),
                Arguments.of(new int[]{-3, -1, -2}, -1),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{5, -9, 6}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsLargestContiguousSum(int[] input, int expected) {
        assertEquals(expected, MaxSubArraySum.kadane(input));
        assertEquals(expected, MaxSubArraySum.kadaneDp(input));
    }
}
