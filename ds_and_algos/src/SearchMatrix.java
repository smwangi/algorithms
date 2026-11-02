/**
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity.
 *
 * Example:
 *
 * Input: mat[4][4] = { {10, 20, 30, 40},
 *                       {15, 25, 35, 45},
 *                       {27, 29, 37, 48},
 *                       {32, 33, 39, 50}};
 *               x = 29
 * Output: Found at (2, 1)
 * Explanation: Element at (2,1) is 29
 *
 * Input : mat[4][4] = { {10, 20, 30, 40},
 *                       {15, 25, 35, 45},
 *                       {27, 29, 37, 48},
 *                       {32, 33, 39, 50}};
 *               x = 100
 * Output : Element not found
 * Explanation: Element 100 is not found
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
    
        search(mat, 4, 29);
        search2(mat, 4, 29);
    }
    /**
     * Simple Solution
     *
     * Approach: The simple idea is to traverse the array and to search elements one by one.
     * Algorithm:
     * Run a nested loop, outer loop for row and inner loop for the column
     * Check every element with x and if the element is found then print “element found”
     * If the element is not found, then print “element not found”.
     */
    static int search(int[][] mat, int n, int x) {
        if (n == 0)
            return -1;
        //traverse through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if the element is found
                if (mat[i][j] == x) {
                    System.out.println("Element found at ("+i+","+j+")");
                    return 1;
                }
            }
        }
        System.out.println("Element not found");
        return 0;
    }
    /**
     * Efficient Solution
     * Efficient Solution
     *
     * Approach:
     * The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases.
     * The given number is greater than the current number: This will ensure that all the elements in the current row are smaller than the given number as the pointer is already at the right-most elements and the row is sorted. Thus, the entire row gets eliminated and continues the search for the next row. Here, elimination means that a row needs not be searched.
     * The given number is smaller than the current number: This will ensure that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search for the previous column, i.e. the column on the immediate left.
     * The given number is equal to the current number: This will end the search.
     *
     * Algorithm:
     * Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
     * Run a loop until i = 0
     * Check if the current element is greater than x then decrease the count of j. Exclude the current column.
     * Check if the current element is less than x then increase the count of i. Exclude the current row.
     * If the element is equal, then print the position and end.
     * Thanks to devendraiiit for suggesting the approach below.
     */
    static void search2(int[][]mat, int n, int x) {
        //set indexes for the top right
        int i = 0, j = n - 1;
        // element
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.println("n found at "+i+","+j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else
                i++;
        }
    }
}
