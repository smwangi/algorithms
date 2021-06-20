/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 3,-4};
        System.out.println(maxProduct(arr));
        System.out.println("Max Product 2: "+maxProduct2(arr));
    }
    public static int maxProduct(int[] nums) {
        int[] posProduct = new int[nums.length];
        int[] negProduct = new int[nums.length];
        int[] maxProduct = new int[nums.length];
        posProduct[0] = negProduct[0] = maxProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = posProduct[i - 1] * nums[i];
            int b = negProduct[i - 1] * nums[i];
            posProduct[i] = Math.max(Math.max(a, b), nums[i]);
            negProduct[i] = Math.min(Math.min(a, b), nums[i]);
            maxProduct[i] = Math.max(posProduct[i], maxProduct[i - 1]);
        }
        return maxProduct[nums.length - 1];
    }
    
    /**
     * Keep track of the minimum and maximum products while scanning arr.
     * Imagine that we have both max_prod[i] and min_prod[i] i.e. max product ending at i and min product ending at i.
     *
     * Now if we have a negative number at arr[i+1] and if min_prod[i] is negative, then the product of the two will be positive and can potentially be the largest product.
     * So, the key point here is to maintain both the max_prod and min_prod such that at iteration i, they refer to the max and min product ending at index i-1.
     *
     * In short, One can have three options to make at any position in the array.
     *
     * You can get the maximum product by multiplying the current element with the maximum product calculated so far.
     * (might work when current element is positive).
     * You can get the maximum product by multiplying the current element with minimum product calculated so far. (might work when current
     * element is negative).
     * The current element might be a starting position for maximum product subarray.
     */
    public static int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = nums[0];
        int max = ans;
        int min = ans;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            } else {
                int temp = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * temp);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
