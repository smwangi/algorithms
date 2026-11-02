import java.util.HashSet;
import java.util.Set;

/**
 * Given a string and a positive number k, find the longest substring of the string containing k distinct
 * characters. if k is more than the total number of distinct characters in the string, return the whole string.
 *
 * NB the problem differs from the problem of finding the longest subsequence with k distinct characters. Unlike subsequences,
 * substrings are required to occupy consecutive positions within the original string.
 * For example, consider string abcbdbdbbdcdabd
 * For k = 2, o/p is ‘bdbdbbd’
 * For k = 3, o/p is ‘bcbdbdbbdcd’
 * For k = 5, o/p is ‘abcbdbdbbdcdabd’
 *
 * We can easily solve this problem in O(n) time and O(n) space. The idea is to use a sliding window technique. In the sliding window technique,
 * a window is maintained that satisfies the problem constraints. The window is unstable if it violates the problem constraints and it tries to
 * stabilize by increasing or decreasing its size.
 *
 * The window (substring) is stable for the current problem if it contains k distinct characters at any point. If the window has less than k distinct characters,
 * it expands by adding characters to it from the right; otherwise, if the window contains more than k distinct characters, it shrinks by removing characters from the left
 * until it becomes stable again. The steady-state window tends to increase its size by adding characters to it until it becomes unstable again. We continue this process
 * until the window reaches the last character in the string. At each point, the window size changes, update the maximum window size.
 */
public class LongestSubStrKDistinctChars {
    //Define the character range
    public static final int CHAR_RANGE = 128;
    
    public static void main(String[] args) {
        String str = "abcbdbdbbdcdabd";
        int k = 2;
    
        System.out.print(findLongestSubstring(str, k));
    }
    static String findLongestSubstring(String str, int k) {
        //stores the longest substring boundaries
        int end = 0, begin = 0;
        //set to store distinct characters in a window
        Set<Character> window  = new HashSet<>();
        //  Count array `freq` stores the frequency of characters present in the current window. We can also use a map instead of a count array.
        int[] freq = new int[CHAR_RANGE];
        //[low...high] maintains the sliding window boundaries
        for (int low = 0,  high = 0; high < str.length(); high++) {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;
            // if the windo size is more than `k`, remove characters from the left
            while (window.size() > k) {
                // if left most character's frequency becomes 0 after removing it from the window, remove it from the set as well
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }
                low++; //reduce the window size
            }
            // update the maximum window size if necessary
            if (end - begin < high - low) {
                end = high;
                begin = low;
            }
        }
        //return the longest substring found at `str[begin...end]`
        return str.substring(begin, end + 1);
    }
}
