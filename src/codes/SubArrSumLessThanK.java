/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays
 * where the product of all the elements in the subarray is strictly less than k.
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class SubArrSumLessThanK {
    public static void main(String[] args) {
        int k = 100;
        int[] arr = {10, 5, 2, 6};
        System.out.println(numSubArrSumLessThanK(arr, k));
    }
    
    /**
     * Sliding Window
     * Foreach right, we call opt(right) the smallest left so that the product of the subarray nums[left]*nums[left+1]*...*nums[right]
     * is less than k. opt  is a monotone increasing function, so we can use a sliding window
     *
     * Algorithm
     * Our loop invariant is that left is the smallest value so that the product in the window prod = nums[left]*nums[left+1]*...*nums[right] is less than k
     * For every right, we update left and prod to maintain this invariant. Then, the number of intervals with subarray
     * product less than k and with right-most coordinate right, is right - left + 1. We'll count all of these for each value of right
     *
     * @param arr
     * @return
     */
    static int numSubArrSumLessThanK(int[] arr, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < arr.length; right++) {
            prod *= arr[right];
            while (prod >= k) {
                prod /= arr[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
