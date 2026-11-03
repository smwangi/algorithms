package arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 *
 * Constraints:
 *
 *     2 <= nums.length <= 105
 *     -30 <= nums[i] <= 30
 *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Follow up:
 *
 *     Could you solve it in O(n) time complexity and without using division?
 *     Could you solve it with O(1) constant space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // output[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            // output[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            output[i] = nums[i - 1] * output[i - 1];
        }

        // right contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so right starts at 1
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
