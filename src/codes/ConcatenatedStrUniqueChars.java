import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Maximum Length of a Concatenated String with Unique Characters
 *
 *  Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 * A = [“co”,”dil”,”ity”] , function should return 5, resulting string S could be codil, dilco, coity, ityco
 * A = [“abc”,”kkk”,”def”,”csv”] , returns 6 , resulting Strings S could be abcdef , defabc, defcsv , csvdef
 * A = [“abc”,”ade”,”akl”] , return 0 , impossible to concatenate as letters wont be unique.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class ConcatenatedStrUniqueChars {

    public static void main(String[] args) {
        ConcatenatedStrUniqueChars strUniqueChars = new ConcatenatedStrUniqueChars();
        System.out.println(strUniqueChars.maxLength( Arrays.asList("co","dil","ity")));//"un","iq","ue"
    }

    /**
     * SOLN
     *
     * Initial the result res to include the case of empty string "".
     * res include all possible combinations we find during we iterate the input.
     *
     * Iterate the the input strings,
     * but skip the word that have duplicate characters.
     * The examples is kind of misleading,
     * but the input string can have duplicate characters,
     * no need to consider these strings.
     *
     * For each string,
     * we check if it's conflict with the combination that we found.
     * If they have intersection of characters, we skip it.
     * If not, we append this new combination to result.
     *
     * return the maximum length from all combinations.
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr){
            int a = 0,dup = 0;
            for(char c: s.toCharArray()){
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c-'a');
            }
            if(dup > 0)continue;
            for (int i = dp.size() -1;i >=0; --i){
                if((dp.get(i) & a) > 0)continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res,Integer.bitCount(dp.get(i) | a));
            }
        }

        return res;
    }
}
