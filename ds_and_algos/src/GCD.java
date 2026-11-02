/**
 * GCD
 */
public class GCD {

    public static void main(String[] args) {
        
        gcdForLoop(81, 253);
        gcdWhileLoop(253, 81);
    }

    static void gcdForLoop(int a, int b){
        int gcd = 1;

        for(int i = 1; i < a && i < b; i++){
            //Checks if i i is a factor of both integers
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        System.out.printf("GCD of %d and %d is %d. ",a,b,gcd);
    }

    static void gcdWhileLoop(int a, int b){

        while(a != b){
            if(a > b){
                a -=b;
            }else{
                b -= a;
            }
        }
        System.out.printf("GCD While Loop, %d. ",a);
    }
}