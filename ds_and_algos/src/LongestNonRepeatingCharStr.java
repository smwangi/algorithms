import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 * Given a string str, find the length of the longest substring without repeating characters.
 *
 * For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
 * For “BBBB” the longest substring is “B”, with length 1.
 */
public class LongestNonRepeatingCharStr {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);
    
        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of the longest " +
                "non-repeating character " +
                "substring is " + len);
        System.out.println(getUniqueCharacterSubstring(str));
    }
    // Use sliding window. Whenever we see repetition, we remove the previous occurrence and slide the window
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // Result
        int result = 0;
        for (int i = 0; i < n; i++) {
            // Note the default values in visited are false
            boolean[] visited = new boolean[256];
            for (int j = i; j < n; j++) {
                // if the current character is visited, break the loop
                if (visited[s.charAt(j)] == true)
                    break;
                //Else update the result if this window is larger, and mark current character as visited.
                else {
                    result = Math.max(result, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
            // Remove the first character of the previous window
            visited[s.charAt(i)] = false;
        }
        return result;
    }
    /**
     * Method 3 -> Linear Time.
     * This solution uses extra space to store the last indexes of already visited characters. The idea is to scan the string
     * from left to right, keep track of the maximum length Non-Repeating Character Substring seen so far in res. When we traverse the
     * string, to know the length of current window, we need two indexes.
     * 1. Ending index j: We consider current index as ending index.
     * 2. Starting index i: It is same as previous window if current character was not present in the previous window. To check if
     * the current character was present in the previous window or not, we store last index of every character in an array lastIndex[].
     * If lastIndex[str[j]] + 1 is more than previous start, then we update the start index i, else we keep same i.
     */
    static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int result = 0;
        // last index of all characters is initialized as -1;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        // initialize start of current window
        int i = 0;
        //move to end of current window
        for (int j = 0; j < n; j++) {
            // find the last index of s[j]
            //update i (starting index of the current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);
            // update result if we get a larger window
            result = Math.max(result, j - i + 1);
            // update last index of j
            lastIndex[s.charAt(j)] = j;
        }
        return result;
    }
    /**
     * Alternate implementation
     */
    static int lengthOfLongestSubstring3(String s) {
        // Create a map to store the last positions of occurrence
        HashMap<Character, Integer> seen = new HashMap<>();
        int max_len = 0;
        //start the initial point of window to index 0
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            // checking if we have already seen the element or not
            if (seen.containsKey(s.charAt(end))) {
                // if we have seen the number, move the start pointer to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }
            // update the last seen value of the character
            seen.put(s.charAt(end), end);
            max_len = Math.max(max_len, end - start + 1);
        }
        return max_len;
    }
    static int lengthOfLongestSubstring4(String s) {
        if (s.length() == 0)
            return 0;
        char[] ch = s.toCharArray();
        int max = 1;
        int subLen = 1;
        for (int i = 1; i < ch.length; i++) {
            for (int j = i - subLen; j < i; j++) {
                if (ch[j] == ch[i]) {
                    subLen = i - j - 1;
                    break;
                }
            }
            subLen++;
            if (subLen > max)
                max = subLen;
        }
        return max;
    }
    static String getUniqueCharacterSubstring(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(s.charAt(end)), start);
            }
            if (output.length() < end - start + 1) {
                output = s.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        System.out.println("Output: "+output);
        return output;
    }
}
