package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci numbers, commonly denoted F(n), form a sequence such that each number is the sum of the
 * two preceding ones, starting from 0 and 1:
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *
 * Given n, calculate F(n).
 *
 * Input: n = 2  Output: 1
 * Input: n = 9  Output: 34
 */
public class Fibonacci {

    /**
     * Plain recursion. T(n) = T(n-1) + T(n-2), which is exponential: the same subproblems are
     * recomputed over and over, as the recursion tree shows.
     *
     *                  fib(5)
     *              /           \
     *          fib(4)          fib(3)
     *         /     \          /     \
     *     fib(3)   fib(2)   fib(2)  fib(1)
     *     /    \    /   \    /   \
     * fib(2) fib(1) ...
     *
     * Extra space: O(n) for the call stack.
     */
    public static int recursive(int n) {
        if (n <= 1) return n;
        return recursive(n - 1) + recursive(n - 2);
    }

    /**
     * Top-down DP: the same recursion, but each result is cached so it is computed only once. O(n) time and space.
     */
    public static int memoized(int n) {
        return memoized(n, new HashMap<>());
    }

    private static int memoized(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return n;
        Integer cached = memo.get(n);
        if (cached != null) return cached;
        int result = memoized(n - 1, memo) + memoized(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    /**
     * Bottom-up DP: iterate up to n, storing each answer in an array and using the two previous entries
     * to compute the current one. O(n) time and space.
     */
    public static int tabulated(int n) {
        if (n <= 1) return n;
        int[] table = new int[n + 1];
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    /**
     * Space-optimised bottom-up: only the previous two numbers are ever needed. O(n) time, O(1) space.
     */
    public static int iterative(int n) {
        if (n <= 1) return n;
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * The Tribonacci sequence Tn is defined as follows:
     *
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * Given n, return the value of Tn.
     *
     * Input: n = 4   Output: 4  (T_3 = 0 + 1 + 1 = 2, T_4 = 1 + 1 + 2 = 4)
     * Input: n = 25  Output: 1389537
     *
     * Constraints: 0 <= n <= 37, so the answer fits within a 32-bit integer.
     */
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] table = new int[n + 1];
        table[1] = 1;
        table[2] = 1;
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2] + table[i - 3];
        }
        return table[n];
    }
}
