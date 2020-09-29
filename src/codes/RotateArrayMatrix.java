package codes;

import java.util.Arrays;

/**
 * Rotate a matrix by 90 degree in clockwise direction without using any extra space
 *
 *  Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.
 *
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 *
 * Example
 *
 * For
 *
 * a = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 *
 * the output should be
 *
 * rotateImage(a) =
 *     [[7, 4, 1],
 *      [8, 5, 2],
 *      [9, 6, 3]]
 *
 * Input/Output
 *
 *
     [execution time limit] 3 seconds (java)

     [input] array.array.integer a

     Guaranteed constraints:
     1 ≤ a.length ≤ 100,
     a[i].length = a.length,
     1 ≤ a[i][j] ≤ 104.

     [output] array.array.integer

 */
public class RotateArrayMatrix {

    public static void main(String[] args) {
        RotateArrayMatrix arrayMatrix = new RotateArrayMatrix();
        int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
         System.out.println(Arrays.toString( arrayMatrix.rotateImage(matrix)));
    }

    /**
     * Approach:
     * The approach is similar to Inplace rotate square matrix by 90 degrees | Set 1. The only thing that is different is to print the elements of cycle in clockwise direction
     * i.e. An N x N matrix will have floor(N/2) square cycles.
     * For example, a 3 X 3 matrix will have 1 cycle. The cycle is formed by its 1st row, last column, last row, and 1st column.
     * For each square cycle, we swap the elements involved with the corresponding cell in the matrix in the clockwise direction. We just need a temporary variable for this.
     *
     * Explanation:
     *
     * Let size of row and column be 3.
     * During first iteration –
     * a[i][j] = Element at first index (leftmost corner top)= 1.
     *
     * a[j][n-1-i]= Rightmost corner top Element = 3.
     *
     * a[n-1-i][n-1-j] = Rightmost corner bottom element = 9.
     *
     * a[n-1-j][i] = Leftmost corner bottom element = 7.
     *
     * Move these elements in the clockwise direction.
     *
     * During second iteration –
     * a[i][j] = 2.
     *
     * a[j][n-1-j] = 6.
     *
     * a[n-1-i][n-1-j] = 8.
     *
     * a[n-1-j][i] = 4.
     * Similarly, move these elements in the clockwise direction.
     * @param a
     * @return
     */
    int[][] rotateImage(int[][] a) {
        //int[][]res = new int[a.length][];
        /*int N = 4;//a.length;

        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
        return a;*/
        int rowNum = a.length;
        int colNum = a[0].length;

        int[][] temp = new int[rowNum][colNum];
        for(int i =0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){

                temp[i][j] = a[rowNum-j-1][i];
            }
        }
        return temp;
    }
}
