package backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubsetsTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, List.of(
                        List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 3),
                        List.of(1, 3), List.of(2), List.of(2, 3), List.of(3))),
                Arguments.of(new int[]{0}, List.of(List.of(), List.of(0))),
                Arguments.of(new int[]{}, List.of(List.of()))
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void generatesPowerSet(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, Subsets.subsets(nums));
    }
}
