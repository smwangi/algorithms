/**
 * Find the smallest subarray length whose sum of elements is greater than `k`
 *
 * Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 20
 * Output: {6, 7, 8}
 *
 *
 * Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 7
 * Output: {8}
 *
 *
 * Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 21
 * Output: {5, 6, 7, 8}
 *
 *
 * Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 40
 * Output: No subarray exists
 *
 * Sliding Window
 * The idea is to maintain a window that ends at the current element, and the sum if its elements is less than or equal to the given sum.
 * If the current window's sum becomes more than the given sum at any point of time, then the window is unstable and continue removing
 * elements from the window left till it becomes stable again. Also update the result if the unstable window's length is less than
 * the minimum found so far.
 */
public class SmallestSubArrLen {
    public static void main(String[] args) {
        // an array of positive numbers
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 21;
    
        // find the length of the smallest subarray
        int len = findSmallestSubarrayLen(A, k);
    
        if (len != Integer.MAX_VALUE) {
            System.out.print("The smallest subarray length is " + len);
        }
        else {
            System.out.print("No subarray exists");
        }
    }
    public static int findSmallestSubarrayLen(int[] A, int k)
    {
        // stores the current window sum
        int windowSum = 0;
        
        // stores the result
        int len = Integer.MAX_VALUE;
        
        // stores the window's starting index
        int left = 0;
        
        // maintain a sliding window `[left…right]`
        for (int right = 0; right < A.length; right++)
        {
            // include the current element in the window
            windowSum += A[right];
            
            // the window becomes unstable if its sum becomes more than `k`
            while (windowSum > k && left <= right)
            {
                // update the result if the current window's length is less than the
                // minimum found so far
                len = Integer.min(len, right - left + 1);
                
                // remove elements from the window's left side till the window
                // becomes stable again
                windowSum -= A[left];
                left++;
            }
        }
        
        // return result
        return len;
    }
}
