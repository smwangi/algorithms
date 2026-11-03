package backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringPermutationsTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of("ABC", Set.of("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")),
                Arguments.of("AB", Set.of("AB", "BA")),
                Arguments.of("A", Set.of("A")),
                Arguments.of("", Set.of(""))
        );
    }

    // Order differs between approaches, so compare as sets, and check the count to catch duplicates.
    @ParameterizedTest
    @MethodSource("scenarios")
    void generatesEveryOrdering(String s, Set<String> expected) {
        for (List<String> actual : List.of(
                StringPermutations.prefix(s),
                StringPermutations.bySwapping(s),
                StringPermutations.insertFirst(s),
                StringPermutations.iterative(s))) {
            assertEquals(expected.size(), actual.size());
            assertEquals(expected, new HashSet<>(actual));
        }
    }
}
