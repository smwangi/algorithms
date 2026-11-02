/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * Example 2:
 *
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 *
 * Dynamic Programming
 */
public class MaxLenOfRepeatedSubArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int len = findLength(nums1, nums2);
        System.out.println(len);
    }
    public static int findLength(int[] nums1, int[] nums2) {
        // use dynamic programming.
        // both arrays are contiguous
        // since  a common subarray of A and B must start from A[i] and B[j], let dp[i][j] be the longest common prefix of
        // A[i:] and B[j:]. Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1]. Also the answer is max(dp[i][j]) over all i,j.
        // We can transform bottom-up dynamic programming to find answers based on this recurrence.
        // Bottom-UP
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
        int ans = 0;

        for (int i = nums1.length - 1; i >=0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;
    }
}
