package arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaxSubArraySum {

    // Kadane's algorithm: drop the running sum once it goes negative
    public static int kadane(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    // Kadane's algorithm as DP: the best sum ending at i either extends the best sum ending at i - 1 or starts fresh at i
    public static int kadaneDp(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}
