
import java.util.HashSet;
import java.util.Set;

/**
 * Write a Java program to check whether a given number is a happy number or unhappy number.
 *
 * Happy number: Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1, or it loops endlessly in a cycle which does not include 1.
 * An unhappy number is a number that is not happy.
 * The first few unhappy numbers are 2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20.
 */
public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappyNumber(n));
    }

    private static boolean isHappyNumber(int n){
        Set<Integer> unique = new HashSet<>();
        while (unique.add(n)){
            int value = 0;
            while (n > 0){
                value += Math.pow(n%10,2);
                n/=10;
            }
            n = value;
        }
        return n == 1;
    }
    /**
     * Instead of keeping track of just one value in the chain, we keep track of 2, called slow number and fast runner.
     * At each step of the algorithm, the slow runner goes forward by 1 number in the chain, and the fast runner goes
     * forward by 2 numbers (nested calls to the getNext(n) function
     * If n is a happy number i.e. there is no cycle, then the fast runner will eventually get to 1 before the slow runner.
     * If n is not a happy number, then eventually the fast runner and the slow runner will be on the same number.
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(n);
            fastRunner = getNext((getNext(n)));
        }
        return fastRunner == 1;
    }
}
