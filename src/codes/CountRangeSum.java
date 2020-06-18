package codes;

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class CountRangeSum {

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;
        countRangeSum(nums,lower,upper);
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1;j<nums.length;j++){
                System.out.println(nums[i]+nums[j]+" i "+nums[i]+" j "+nums[j]);
            }
        }
        return 0;
    }
}
