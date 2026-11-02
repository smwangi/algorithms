/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
    static String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
            if (j >= 0)
                System.out.println(j+" "+i+" char at i "+s.charAt(i)+" char at j "+s.charAt(j));
        }
        if (i == s.length())
            return s;
        
        String suffix = s.substring(i);
        System.out.println("Suffix "+suffix);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + suffix;
    }
}
