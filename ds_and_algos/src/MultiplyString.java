import java.util.Arrays;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class MultiplyString {
    public static void main(String[] args) {
        MultiplyString multiplyString = new MultiplyString();
        String num1 = "123", num2 = "456";
        System.out.println(multiplyString.multiply(num1, num2));
    }
    
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        int[] ans = new int[num1.length() + num2.length() - 1];
        
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                System.out.print(ans[i + j]+" i "+i+" j "+j+" <end> ");
                 //System.out.println(num1.charAt(i) - '0');
                 //System.out.println(num2.charAt(i) - '0');
                System.out.println();
            }
        }
        System.out.println(Arrays.toString(ans));
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int[] n1 = new int[num1.length()];
        for (int i = 0; i < n1.length; i++)
            n1[i] = num1.charAt(i) - '0';
        
        int[] results = new int[n1.length + num2.length() - 1];
        for (int i = 0; i < num2.length(); i++) {
            int m = num2.charAt(i) - '0';
            for (int j = 0; j < n1.length; j++) {
                results[i + j] += m*n1[j];
            }
        }
        int d = 0;
        for (int i = results.length - 1; i > 0; i--) {
            d += results[i];
            results[i] = d % 10;
            d /= 10;
        }
        results[0] += d;
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : results)
            stringBuilder.append(n);
        
        return stringBuilder.toString();
    }
}
