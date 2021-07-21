/**
 * Find n-th term of series 1, 3, 6, 10, 15, 21
 * Examples:
 *
 * Input : 3
 * Output : 6
 *
 * Input : 4
 * Output : 10
 * Naive Approach:
 * The series basically represents sum of natural numbers. First term is sum of single number. Second term is sum of two numbers,
 * and so on. A simple solution is to add the first n natural numbers.
 */
public class NthTermOfSeries {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(term(n));
        System.out.println(term2(n));
    }
    static int term(int n) {
        // Loop to add numbers
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i;
        }
        return ans;
    }
    /**
     * Efficient Approach:
     * The pattern in this series is nth term is equal to sum of (n-1)th and n.
     * Example:
     *  n = 2
     * 2nd term equals to sum of 1st term and 2 i.e
     * A2 = A1 + 2
     *    = 1 + 2
     *    = 3
     *
     * Similarly,
     * A3 = A2 + 3
     *    = 3 + 3
     *    = 6 and so on..
     *
     * A(n) = A(n - 1) + n
     *      = A(n - 2) + n + (n - 1)
     *      = A(n - 3) + n + (n - 1) + (n - 2)
     *        .
     *        .
     *        .
     *      = A(1) + 2 + 3... + (n-1) + n
     *
     * A(n) = 1 + 2 + 3 + 4... + (n - 1) + n
     *      = n(n + 1) / 2
     *
     * i.e A(n) is sum of First n natural numbers.
     */
    static int term2(int n) {
        return n * (n + 1) / 2;
    }
}
