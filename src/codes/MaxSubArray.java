
import java.util.Arrays;

/**
 * Sliding Window Algorithm (Track the maximum of each subarray of size k)
 *
 * Given an array and integer k, write an algorithm to find the maximum element in each subarray of size k.
 *
 * int [] nums = { 1, 2, 3, 2, 4, 1, 5, 6,1};
 * Output: 3, 3, 4, 4, 5, 6, 6
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 4, 1, 5, 6,1};

        slidingWindow(arr,3);
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("\nMax SubArr Sum: "+maxSubArray(a));
        System.out.println("\nMax SubArr Sum 2: "+maxSubArray2(a));
    }

    /**
     * Naïve Approach:
     *
     *     Have 2 nested loops.
     *     Outer loop will navigate the array.
     *     Inner loop with track the maximum element in every k elements (all k windows or all subarrays with size k)
     *
     * Time Complexity: O(nk) where n is the size of array and k is the subarrays size.
     */
    public static void slidingWindow(int[] nums, int k){
        for(int i = 0; i <= nums.length - k; i++){
            int max = nums[i];
            int[] a = new int[3];
            for(int j = 0; j < k; j++){
                a[j] = nums[i+j];
                if(nums[i+j] > max){
                    max = nums[i+j];
                    System.out.print(max+" ");
                }
                
            }
        }
    }
    
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Example 3:
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
    
    public static int maxSubArray2(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}
