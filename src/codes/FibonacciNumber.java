package codes;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 *
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int N = 5;
        System.out.println( fibonacciNumber.fib(N));
        int n = 2;
        System.out.println(fibonacciNumber.tribonacci(n));
    }

    public int fib0(int N) {
        int sum = 0;
        int[] arr = new int[N];
        arr[0] = 0;
        arr[1] = 1;

        sum = arr[0]+arr[1];

        for(int i = 2;i < N; i++){
            sum += arr[i-2] + arr[i-1];
        }
        return sum;
    }

    public int fib2(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }

        int prevPrev = 0;
        int prev = 1;
        int curr = 0;

        for(int i=1;i<N;i++){
            curr = prev+prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return curr;
    }

    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;

        int a = 0;
        int b = 1;
        int sum = a + b;

        while(N > 1){
            sum = a + b;
            a = b;
            b = sum;
            N--;
        }
        return sum;
    }

    /**
     * The Tribonacci sequence Tn is defined as follows:
     *
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * Given n, return the value of Tn.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 4
     * Output: 4
     * Explanation:
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     *
     * Example 2:
     *
     * Input: n = 25
     * Output: 1389537
     *
     *
     *
     * Constraints:
     *
     *     0 <= n <= 37
     *     The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
     * @param n
     * @return
     */
    public int tribonacci(int n) {

        if(n == 0)return 0;
        if(n == 1 || n == 2) return 1;

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3;i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n];
    }
}
