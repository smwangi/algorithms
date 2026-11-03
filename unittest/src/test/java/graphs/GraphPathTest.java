package graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphPathTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2, true),
                Arguments.of(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5, false),
                Arguments.of(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 0, 3, true),
                Arguments.of(2, new int[][]{}, 0, 1, false),
                Arguments.of(1, new int[][]{}, 0, 0, true),
                Arguments.of(3, new int[][]{{1, 2}}, 0, 2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsPathBetweenNodes(int n, int[][] edges, int source, int destination, boolean expected) {
        assertEquals(expected, new GraphValidPath().validPath(n, edges, source, destination));
    }
}
