/**
 * Given an integer array, find the largest subarray formed by consecutive integers.
 * The subarray should contain all distinct values.
 * For example:
 * Input:  { 2, 0, 2, 1, 4, 3, 1, 0 }
 *
 * Output: The largest subarray is { 0, 2, 1, 4, 3 }
 *
 * The idea is to consider every sub-array and keep track of the largest subarray found so far, formed by consecutive
 * integers. For a subarray to contain consecutive integer,
 *  > The difference between the maximum and minimum element in it should be exactly equal to the subarray's length minus one.
 *  > All elements in the array should be distinct (we can check this by inserting the elements in a set or using a visited array).
 *
 *  The time complexity of the above solution O(n3) and requires O(n) extra space, where n is the size of the input.
 */
public class LargestSubArrConseqIntegers {
    public static void main(String[] args) {
        int[] A = { 2, 0, 2, 1, 4, 3, 1, 0 };
    
        findMaxSubArray(A);
    }
    //Function to check if sub-array A[i...j] is formed by consecutive integers.
    // min and max denote the minimum and maximum element in the sub-array.
    static boolean isConsecutive(int[] A, int i, int j, int min, int max) {
        //For array to contain consecutive integers, the difference between the maximum and minimum element in it
        //should be exactly j-i
        if (max - min != j - i) {
            return false;
        }
        //create a visited array (we can also use a set)
        boolean[] visited = new boolean[j - i + 1];
        //traverse the sub-array and check if each element appears only once
        for (int k = i; k <= j; k++) {
            // if the element is seen before, return false
            if (visited[A[k] - min]) {
                return false;
            }
            //mark the element as seen
            visited[A[k] - min] = true;
        }
        // we reach here all the element in the array are distinct
        return true;
    }
    
    static void findMaxSubArray(int[] A) {
        int len = 1;
        int start = 0, end = 0;
        //consider each subarray formed by A[i...j]
        //i denotes the beginning od the subarray
        for (int i = 0; i < A.length - 1; i++) {
            //stores the minimum and maximum element in sub array A[i...j]
            int min_val = A[i], max_val = A[i];
            //j denotes the beginning of the subarray
            for (int j = i + 1; j < A.length; j++) {
                //update the minimum and maximum elements of the sub-array
                min_val = Math.min(min_val, A[j]);
                max_val = Math.max(max_val, A[j]);
                // check if A[i..j] is formed by consecutive integers
                if (isConsecutive(A, i, j, min_val, max_val)) {
                    if (len < max_val - min_val + 1) {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        // print the maximum length subarray
        System.out.println("The largest subarray is [" + start + ", " + end + "]");
    }
}
