
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        String s = "findlongest";//"abcabcbb";
        lengthOfLongestSubstring(s);
        // Given string str
        String str = "HASFJGHOGAKZZFEGA";
    
        // Starting and Ending characters
        char X = 'A', Y = 'Z';
    
        // Function Call
        longestSubString(str, X, Y);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int max = 0;

        int left = 0;
        int right = 0;
        Set<Character> characters = new LinkedHashSet<>();
        while (right < s.length()){
            if (characters.contains(s.charAt(right))) {
                characters.remove(s.charAt(left++));
            } else {
                characters.add(s.charAt(right++));
                max = Math.max(max, characters.size());
            }

        }
        System.out.println(max);
        for (char c : characters) {
            System.out.print(c+"");
        }
        return max;
    }
    /**
     * Longest substring that starts with X and ends with Y
     *
     * Given a string str, two characters X and Y.
     * The task is to find the length of the longest substring that starts with X and ends with Y.
     * It is given that there always exists a substring that starts with X and ends with Y.
     * Examples:
     *
     *
     * Input: str = “QWERTYASDFZXCV”, X = ‘A’, Y = ‘Z’
     * Output: 5
     * Explanation:
     * The largest substring which start with ‘A’ and end with ‘Z’ = “ASDFZ”.
     * Size of the substring = 5.
     * Input: str = “ZABCZ”, X = ‘Z’, Y = ‘Z’
     * Output: 3
     * Explanation:
     * The largest substring which start with ‘Z’ and end with ‘Z’ = “ZABCZ”.
     * Size of the substring = 5.
     *
     * Naive Approach: The naive approach is to find all the substrings of the given string out of these find the largest substring
     * which starts with X and ends with Y.
     * Time Complexity: O(N2)
     * Auxiliary Space: O(1)
     * Efficient Approach: To optimized the above approach, the count of characters between X and Y should be the largest.
     * So, iterate over the string using pointers start and end to find the first occurrence of X
     * from the starting index and the last occurrence of Y from the end. Below are the steps:
     *
     *
     * Initialize start = 0 and end = length of string – 1.
     * Traverse the string from the beginning and find the first occurrence of character X. Let it be at index xPos.
     * Traverse the string from the beginning and find the last occurrence of character Y. Let it be at index yPos.
     * The length of the longest substring is given by (yPos – xPos + 1).
     */
    static void longestSubString(String str, char X, char Y) {
        int N = str.length();
        int start = 0;
        int end = N - 1;
        int xPos = 0;
        int yPos = 0;
        
        // Find the length of the String starting with X from the beginning
        while (true) {
            if (str.charAt(start) == X) {
                xPos = start;
                break;
            }
            start++;
        }
        // Find the length of the string ending with Y from the end
        while (true) {
            if (str.charAt(end) == Y){
                yPos = end;
                break;
            }
            end--;
        }
        // Longest substring
        int length = (yPos - xPos) + 1;
        //Print the length
        System.out.println(length);
    }
}
