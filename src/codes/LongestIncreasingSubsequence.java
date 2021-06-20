import java.util.*;

/**
 * Find the longest increasing subsequence of a given array of integers, A.
 *
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 *
 *
 * Input Format:
 *
 * The first and the only argument is an integer array A.
 * Output Format:
 *
 * Return an integer representing the length of the longest increasing subsequence.
 * Constraints:
 *
 * 1 <= length(A) <= 2500
 * 1 <= A[i] <= 2000
 * Example :
 *
 * Input 1:
 *     A = [1, 2, 1, 5]
 *
 * Output 1:
 *     3
 *
 * Explanation 1:
 *     The sequence : [1, 2, 5]
 *
 * Input 2:
 *     A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
    
        List<Integer> A = Arrays.asList(1, 2, 1, 5);
        System.out.println(lis(A));
        int[] arr = {1, 2, 1, 5};
        System.out.println(longIncConseqSubSeq(arr));
    }
    
    /**
     * This method relies on the fact that the longest increasing subsequence possible upto the ith
     *   index in a given array is independent of the elements coming later on in the array.
     *   Thus, if we know the length of the LIS upto i^th index, we can figure out the length of the LIS possible by
     *   including the (i+1)th element based on the elements with indices j such that 0 ≤ j ≤ (i+1).
     *
     * We make use of a dp array to store the required data. dp[i] represents the length of the longest increasing subsequence
     * possible considering the array elements up to the ith index only ,by necessarily including the ith element.
     * In order to find out dp[i], we need to try to append the current element(nums[i]) in every possible increasing
     * subsequences up to the (i-1)th index(including the (i-1)th index), such that the new sequence formed by adding
     * the current element is also an increasing subsequence. Thus, we can easily determine dp[i]dp[i] using:
     *
     * dp[i] = max(dp[j]) + 1, max(dp[j])+1,∀0 ≤ j < i and num[i] > num[j]
     *
     * At the end, the maximum out of all the dp[i]dp[i]'s to determine the final result.
     * LIS (length) = max(dp[i]),∀0 ≤ i < n
     */
    static int lis(List<Integer> A) {
        int n = A.size();
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
    
    static int longIncConseqSubSeq(int[] arr) {
        int n = arr.length;
        // create hashmap to save latest consequent
        // number as "key" and its length as "value"
        HashMap<Integer, Integer> map = new HashMap<>();
    
        // put first element as "key" and its length as "value"
        map.put(arr[0], 1);
        for (int i = 1; i < n; i++) {
        
            // check if last consequent of arr[i] exist or not
            if (map.containsKey(arr[i] - 1)) {
            
                // put the updated consequent number
                // and increment its value(length)
                map.put(arr[i], map.get(arr[i] - 1) + 1);
            
                // remove the last consequent number
                map.remove(arr[i] - 1);
            }
        
            // if their is no last consequent of
            // arr[i] then put arr[i]
            else {
                map.put(arr[i], 1);
            }
        }
        return Collections.max(map.values());
    }
}
