package codes;

/**
 * Power of Two
 *
 * Solution
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 218;
        System.out.println(isPowerOfTwo(n));
    }

    static  boolean isPowerOfTwo(int n){
        System.out.println(Math.round(Math.log(n))+" "+ Math.round(Math.log(2)));
        return n > 0 && n == Math.pow(2,Math.round(Math.log(n)/Math.log(2)));
    }
}
