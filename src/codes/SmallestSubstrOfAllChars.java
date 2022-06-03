import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique characters arr and a string str,
 * Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr.
 * Return "" (empty string) if such a substring doesn’t exist.
 *
 * Come up with an asymptotically optimal solution and analyze the time and space complexities.
 *
 * Example:
 *
 * input:  arr = ['x','y','z'], str = "xyyzyzyx"
 *
 * output: "zyx"
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.character arr
 *
 * 1 ≤ arr.length ≤ 30
 * [input] string str
 *
 * 1 ≤ str.length ≤ 500
 * [output] string
 */
public class SmallestSubstrOfAllChars {
    public static void main(String[] args) {
        char[] arr = {'x','y','z'};
        String str = "xyyzyzyx";
        System.out.println(getShortestUniqueSubstring(arr, str));
    }
    
    static String getShortestUniqueSubstring(char[] arr, String str) {
        int start = 0;
        int end = 0;
        int uniqueCounter = 0;
        int patLen = arr.length;
        String result = "";
        char headChar;
        
        Map<Character, Integer> countMap = new HashMap<>();
        // initialize count map
        for (char c : arr) {
            countMap.put(c, 0);
        }
        
        for (int j = start; j < str.length(); j++) {
            char c = str.charAt(j);
            //skip all characters not in the arr
            if (!countMap.containsKey(c))
                continue;
            
            int tailCount = countMap.get(c);
            
            if (tailCount == 0) {
                uniqueCounter +=1;
            }
            countMap.put(c, countMap.get(c) +1);
            
            //push head forward to make the length small
            while (uniqueCounter == patLen) {
                int tempLength = j - start + 1;
                if (tempLength == patLen) {
                    //return a substring of str from index to tailIndex (inclusive)
                    return str.substring(start, j + 1);
                }
                //if current length is smaller  update the result
                if (result == "" || tempLength < result.length()) {
                    result = str.substring(start, j + 1);
                }
                // try to make the string smaller from beginning
                headChar = str.charAt(start);
                
                if (countMap.containsKey(headChar)) {
                    int headCount = countMap.get(headChar) - 1;
                    //after removing first character cound should be reduced to zero
                    if (headCount == 0)
                        uniqueCounter -= 1;
                    
                    countMap.put(headChar, headCount);
                }
                start += 1;
            }
        }
        return result;
    }
}
