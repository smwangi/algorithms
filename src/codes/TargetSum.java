package codes;

import java.util.HashMap;
import java.util.Map;

/**
 * Solving the Target Sum problem with dynamic programming and more
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 *
 *
 * Constraints:
 *
 *     The length of the given array is positive and will not exceed 20.
 *     The sum of elements in the given array will not exceed 1000.
 *     Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int k = 3;
        System.out.println(findTargetSumWays(arr,k));
        System.out.println(findTargetSumWays2(arr,k));
        System.out.println(findTargetSumWays3(arr,k));
    }

    /**
     * Dynamic programming (simplified and optimized)
     * Firstly, we can trivially conclude that there are 0 ways to attain a target sum if the target sum exceeds the sum of all the values in the array.
     * Secondly, we can optimize the space complexity of our algorithm by using only a single array
     * This will most likely also improve the runtime of the algorithm, as we don’t need to allocate memory to create a new array at each iteration.
     *
     * The original problem statement is equivalent to: find the number of ways to gather a subset of nums that needs to be positive (P), and the rest negative (N), such that their sum is equal to target.
     *
     * Therefore…
     *
     * sum(P) - sum(N) = target
     * sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * sum(P) = (target + sum(nums)) / 2
     *
     * … the original problem statement may be converted into the following subset sum problem: find the number of ways to gather a subset of nums such that its sum is equal to (target + sum(nums)) / 2.
     *
     * We can also add another trivial check to our algorithm: if target + sum(nums) is not divisible by 2, we can return 0 because there is no solution (this follows from the last line in our derivation above).
     *
     * Therefore, the crux of this reformulated problem statement is (in pseudo-code):
     *
     * for the set of values up to some value V in nums:
     *     for some target sum S:
     *         number of ways to attain S =
     *             number of ways to attain S without V
     *             + number of ways to attain S-V with V
     *
     *
     *  number of ways to attain S without V is the value in the same column, but 1 row above, in our dynamic programming table.
     *
     * number of ways to attain S-V with V is the value in the column V columns to the left, but 1 row above, in our dynamic programming table.
     *
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findTargetSumWays(int[] arr, int k){
        int sum = 0;
        for(int num: arr)sum +=num;
        if(k > sum || -k < - sum || (k+sum) %2 == 1)return 0;
        int[]dp = new int[(k+sum)/2+1];
        dp[0] = 1;
        for(int num: arr){
            for (int i = dp.length-1;i >=num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[dp.length-1];
    }

    /**
     * Dynamic programming
     *
     * Our base case: when we have no values to add/subtract, we have a sum of 0, and therefore there is only one way to arrive at S = 0.
     *
     * The key idea in this dynamic programming solution is to only branch out from reachable target sums.
     *
     * At the first iteration (i.e. the outer for-loop), assume that we are on value x in our nums array. Therefore, we know intuitively that there is only one way to reach the target sum of +x and -x. (Explanation: you start with 0, and you either +x or -x.) Programmatically, we can express this logic by setting ways to reach x = ways to reach 0 and ways to reach -x = ways to reach 0.
     *
     * In subsequent iterations, we only care about starting from target sums that are already reachable. Assume that the second value is y. We know intuitively that after 2 iterations, we can only arrive at 4 possible target sums: x + y, x — y, -x + y, and-x — y. Note: These 4 values may not be distinct!
     *
     *
     */
    public static int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;

        for (int num: nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < dp.length; i++) {
                // Only branch out from reachable target sums
                if (dp[i] == 0) continue;                next[i + num] += dp[i];
                next[i - num] += dp[i];
            }
            dp = next;
        }

        return dp[sum + S];
    }

    public static int findTargetSumWays3(int[] nums, int S) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(nums, 0, S, dp);
    }

    private static int dfs(int[] nums, int index, int S, Map<String, Integer> dp) {
        String key = index + " " + S;
        if (index == nums.length && S == 0) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int sum = dfs(nums, index + 1, S + nums[index], dp) + dfs(nums, index + 1, S - nums[index], dp);
        dp.put(key, sum);
        return sum;
    }
}
