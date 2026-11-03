package backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, Set.of(
                        List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                        List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
                Arguments.of(new int[]{0, 1}, Set.of(List.of(0, 1), List.of(1, 0))),
                Arguments.of(new int[]{1}, Set.of(List.of(1)))
        );
    }

    // Order differs between approaches, so compare as sets, and check the count to catch duplicates.
    @ParameterizedTest
    @MethodSource("scenarios")
    void generatesEveryOrdering(int[] nums, Set<List<Integer>> expected) {
        List<Integer> boxed = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (List<List<Integer>> actual : List.of(
                Permutations.backtrack(nums),
                Permutations.bySwapping(nums),
                Permutations.pickHead(boxed),
                Permutations.heaps(nums))) {
            assertEquals(expected.size(), actual.size());
            assertEquals(expected, new HashSet<>(actual));
        }
    }
}
