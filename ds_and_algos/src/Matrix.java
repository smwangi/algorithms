import java.util.Arrays;

public class Matrix {
    static int[][] data;
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        transposeMatrix(matrix);
        spiralMatrix(matrix);
        int n = 2;
        int mat[][] = new int[][]{{ 1, 2 }, { 3, 4 }};
        System.out.println(printLastElement(mat, n));
        System.out.println(Arrays.toString(generateMatrix(9)));
    }
    static void transposeMatrix(int[][] matrix) {
        int col = matrix[0].length;
        int rows = matrix.length;
        
        int[][] temp = new int[col][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        print(temp);
    }
    
    static void print(int[][] matrix) {
        int col = matrix[0].length;
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] +" ");
            }
        }
        System.out.println();
    }
    
    static void spiralMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //Define the boundaries of the matrix
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        
        //define the direction into which the array is to be traversed.
        int dir = 1;
        
        while (top <= bottom && left <= right) {
            if (dir == 1) { //moving left -> right
                for (int i = left; i <= right; ++i) {
                    System.out.println(matrix[top][i] + " ");
                }
                // Since we have traversed the whole first row, move down to the next row.
                ++top;
                dir = 2;
            } else if (dir == 2) { //moving top to bottom
                for (int i  = top; i <= bottom; ++i) {
                    System.out.println(matrix[i][right] + " ");
                }
                // since we have traversed the whole last column, move left to the previous column
                --right;
                dir = 3;
            } else if (dir == 3) { //moving right to left
                for (int i = right; i >= left; --i) {
                    System.out.println(matrix[bottom][i] + " ");
                }
                //Since we have traversed the whole last row, move up to the previous row.
                --bottom;
                dir = 4;
            } else if (dir == 4) { //moving bottom up
                for (int i = bottom; i >= top; --i) {
                    System.out.println(matrix[i][left] + " ");
                }
                // Since we have traversed the whole first col, move right to the next column
                ++left;
                dir = 1;
            }
        }
    }
    /**
     * Element in a matrix starting from which anti-clockwise traversal ends at the last element
     *
     * Given a mat[][] of size n X n, the task is to find an element X such that if the anti-clockwise traversal
     * is begun from X then the final element to be printed is mat[n – 1][n – 1].
     *
     *
     * The anti-clockwise traversal of the matrix, mat[][] =
     * {{1, 2, 3},
     * {4, 5, 6},
     * {7, 8, 9}}
     * starting at element 5 will be 5, 6, 3, 2, 1, 4, 7, 8, 9.
     *
     *
     * Examples:
     *
     *
     * Input: mat[][] = {{1, 2}, {3, 4}}
     * Output: 2
     * If we start traversing from mat[0][1] i.e. 2 then
     * we will end up with the element at mat[1][1] which is 4.
     * Input: mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
     * Output: 5
     *
     * Approach: Starting from the element at mat[n – 1][n – 1], start traversing the matrix in the opposite order i.e.
     * clockwise. When all the elements of the matrix are traversed, the last visited element will be the result.
     * Below is the implementation of the above approach:
     */
    // Function to print last element
    // Of given matrix
    static int printLastElement(int[][] mat, int n) {
        // Starting row index
        int si = 0;
        // Starting column index
        int sj = 0;
        // Ending row index
        int ei = n - 1;
        // Ending row column
        int ej = n - 1;
        // Track the move
        int direction  = 0;
        // While starting index is less than ending
        // row index or starting column index
        // is less the ending column index
        while (si < ei || sj < ej) {
            // Switch cases for all direction
            // Move under all cases for all
            // directions
            switch (direction % 4) {
                case 0:
                    sj++;
                    break;
                case 1:
                    ei--;
                    break;
                case 2:
                    ej--;
                    break;
                case 3:
                    si++;
                    break;
            }
            // Increment direction by one for each case
            direction++;
        }
        // Finally return the last element if not found return 0
        return mat[si][sj];
    }
    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * Input: 3
     * Output:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     *
     * Algorithm👨‍🎓
     *
     *     When we are traversing through a matrix spirally think of how we are moving from one step to another.
     *     We are traversing from left to right and when we reach the end we move down till we reach the end and then we move left till we reach the boundary then we move up.
     *     We repeat these steps every time until there are no more ways to traverse.
     *     We have to initialize four variables that are going to act as the direction indicators for traversing through the array.
     *     We are separating them into rows and columns.
     *     For each row, we are traversing until we reach the end of that row. Increase that row and traverse that particular column till the end.
     *     Now traverse that particular row till the first column position.
     *     From there traverse till the start of the first row.
     *     Continue this method until the rows cross each other.
     *     Return the array.
     */
    static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0)
            return ans;
        int r1 = 0, c1 = 0;
        int r2 = n-1, c2 = n-1;
        int i = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans[r1][c] = i++;
            }
            for (int r = r1+1; r <= r2; r++) {
                ans[r][c2] = i++;
            }
            if (r1 <= r2 && c1 <= c2) {
                for (int c = c2 - 1; c > c1; c--)
                    ans[r2][c] = i++;
                for (int r = r2; r > r1; r--)
                    ans[r][c1] = i++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
