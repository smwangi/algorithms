/**
 * Find a peak element in a 2D array
 * An element is a peak element if it is greater than or equal to its four neighbors, left, right, top and bottom.
 * For example neighbors for A[i][j] are A[i-1][j], A[i+1][j], A[i][j-1] and A[i][j+1]. For corner elements,
 * missing neighbors are considered of negative infinite value.
 *
 * Examples:
 *
 * Input : 10 20 15
 *         21 30 14
 *         7  16 32
 * Output : 30
 * 30 is a peak element because all its
 * neighbors are smaller or equal to it.
 * 32 can also be picked as a peak.
 *
 * Input : 10 7
 *         11 17
 * Output : 17
 * Recommended: Please try your approach on {IDE} first, before moving on to the solution.
 *
 *
 * Below are some facts about this problem:
 * 1: A Diagonal adjacent is not considered as neighbor.
 * 2: A peak element is not necessarily the maximal element.
 * 3: More than one such elements can exist.
 * 4: There is always a peak element. We can see this property by creating some matrices using pen and paper.
 *
 * Method 1: (Brute Force)
 * Iterate through all the elements of Matrix and check if it is greater/equal to all its neighbors. If yes, return the element.
 *
 * Time Complexity: O(rows * columns)
 * Auxiliary Space: O(1)
 *
 * Method 2 : (Efficient)
 * This problem is mainly an extension of Find a peak element in 1D array. We apply similar Binary Search based solution here.
 *
 * Consider mid column and find maximum element in it.
 * Let index of mid column be ‘mid’, value of maximum element in mid column be ‘max’ and maximum element be at ‘mat[max_index][mid]’.
 * If max >= A[index][mid-1] & max >= A[index][pick+1], max is a peak, return max.
 * If max < mat[max_index][mid-1], recur for left half of matrix.
 * If max < mat[max_index][mid+1], recur for right half of matrix.
 */
public class PeakElemIn2DArr {
    public static void main(String[] args) {
        int[][] arr = {{ 10, 8, 10, 10 },
                { 14, 13, 12, 11 },
                { 15, 9, 11, 21 },
                { 16, 17, 19, 20 }};
    
        // Number of Columns
        int rows = 4, columns = 4;
        System.out.println(findPeak(arr, rows, columns));
    }
    static int findMax(int[][] arr, int rows, int mid, int max) {
        int max_index = 0;
        for (int i = 0; i < rows; i++) {
            if (max < arr[i][mid]) {
                //Saving global maximum and its index to check its neighbours
                max = arr[i][mid];
                max_index = i;
            }
        }
        return max_index;
    }
    // function to change the value of [max]
    static int Max(int[][] arr, int rows, int mid, int max) {
        for (int i = 0; i < rows; i++) {
            if (max < arr[i][mid]) {
                // Saving global maximum and its index to check its neighbours
                max = arr[i][mid];
            }
        }
        return max;
    }
    // Function to find a peak element
    static int findPeakRec(int[][] arr, int rows, int cols, int mid) {
        // Evaluating max of mid columns
        // Note max is passed by reference
        int max = 0;
        int max_index = findMax(arr, rows, mid, max);
        max = Max(arr, rows, mid, max);
        // If we are on the first or last column, max is a peak
        if (mid == 0 || mid == cols - 1)
            return max;
        // If mid column maximum is also peak
        if (max >= arr[max_index][mid - 1] && max >= arr[max_index][mid + 1])
            return max;
        // If max is less than its left
        if (max < arr[max_index][mid - 1])
            return findPeakRec(arr, rows,cols,(int) (mid - Math.ceil((double) mid / 2)));
        // If max is less than its left
        // If (max < arr[max_index][mid+1]
        return findPeakRec(arr, rows, cols, (int) (mid + Math.ceil((double) mid / 2)));
    }
    // A wrapper over findPeakRec()
    static int findPeak(int[][] arr, int rows, int cols) {
        return findPeakRec(arr, rows, cols, cols / 2);
    }
}
