/**
 * Find maximum length sequence of continuous ones (Using Sliding Window)
 * { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }
 * The index to be replaced is 7
 *
 * The idea is to maintain a window containing at most one zero at any point and add elements to the window from the right
 * until it becomes unstable, The window becomes unstable if the total number of zeros in it becomes 2. if the window becomes unstable,
 * remove elements from its left till it becomes stable again (by removing the leftmost zero). If the window is stable and the current
 * window length is more than the maximum window found so far, update the index of 0 to be replaced.
 */
public class MaxLenSubsequence {
    
    public static void main(String[] args) {
        int[] A = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
    
        int index = findIndexofZero(A);
    
        if (index != -1) {
            System.out.print("Index to be replaced is " + index);
        }
        else {
            System.out.print("Invalid input");
        }
    }
    // Find the index of 0 to replace with 1 to get the maximum sequence
    // of continuous 1's using the sliding window technique
    public static int findIndexofZero(int[] A)
    {
        int left = 0;       // represents the window's starting index
        int count = 0;      // stores the total number of zeros in the current window
        int max_count = 0;  // stores the maximum number of 1's (including 0)
        
        int max_index = -1;         // stores the index of 0 to be replaced
        int prev_zero_index = -1;   // stores the index of previous zero
        
        // maintain a window `[left…i]` containing at most one zero
        for (int i = 0; i < A.length; i++)
        {
            // if the current element is 0, update `prev_zero_index` and
            // increase zeros count in the current window by 1
            if (A[i] == 0)
            {
                prev_zero_index = i;
                count++;
            }
            
            // the window becomes unstable if the total number of zeros in it becomes 2
            if (count == 2)
            {
                // remove elements from the window's left side till
                // we found a zero
                while (A[left] != 0) {
                    left++;
                }
                
                // remove the leftmost 0 so that window becomes stable again
                left++;
                
                // decrement count as 0 is removed
                count = 1;
            }
            
            // when we reach here, window `[left…i]` contains only
            // at most one zero; update the maximum count and index of 0
            // to be replaced if required
            
            if (i - left + 1 > max_count)
            {
                max_count = i - left + 1;
                max_index = prev_zero_index;
            }
        }
        
        // return index of 0 to be replaced or -1 if the array contains all 1's
        return max_index;
    }
}
