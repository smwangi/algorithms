import java.util.HashMap;
import java.util.Map;

/**
 * Bottom up
 */
public class Product1toN {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(product1toN(n));
    }
    
    //This approach uses O(1) space (O(n) time).
    public static int product1toN(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            //assume n > 1;
            result *= i;
        }
        return result;
    }
}
