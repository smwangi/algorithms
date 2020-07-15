
public class FibonacciRecursive {

    public static void main(String[] args) {
        
        int k = recursive(2);
        System.out.println(k);
    }

    private static int recursive(int n){
        if(n == 0 || n == 1)
            return n;
        return recursive(n-1) + recursive(n-2);
    }
}