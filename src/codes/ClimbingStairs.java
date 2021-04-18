/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(3));
        System.out.println(c.climbStairsDP(3));
    }
    /**
     * SOLN
     * Approach 1: Brute Force
     *
     * In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step.
     * At every step we are calling the function climbStairs for step 111 and 222,
     * and return the sum of returned values of both functions.
     *
     * climbStairs(i,n)=(i+1,n) + climbStairs(i+2,n)
     *
     * where i defines the current step and n defines the destination step.
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        return climb(0,n);
    }

    private int climb(int i,int n){
        if(i > n)return 0;
        if(i == n) return 1;
        return climb(i+1,n) + climb(i+2,n);
    }

    /**
     * Dynamic Programming
     * 
     * As we can see this problem can be broken into subproblems, and it contains the optimal substructure property i.e.
     * its optimal solution can be constructed efficiently from optimal solutions of its subproblems,
     * we can use dynamic programming to solve this problem.
     *
     * One can reach ithi^{th}ith step in one of the two ways:
     *
     *     Taking a single step from (i−1)th step.
     *
     *     Taking a step of 2 from (i−2)th step.
     *
     * So, the total number of ways to reach ith is equal to sum of ways of reaching (i−1)th
     * step and ways of reaching (i−2)th step.
     *
     * Let dp[i] denotes the number of ways to reach on ith step:
     *
     * dp[i]=dp[i−1]+dp[i−2]
     *
     *
     */
    private int climbStairsDP(int n){
        if(n == 1)return 1;

        int[]dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<= n; i++){
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
