package codes;

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
        int n = 22;
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
}
