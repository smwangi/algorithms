import java.util.List;

/**
 * Input:  technique, technician, technology, technical
 * Output: The longest common prefix is techn
 *
 *
 * Input:  techie delight, tech, techie, technology, technical
 * Output: The longest common prefix is tech
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"geeksforgeeks", "geeks", "geek", "geezer"};//{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        int n = strs.length;
        System.out.println(commonPrefix(strs, 0, n - 1));
    }
    
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    // A Divide and Conquer based function to find the
    // longest common prefix. This is similar to the
    // merge sort technique
    static String commonPrefix(String[] arr, int low, int high) {
        if (low == high)
            return arr[low];
        if (high > low) {
            // Same as (low + high)/2, but avoids overflow for
            // large low and high
            int mid = low + (high - low) / 2;
            String s1 = commonPrefix(arr, low, mid);
            String s2 = commonPrefix(arr, mid + 1, high);
            return commonPrefixUtil(s1, s2);
        }
        return null;
    }
    // A Utility Function to find the common prefix between
    // strings- str1 and str2
    static String commonPrefixUtil(String s1, String s2) {
        String result = "";
        int n1 = s1.length(), n2 = s2.length();
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (s1.charAt(i) != s2.charAt(j))
                break;
            result += s1.charAt(i);
        }
        return result;
    }
    /**
     * A simple solution is to consider each string and calculate its longest common prefix with the most common
     * prefix of strings processed so far. The time complexity of this solution is O(N.M), where N is the total number
     * of words and M is the maximum length of a word.
     */
    static String LCPStr(String x, String y) {
        int i = 0, j = 0;
        while (i < x.length() && j < y.length()) {
            if (x.charAt(i) != y.charAt(j)) {
                break;
            }
            i++; j++;
        }
        return x.substring(0, i);
    }
    static String findLCPStr(List<String> words) {
        String prefix = words.get(0);
        for (String word : words) {
            prefix = LCPStr(prefix, word);
        }
        return prefix;
    }
    /**
     * We can also use the Divide and Conquer technique for finding the longest common prefix (LCP). Like all divide-and-conquer
     * algorithms, the idea is to divide the string into two smaller set and then recursively process those sets.
     * This is similar to merge sort routine, except we find the LCP of the two halves instead of merging both halves.
     */
    static String LCPDivCon(String x, String y) {
        int i = 0, j = 0;
        while (i < x.length() && j < y.length()) {
            if (x.charAt(i) != y.charAt(j)) {
                break;
            }
            i++; j++;
        }
        return x.substring(0, i);
    }
    
    /**
     *
     * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence
     * (i.e. subarray).
     * The subsequence must be strictly increasing.
     *
     * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l],
     * nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,4,7]
     * Output: 3
     * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
     * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
     * 4.
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2]
     * Output: 1
     * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
     * increasing.
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i])
                anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
    
    int findLengthOfLCIS2(int[] nums) {
        int count = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i -1]){
                count++;
            }else{
                count = 1;
            }
            max = Math.max(max,count);
        }
        return max;
    }
    
    // Function to find the longest common prefix between two strings
    public static String LCP(String X, String Y)
    {
        int i = 0, j = 0;
        while (i < X.length() && j < Y.length())
        {
            if (X.charAt(i) != Y.charAt(j)) {
                break;
            }
            i++; j++;
        }
        
        return X.substring(0, i);
    }
    
    // Function to find the longest common prefix (LCP) between a given set of strings
    public static String findLCP(List<String> words)
    {
        String prefix = words.get(0);
        for (String s: words) {
            prefix = LCP(prefix, s);
        }
        return prefix;
    }
}
