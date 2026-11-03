package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),          // same value, different elements
                Arguments.of(new int[]{5, 4, 7, 3, 9, 2}, 13, new int[]{1, 4}),
                Arguments.of(new int[]{1, 2, 3}, 100, new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsIndicesOfPair(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, TwoSum.bruteForce(nums, target));
        assertArrayEquals(expected, TwoSum.onePassHash(nums, target));
    }

    @ParameterizedTest(name = "{0} under {1} = {2}")
    @CsvSource(delimiter = '|', value = {
            "34,23,1,24,75,33,54,8 | 60  | 58",
            "10,20,30              | 15  | -1",
            "30,20,50              | 70  | 50",
            "254,914,110,900,147   | 200 | -1"
    })
    void twoSumLessThanK(String values, int k, int expected) {
        int[] a = Stream.of(values.split(",")).mapToInt(Integer::parseInt).toArray();
        assertEquals(expected, TwoSum.twoSumLessThanK(a, k));
    }
}
