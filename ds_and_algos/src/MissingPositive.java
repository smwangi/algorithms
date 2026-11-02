/**
 * Given an unsorted integer array nums, return the smallest missing positive integer/
 * You must implement an algorithm that runs in O(n) time and constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 * Solution:
 *  Numbers greater than n can be ignored because the missing integer must be in the range 1... n+1
 *  If each cell in the array were to contain positive integers only, we can use the negative of the stored number as aa flag to mark something(in this case the flag indicates this
 *  index was found in some cell of the array)
 */
public class MissingPositive {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }
    
    static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 1 mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // we can ignore those because if all number are > n then we will simply return 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <=0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1
        // 2 mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n)
                continue;
            num--; // for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }
}
