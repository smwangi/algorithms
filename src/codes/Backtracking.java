/**
 * Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.
 * Uses brute force approach
 * It uses recursive calls to find a solution set by building a solution step by step, increasing levels with time
 * In order to find these solutions, a search tree names state-space tree is used. In state-space tree, each node represents a state of the system and the branches represent the possible transitions from one state to another.
 * The algorithm uses depth-first search. The algorithm checks if so far the solution is valid or not. If it is valid, it continues to the next level. If it is not valid, it abandons the current solution and backtracks to the previous level.
 *
 * Backtracking is not considered an optimized technique, but it is a good choice for problems where the solution space is small and the depth of the state-space tree is limited.
 */
public class Backtracking {
    /**
     * Example: N-Queens Problem
     * Given a chess board of size N x N, place N queens on the board so that no two queens attack each other.
     * We need to find all arrangements of the positions of the N queens on the board, but there is a constraint that no two queens should be in the same row, column, or diagonal (should not attack each other).
     * Solution:
     * We start this algorithm with an array Q[n] and a parameter k that represents the current index of the first empty row.
     * The positions of the queens on a n x n chessboard are stored using an array Q[1..n], where Q[i] is the column number of the queen in the ith row.
     * First we check if the size of the variable k is greater than the size of n, if this condition is true,we return the array Q[n]
     * If k is less than n, we check the queen's current position with the index value. If it is non attacking position for placing a queen, we save the index value in the array Q[n]
     * We explore all positions on the chessboard by calling the NQueen function recursively with the next row index.
     *
     * The idea is to place queens one by one in different columns, starting from the leftmost column. When we place a queen in a column,
     * we check for clashes with already placed queens. In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
     * If we do not find such a row due to clashes, then we backtrack and return false.
     */
    class NQueens   {
        int N = 4;
        // Indicates row-col+N-1
        // N-1 is used for shifting the difference to store negative indices
        int[] leftDiagonal = new int[30];

        // Indicates row+col
        // used to check whether a queen can be placed on the right diagonal or not
        int[] rightDiagonal = new int[30];

        // Indicates column and used to check whether a queen can be placed in a row or not
        int[] columnArr = new int[30];

        void printSolution(int[][] board)   {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf(" %d ", board[i][j]);
                }
                System.out.printf("\n");
            }
        }

        // A recursive utility function to solve N Queen problem
        boolean solveNQUtil(int[][] board, int col)   {
            // base case: If all queens are placed then return true
            if (col >= N) {
                return true;
            }

            // Consider this column and try placing this queen in all rows one by one
            for (int i = 0; i < N; i++) {
                int idx1 = i - col + N - 1;
                int idx2 = i + col;
                // Check if the queen can be placed on the board[i][col]
                // To check if a queen can be placed on the board[row][col], we need to check the left diagonal, right diagonal
                if (leftDiagonal[i - col + N - 1] != 1 && rightDiagonal[i + col] != 1 && columnArr[i] != 1) {

                    // Place the queen on the board[i][col]
                    board[i][col] = 1;
                    leftDiagonal[i - col + N - 1] = rightDiagonal[i + col] = columnArr[i] = 1;

                    // recur to place rest of the queens
                    if (solveNQUtil(board, col + 1)) {
                        return true;
                    }

                    // If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col]
                    board[i][col] = 0; // BACKTRACK
                    leftDiagonal[i - col + N - 1] = rightDiagonal[i + col] = columnArr[i] = 0;
                }
            }
            // If the queen can not be placed in any row in this column col then return false
            return false;
        }

        boolean solveNQ()   {
            int[][] board = new int[N][N];
            if (!solveNQUtil(board, 0)) {
                System.out.print("Solution does not exist");
                return false;
            }
            printSolution(board);
            return true;
        }
    }

    public static void main(String[] args) {
        Backtracking backtracking = new Backtracking();
        NQueens nq = backtracking.new NQueens();
        nq.solveNQ();
    }
}
