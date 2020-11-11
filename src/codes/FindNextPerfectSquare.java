package codes;

/**
 * You might know some pretty large perfect squares. But what about the NEXT one?
 *
 * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
 * Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
 *
 * If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
 *
 * Examples:
 *
 * findNextSquare(121) --> returns 144
 * findNextSquare(625) --> returns 676
 * findNextSquare(114) --> returns -1 since 114 is not a perfect
 */
public class FindNextPerfectSquare {

    public static void main(String[] args) {

        System.out.println(nextPerfectSquare(121));
    }

    static long nextPerfectSquare(int n){

        if(n != Math.floor(Math.sqrt(n)) * Math.floor(Math.sqrt(n))){
            return -1;
        }
        double tmp = Math.sqrt(n);
        tmp++;

        return (long)(tmp*tmp);
    }

    public static long findNextSquare(long sq) {
        long result;
        double d = Math.sqrt(sq);

        //if your number d is a integer result will be true, if not will be -1;
        //good luck)!
        if ( d % 1  == 0) {
            result = (long) Math.pow(++d, 2);
        } else result = -1;

        return result;
    }
}
