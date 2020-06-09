package codes;

public class PowerOfThree {

    public static void main(String[] args) {
        int n = 24;
        System.out.println(isPowerOfThree(n));
    }
    static boolean isPowerOfThree(int n){
        return n > 0 && n == (Math.pow(3,Math.round(Math.log(n)/Math.log(3))));
    }
}
