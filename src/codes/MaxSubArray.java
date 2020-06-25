package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                if(nums[i+j] > max)
                    max = nums[i+j];
            }
            System.out.println(Arrays.toString(a));
            System.out.println(max+" ");
        }
    }
}
