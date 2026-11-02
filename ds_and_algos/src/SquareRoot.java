/**
 * Given an integer x, find it’s square root. If x is not a perfect square, then return floor(√x).
 *
 * Examples :
 *
 * Input: x = 4
 * Output: 2
 * Explanation:  The square root of 4 is 2.
 *
 * Input: x = 11
 * Output: 3
 * Explanation:  The square root of 11 lies in between
 * 3 and 4 so floor of the square root is 3.
 */
public class SquareRoot {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(floorSqrt(x));
    }
    /**
     * Algorithm:
     * Take care of some base cases, i.e when the given number is 0 or 1.
     * Create some variables, lowerbound l = 0, upperbound r = n, where n is the given number, mid and ans to store the answer.
     * Run a loop until l <= r , the search space vanishes
     * Check if the square of mid (mid = (l + r)/2 ) is less than or equal to n, If yes then search for a larger value in second half of search space, i.e l = mid + 1, update ans = mid
     * Else if the square of mid is more than n then search for a smaller value in first half of search space, i.e r = mid – 1
     * Print the value of answer ( ans)
     */
    static int floorSqrt(int x) {
        // Base cases
        if (x == 0 || x == 1)
            return x;
        // Do binary search for floor(sqrt(x))
        long start = 1, end = x, ans = 0;
        while (start <= end) {
            int mid = (int) (start + (end - start) / 2);
            // If x is a perfect square
            if (mid * mid == x)
                return mid;
            // since we need floor, we update answer when mid*mid is smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else
                end = mid - 1;
        }
        return (int) ans;
    }
}
