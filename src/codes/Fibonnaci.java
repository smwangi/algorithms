import java.util.Arrays;

public class Fibonnaci {

    public static void main(String[] args) {
        System.out.println("Fibonnaci");

       int res =printFibonnaci(2);
       System.out.println(res+" ");
       int[] memo = new int[10 + 1];
       System.out.println(fib(10, memo));
       System.out.println(getNthFib(10));
    }

    private static int printFibonnaci(int n){

       if(n <= 1)
        return n;
        return memoize(n);        
    }

    private static int memoize(int n){
        int[] cache = new int[n+1];
        cache[1] = 1;
        //System.out.println(Arrays.toString(cache));
        /**
         * iterate through N, storing each computed answer in an array along the way.
         * Use above array as a reference to the 2 previous numbers to calculate the current Fibonacci number.
         * Once we've reached the last number, return it's Fibonacci number.
         */
        for(int i = 2; i <= n;i++){
            System.out.println(i);
            cache[i] = cache[i-1]+cache[i-2];
           
        }
        System.out.print(Arrays.toString(cache));
        return cache[n];
    }
    
    static int fib(int n, int[] memo) {
        if (n < 0) return -1;
        else if (n == 0) return 1;
        else if (memo[n] > 0) return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
    static int getNthFib(int n) {
        if (n == 2) return 1;
        else if (n == 1) return 0;
        else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }
}