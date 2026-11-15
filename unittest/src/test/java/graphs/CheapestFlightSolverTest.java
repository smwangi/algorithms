package graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheapestFlightSolverTest {

    static Stream<Arguments> scenarios() {
        return Stream.of(
                // cheapest overall (0-1-2-3 = 400) needs 2 stops; with 1 stop allowed, 0-1-3 = 700
                Arguments.of(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1, 700),
                Arguments.of(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1, 200),
                Arguments.of(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0, 500), // direct only
                // regression: city 2 is first pushed via the expensive direct flight;
                // the cheaper route through city 1 (more stops) must not be pruned
                Arguments.of(4, new int[][]{{0, 2, 100}, {0, 1, 10}, {1, 2, 40}, {2, 3, 1}}, 0, 3, 2, 51),
                Arguments.of(4, new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 3, 10}}, 0, 3, 1, -1),     // needs 2 stops
                Arguments.of(4, new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 3, 10}}, 0, 3, 2, 30),     // exactly enough stops
                Arguments.of(3, new int[][]{{0, 1, 100}}, 0, 2, 1, -1),                           // unreachable
                Arguments.of(3, new int[][]{{1, 0, 100}}, 0, 1, 1, -1),                           // flights are one-way
                Arguments.of(3, new int[][]{{0, 1, 100}}, 1, 1, 0, 0),                            // already there
                Arguments.of(2, new int[][]{}, 0, 5, 1, -1)                                       // invalid city
        );
    }

    @ParameterizedTest
    @MethodSource("scenarios")
    void findsCheapestFlightWithinStops(int cities, int[][] flights, int src, int dest, int stops, int expected) {
        assertEquals(expected, new CheapestFlightSolver().findCheapestFlight(cities, flights, src, dest, stops));
    }
}
