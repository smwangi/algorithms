package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Shortest Path to Get All Keys
    Explores state space expansion by combining 2D grid coordinates with an active
    bitmask representing collected keys to permit safe cell revisits
*/
public class ShortestPathToGetAllKeys {

    // Directional vectors for moving up, down, left, and right
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Internal immutable record representing a unique state within the expanded state space
    private record State(int row, int col, int keyMask) {}

    // Finds the minimum number of moves to collect all keys in the grid
    // @param grid The 2D grid representing the maze
    public int shortestPathAllKeys(String[] grid) {
        if (grid == null || grid.length == 0 || grid[0].length() == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length();

        int startRow = -1;
        int startCol = -1;
        int totalKeys = 0;

        // Scan grid to find the starting position and count total keys
        for (int r = 0; r < rows; r++)  {
            for (int c = 0; c < cols; c++)  {
                char cell = grid[r].charAt(c);

                if (cell == '@') { 
                    startRow = r;
                    startCol = c;
                } else if (cell >= 'a' && cell <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        // validate basic entry state invariant
        if (startRow == -1 || totalKeys == 0) {
            return -1;
        }

        // Compute target bitmask status: E.g, 3 keys -> binary 111 -> (1 << 3)
        int targetKeyMask = (1 << totalKeys) - 1;

        // Step 2: Initialize BFS queue and visited set
        Queue<State> queue = new ArrayDeque<>();

        // 3D tracking cache: visited[row][col][keyMask] indicates if a state has been visited
        boolean[][][] visited = new boolean[rows][cols][targetKeyMask + 1];

        State initialState = new State(startRow, startCol, 0);
        queue.offer(initialState);
        visited[startRow][startCol][0] = true;

        int steps = 0;

        // Step 3L Standard Layer by layer BFS Execution Loop
        while (!queue.isEmpty()) {
            int currentLayerSize = queue.size();

            for (int i = 0; i < currentLayerSize; i++) {
                State currentState = queue.poll();

                // Target state achieved: all keys collected
                if (currentState.keyMask == targetKeyMask) {
                    return steps;
                }

                // Explore all 4 orthogonal directions
                for (int[] dir : DIRECTIONS) {
                    int nextRow = currentState.row + dir[0];
                    int nextCol = currentState.col + dir[1];
                    int nextKeyMask = currentState.keyMask;

                    // Bound Guard: Ensure coordinates fall inside active matrix
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        continue;
                    }

                    char cellChar = grid[nextRow].charAt(nextCol);

                    // Obstacle Guard: Cannot pass through walls
                    if (cellChar == '#') {
                        continue;
                    }

                    // Lock Guard: Evaluate key inventory using bitwise AND optimization
                    if (cellChar >= 'A' && cellChar <= 'F') {
                        int lockBitShift = cellChar - 'A';
                        boolean holdsMatchingKey = (nextKeyMask & (1 << lockBitShift)) != 0;
                        if (!holdsMatchingKey) {
                            continue; // Lock cannot be passed yet
                        }
                    }

                    // Key Accumulation: Update inventory using bitwise OR optimization
                    if (cellChar >= 'a' && cellChar <= 'f') {
                        int keyBitShift = cellChar - 'a';
                        nextKeyMask |= (1 << keyBitShift);
                    }

                    // Visited state check: Verify if this unique state tuple has been processed
                    if (!visited[nextRow][nextCol][nextKeyMask]) {
                        visited[nextRow][nextCol][nextKeyMask] = true;
                        queue.offer(new State(nextRow, nextCol, nextKeyMask));
                    }
                }
            }
            steps++; // Increment step depth level after completing current layer traversal
        }

        return -1; // Exhausted all paths without collecting all keys
    }
}
