/**
 * Find the maximum difference between two array elements that satisfies the given constraints
 * Input:  { 2, 7, 9, 5, 1, 3, 5 }
 *
 * Output: The maximum difference is 7.
 *
 * The pair is (2, 9)
 */
public class MaxArrElemDiff {
    public static void main(String[] args) {
        int[] A = { 2, 7, 9, 5, 1, 3, 5 };
        System.out.println("The maximum difference is " + diff(A));
        System.out.println("The maximum difference is " + diff2(A));
    }
    // Naive function to find the maximum difference between two elements in
    // an array such that the smaller element appears before the larger element
    public static int diff(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length - 1; i++)
        {
            for (int j = i + 1; j < A.length; j++) {
                diff = Integer.max(diff, A[j] - A[i]);
            }
        }
        
        return diff;
    }
    /**
     * We can solve this problem in Linear time. The idea is to traverse the array from the right and keep track of the
     * maximum difference found so far. If the current element is less than the maximum element found so far and their difference
     * is more than the maximum difference found so far, update the maximum difference with the current difference
     *
     */
    // Function to calculate the maximum difference between two elements in an
    // array such that a smaller element appears before a larger element
    public static int diff2(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
        int max_so_far = A[n-1];
    
        // traverse the array from the right and keep track of the maximum element
        for (int i = n - 2; i >= 0; i--)
        {
            // update `max_so_far` if the current element is greater than the
            // maximum element
            if (A[i] > max_so_far) {
                max_so_far = A[i];
            }
            // if the current element is less than the maximum element,
            // then update the difference if required
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
            }
        }
    
        // return difference
        return diff;
    }
}
