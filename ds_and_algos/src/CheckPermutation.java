import java.util.Arrays;

/**
 * Given two strings, write a method to check if one is a permutation of the other.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "tac";
        System.out.println(permutation(s1, s2));
        System.out.println(permutationCharCount(s1, s2));
    }
    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    /**
     * Sort the strings
     * Compare the sorted versions of the string
     */
    static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
    /**
     * Solution 2
     * Check if the string has identical character counts
     */
    static boolean permutationCharCount(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] characters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            characters[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            characters[s2.charAt(i) - 'a']--;
            if (characters[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
