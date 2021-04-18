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
public class NthStairCase {

    public static void main(String[] args) {
        NthStairCase stairCase = new NthStairCase();
        int n = 44;

        System.out.println(stairCase.climbStairs(n));
    }
    public int possibleWays(int n) {
        if(n < 0 || n > 45)return 0;
        if(n == 0) return 1;

        return possibleWays(n-1)+ possibleWays(n-2);//+ possibleWays(n-3);

    }
    public int getWays(int n) {
        if(n <= 1) return n;

        int result = 0;
        for (int i = 1; (i <= 2 && i <= n); i++)
            result += getWays(n-i);
        return result;
    }

    public int climbStairs(int n) {

        if(n==1){
            return 1;
        }

        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2;i < n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n-1];
    }
}
