import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphPathTest {

    @Test
    public void TestGraphPath() {
        GraphValidPath graphValidPath = new GraphValidPath();
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        boolean isValidPath = graphValidPath.validPath(3, edges, 0, 2);

        assertEquals(true, isValidPath);
    }
}
