/**
 * Prime Number Program in Java. Prime number in Java: Prime number is a number that is greater than 1 and divided by 1 or itself only.
 * In other words, prime numbers can't be divided by other numbers than itself or 1.
 * For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.
 */
public class PrimeNumberCounter {

    public static void main(String[] args) {
        System.out.println(isPrime(31));
    }
    static boolean isPrime(int n) {
        for (int x = 2; x <= Math.sqrt(n); x++) {
            if (n % x == 0)
                return false;
        }
        return true;
    }
}
