package Backtracking;
/**
 * Word search algorithm is used to find if a given word exists in a 2D grid of Characters. It is commonly used in puzzles and 
 * games like crosswords and word searches.
 * 1. Initialization: 
 * Start by iterating over each cell in the grid.
 * 2. Backtracking Search
 * For each cell in the grid, perform DFS to explore all possible paths to find the target word. During the search, keep track of the current
 * position in the grid and the characters visited so far in the word.
 * 3. Search Constraints
 * During DFS, ensure that search stays within the boundaries of the grid and doesn't revisit already visited cells.
 * 4. Termination Conditions
 * Search terminates under the following conditions:
 * 1 If the current character doesn't match the corresponding character in the word, backtrack and explore a different path.
 * 2. If the entire word is found, trurn true to indicate success.
 * 3. If all paths from the current cell have been explored and the word hasn't been found, backtrack to the previous cell.
 * 5. Repeat
 * Continue the search process for each cell in the grid until the entire grid has been searched or until the word is found.
 * 6 Result
 * Return true if the word is found and false otherwise.  
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println("Word \"ABCCED\" exists " + exists(board, word1));
        System.out.println("Word \"SEE\" exists " + exists(board, word2));
        System.out.println("Word \"ABCB\" exists " + exists(board, word3));
    }

    static boolean exists(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // iterate over each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // perform DFS for each cell in the grid
                if (dfs(board, i, j, word, 0)) {
                    return true; // word found
                }
            }
        }

        return false;
    }

    private static boolean  dfs(char[][] board, int i, int j, String word, int idx) {
        // Check if all characters in the word have been matched
        if (idx == word.length()) {
            return true;
        }

        // Check boundary constraints and if the current cell matches the current character in the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark the current cell as visited by temporarily changing its value
        char temp = board[i][j];
        board[i][j] = '#'; // Marked as visited

        // Explore the adjacent cells in all four directions
        boolean found = dfs(board, i + 1, j, word, idx + 1) ||
        dfs(board, i - 1, j, word, idx + 1) ||
        dfs(board, i, j + 1, word, idx + 1) ||
        dfs(board, i, j - 1, word, idx + 1);

        // Restore the original value of the current cell
        board[i][j] = temp;

        return found;
    }
}
