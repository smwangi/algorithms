/**
 * The idea is based on the fact that n'th number can be written as sum of natural number, that is n*(n+1)/2. The reasason for this is simple
 * base line of triangular grid has n dots, line above base has (n-1) dots and so on.
 */
public class TriangularNum {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(isTriangular(n));
    }
    /**
     * Method 1 (Simple)
     * We start with 1 and check if the number is equal to 1. If it is not, we add 2 to make it 3 and recheck with the number.
     * We repeat this procedure until the sum remains less than or equal to the number that is to be checked for being triangular.
     */
    static boolean isTriangular(int num) {
        if (num < 0)
            return false;
        // A triangular number must be sum of first n natural numbers
        int sum = 0;
        for (int n = 1; sum <= num; n++) {
            sum = sum + n;
            if (sum == num)
                return true;
        }
        return false;
    }
}
