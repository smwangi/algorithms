import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 *
 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
public class MaxSubsequenceChars {

    int result = 0;
    public static void main(String[] args) {
        MaxSubsequenceChars subsequenceChars = new MaxSubsequenceChars();

        System.out.println(subsequenceChars.maxLength(Arrays.asList("un","iq","ue")));
    }
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0)return 0;

        dfs(arr,"",0);
        return result;
    }

    private void dfs(List<String> arr,String path,int idx){
        boolean isUniqueChar = isUniqueChar(path);
        if(isUniqueChar){
            result = Math.max(path.length(),result);
        }

        if(idx == arr.size() || !isUniqueChar)return;

        for(int i = idx; i < arr.size();i++){
            System.out.println("p "+path+" "+arr.get(i));
            dfs(arr,path+arr.get(i),i+1);
        }
    }

    private boolean isUniqueChar(String s){
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if(set.contains(c))return false;
            else set.add(c);
        }
        return true;
    }
}
