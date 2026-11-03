package math;

/**
 * GCD
 */
public class GCD {

    static int gcdForLoop(int a, int b){
        int gcd = 1;

        for(int i = 1; i <= a && i <= b; i++){
            //Checks if i i is a factor of both integers
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    static int gcdWhileLoop(int a, int b){

        while(a != b){
            if(a > b){
                a -=b;
            }else{
                b -= a;
            }
        }
        return a;
    }
}