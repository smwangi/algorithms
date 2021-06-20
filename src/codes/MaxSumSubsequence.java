import java.util.Arrays;

/**
 * Find maximum sum of subsequence with no adjustment elements
 *
 * Given an array of integers, find maximum sum of subsequences of given array  where subsequence
 * contains no adjustment elements.
 */
public class MaxSumSubsequence {

    public static void main(String[] args) {
        int[] arr = {1,2,9,4,5,0,4,11,6};
       System.out.println( maxSum(arr,0,arr.length,Integer.MIN_VALUE));
        int[] A = { -8, -3, -6, -2, -5, -4 };//{ -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    
        System.out.println("The sum of contiguous subarray with the " +
                "largest sum is " + kadane(A));
    }

    //i index of current element
    // prev index of previous element included in sum
    private static int maxSum(int[] arr,int i, int n, int prev){
        //base case: all elements are processed
        if(i == n)
            return 0;

        //recur by excluding the current element
        int excl = maxSum(arr,i+1,n,prev);
        int incl = 0;
        //include the current element if it is not adjacent to the previous element considered
        if(prev+1 != i)
            incl = maxSum(arr,i+1,n,i)+arr[i];

        //return the maximum sum we get by inc or excl current item
        return Integer.max(incl,excl);
    }
    /**
     * Maximum Sum Subarray Problem (Kadane’s Algorithm)
     * Find a contiguous subarray within it that has the largest sum
     *
     * Input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
     *
     * Output: Subarray with the largest sum is {4, -1, 2, 1} with sum 6.
     *
     * We can solve this problem in linear time using Kadane's algorithm. The idea is to maintain a maximum (positive sum) subarray
     * "ending" at each index of the given array.
     *
     * Function to find the maximum sum of a contiguous subarray in a given integer array
     *
     */
    static int kadane(int[] A) {
        // find the maximum element present in a given array
        int max = Arrays.stream(A).max().getAsInt();
    
        // if the array contains all negative values, return the maximum element
        if (max < 0) {
            return max;
        }
        // Store the maximum sum subarray found so far
        int maxSoFar = 0;
        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere  = 0;
        // traverse the given array
        for (int i : A) {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            maxEndingHere = maxEndingHere + i;
            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            maxEndingHere = Integer.max(maxEndingHere, 0);
            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
    
}
