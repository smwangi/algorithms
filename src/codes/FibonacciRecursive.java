package codes;

import java.util.Arrays;

/**
 *
 Program for Fibonacci numbers

 The Fibonacci numbers are the numbers in the following integer sequence.

 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

 In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

 Fn = Fn-1 + Fn-2

 with seed values

 F0 = 0 and F1 = 1.

 Given a number n, print n-th Fibonacci Number.
 Examples:

 Input  : n = 2
 Output : 1

 Input  : n = 9
 Output : 34

 Write a function int fib(int n) that returns Fn. For example, if n = 0, then fib() should return 0. If n = 1, then it should return 1. For n > 1, it should return Fn-1 + Fn-2

 For n = 9
 Output:34

 Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
 We can observe that this implementation does a lot of repeated work (see the following recursion tree). So this is a bad implementation for nth Fibonacci number.

 fib(5)
 /                \
 fib(4)                fib(3)
 /        \              /       \
 fib(3)      fib(2)         fib(2)   fib(1)
 /    \       /    \        /      \
 fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
 /     \
 fib(1) fib(0)

 Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
 */
public class FibonacciRecursive {

    public static void main(String[] args) {
        
        int k = recursive(9);
        System.out.println(k);
        System.out.println(fib(9));
        System.out.println(fibOptimized(9));
    }

    private static int recursive(int n){
        if(n == 0 || n == 1)
            return n;
        return recursive(n-1) + recursive(n-2);
    }

    //Using dynamic programming
    //By storing the Fibonacci numbers calculated so far
    static int fib(int n){

        //Declare an array to store Fibonacci numbers.
        int[] arr = new int[n+2];//1 extra to handle case, n = 0

        //0th and 1st number of the series are 0 and 1
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n;i++){
            /* Add the previous 2 numbers in the series
         and store it */
            arr[i] = arr[i-1]+ arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }

    //Space Optimized Method
    static int fibOptimized(int n){
        int a = 0,b=1,c;

        if(n == 0)return a;

        for (int i = 2; i <=n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}