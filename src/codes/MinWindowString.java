import java.util.HashMap;
import java.util.Map;

/**
 * Min Window Substring
 * Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two strings,
 * the first parameter being the string N and the second parameter being a string K of some characters,
 * and your goal is to determine the smallest substring of N that contains all the characters in K.
 * For example: if strArr is ["aaabaaddae", "aed"] then the smallest substring of N that contains the characters a, e, and d is "dae"
 * located at the end of the string. So for this example your program should return the string dae.
 *
 * Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains all the characters in K is "aabd" which is located at the beginning of the string. Both parameters will be strings ranging in length
 * from 1 to 50 characters and all of K's characters will exist somewhere in the string N. Both strings will only contain lowercase
 * alphabetic characters.
 *
 * Examples
 * Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
 * Output: aksfaje
 * Input: new String[] {"aaffhkksemckelloe", "fhea"}
 * Output: affhkkse
 * Tags
 */

public class MinWindowString {
    
    public static void main(String[] args) {
    
    }
    //how to a solution for the minimum window substring that has a linear time complexity by using the two-pointer
    // sliding window approach and hash tables.
    static String minWindowString(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> charsInT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charsInT.put(c, charsInT.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0;
        return "";
    }
}
