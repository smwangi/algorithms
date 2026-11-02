/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *  Overview
 *  The problem is similar to the classic Knapsack problem.
 *      * The basic idea is to understand that to partition an array into two subsets of equal sum say \text{subSetSum}subSetSum,
 *      * the \text{totalSum}totalSum of given array must be twice the \text{subSetSum}subSetSum
 *      *
 *      * \text{totalSum} = \text{subsSetSum} * 2totalSum=subsSetSum∗2
 *      *
 *      * This could also be written as, \text{subSetSum} = \text{totalSum}/2subSetSum=totalSum/2
 *      *
 *      * Example Assume \text{totalSum}totalSum of an array is 2020 and if we want to partition it into 2 subsets of equal sum,
 *      * then the \text{subSetSum}subSetSum must be (20/2) = 10(20/2)=10.
 *      *
 *      * Now, the problem to find the subset with a sum equals a given target. Here target is \text{subSetSum}subSetSum.
 *      *
 *      * It must be noted that the total sum of an array must be even, only then we can divide it into 2 equal subsets.
 *      * For instance, we cannot have an equal \text{subSetSum}subSetSum for an array with total sum as 2121.
 *      *
 *      * Note:
 *      *
 *      * Finding a subset with a sum equal to a given target is different than Subarray sum equals k.
 *      * Subarray is a contiguous sequence of array elements, whereas the subset could consist of any array elements
 *      * regardless of the sequence. But each array element must belong to exactly one subset.
 *      *
 *      * Let's discuss different algorithms to find the subset with a given sum.
 */
public class PartitionEqualSubSetSum {

    public static void main(String[] args) {
        PartitionEqualSubSetSum equalSubSetSum = new PartitionEqualSubSetSum();
        int[] nums  = {1,5,5,11};
        System.out.println(equalSubSetSum.canPartition(nums));
        System.out.println(equalSubSetSum.canPartition2(nums));
    }

    /**
     * Assume, there is an array nums of size nn and we have to find if there exists a subset with total
     * sum = subSetSum. For a given array element xx, there could be either of 2 possibilities:
     *
     * Case 1) x is included in subset sum. subSetSum = subSetSum − x
     *
     * Case 2) x is not included in subset sum, so we must take previous sum without xx. subSetSum = subSetSum
     *
     * We can use depth first search and recursively calculate the subSetSum for each case and check if either of them is true.
     * This can be formulated as
     *
     * isSum (subSetSum, n) = isSum(subSetSum- nums[n], n-1) ||  isSum(subSetSum, n-1)
     *
     * Base Cases
     *
     * If subSetSum is 0, return true ( Since we found a subset with sum subSetSum )
     * If subSetSum is less than 0, return false
     *
     * Complexity Analysis
     *
     * Time Complexity : (2^n), where n is equal to number of array elements. The recursive solution takes the form of a binary tree where
     *  there are 2 possibilities for every array element and the maximum depth of the tree could be n.
     *  The time complexity is exponential, hence this approach is exhaustive and results in Time Limit Exceeded (TLE).
     *
     * Space Complexity: O(N) This space will be used to store the recursion stack.
     * We can’t have more than n recursive calls on the call stack at any time.
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for(int num: nums){
            totalSum +=num;
        }
        //if total sum is odd, it cannot be partitioned.
        if(totalSum % 2 != 0) return false;

        int subSetSum = totalSum/2;

        int n = nums.length;

        return dfs(nums,n - 1, subSetSum );
    }

    public boolean dfs(int[] nums, int n, int subSetSum){
        //Base Case
        if(subSetSum == 0)
            return true;

        if(n == 0 || subSetSum < 0){
            return false;
        }

        return dfs(nums, n-1,subSetSum -nums[n-1]) || dfs(nums, n-1,subSetSum);
    }

    /**
     * Top Down Dynamic Programming - Memoization
     * We could have stored the results of our computation for the first time and used it later.
     * This technique of computing once and returning the stored value is called memoization.
     * We use a two dimensional array memo and follow the following steps for each recursive call :
     *
     * Check if subSetSum for a given nn exists in memo to see if we can avoid computing the answer and
     * return the result stored in memo.
     * Save the results of any calculations to memo.
     *
     *
     */
    public boolean canPartition2(int[] nums) {
        int totalSum = 0;

        for(int num: nums)
            totalSum +=num;

        //if total num is odd, it cannot be partitioned
        if(totalSum % 2 != 0)
            return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;

        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs2(nums, n-1,subSetSum,memo);
    }

    private boolean dfs2(int[] nums, int n, int subSetSum, Boolean[][]memo){
        //Base cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0) {
            return false;
        }

        //Check if subSetSum for a given n is already computed  and stored in memo
        if (memo[n][subSetSum] != null) {
            return memo[n][subSetSum];
        }

        boolean result = dfs2(nums,n-1,subSetSum - nums[n-1],memo) || dfs2(nums,n-1,subSetSum,memo);
        //store result in memo
        memo[n][subSetSum]=result;
        return result;
    }
}
