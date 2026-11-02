import java.util.Arrays;

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
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] output_arr = new int[N];

        // output_arr[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        output_arr[0] = 1;

        for (int i = 1; i<N; i++) {
            // output_arr[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            System.out.println("i: "+i+ " nums[i-1]: "+nums[i-1]+" output_arr[i-1]: "+output_arr[i-1]);
            output_arr[i] = nums[i-1] * output_arr[i-1];
        }
        Arrays.stream(output_arr).boxed().forEach(x -> System.out.print(x+", "));
        System.out.println();
        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = N-1; i >= 0; i--) {
            output_arr[i] = output_arr[i] * R;
            R = R * nums[i];
        }
        return output_arr;
    }
}

