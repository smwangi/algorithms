package codes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just character at index in the string, and the remaining characters will occur the same number of times. Given a string
 *
 * , determine if it is valid. If so, return YES, otherwise return NO.
 *
 * For example, if
 * , it is a valid string because frequencies are . So is because we can remove one and have of each character in the remaining string. If however, the string is not valid as we can only remove occurrence of . That would leave character frequencies of
 *
 * .
 *
 * Function Description
 *
 * Complete the isValid function in the editor below. It should return either the string YES or the string NO.
 *
 * isValid has the following parameter(s):
 *
 *     s: a string
 *
 * Input Format
 *
 * A single string
 *
 * .
 *
 * Constraints
 *
 * Each character
 *
 * Output Format
 *
 * Print YES if string
 *
 * is valid, otherwise, print NO.
 *
 * Sample Input 0
 *
 * aabbcd
 *
 * Sample Output 0
 *
 * NO
 *
 * Explanation 0
 *
 * Given
 * , we would need to remove two characters, both c and d aabb or a and b abcd, to make it valid. We are limited to removing only one character, so
 *
 * is invalid.
 *
 * Sample Input 1
 *
 * aabbccddeefghi
 *
 * Sample Output 1
 *
 * NO
 *
 * Explanation 1
 *
 * Frequency counts for the letters are as follows:
 *
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * There are two ways to make the valid string:
 *
 *     Remove 4 characters with a frequency 1: {fghi}
 *     Remove 5 characters of frequency 2: {abcde}
 *
 * Neither of these is an option.
 *
 * Sample Input 2
 *
 * abcdefghhgfedecba
 *
 * Sample Output 2
 *
 * YES
 *
 * Explanation 2
 *
 * All characters occur twice except for
 * which occurs times. We can delete one instance of
 *
 * to have a valid string.
 */
public class SherlockandValidString {

    public static void main(String[] args) {
        String s = "aabbccdd";

        System.out.println(isValid(s));
    }

    static String isValid(String s) {

        String result = "YES";
        int del_count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int current = 0;
        for (Map.Entry entry : map.entrySet()){
            int temp = (int)entry.getValue();
            if(current == 0){
                current = temp;
            }
            else {
                int diff = Math.abs(current - temp);
                if((int)entry.getValue() > 1 && diff > 0){
                    del_count +=diff;
                }else if((int)entry.getValue() == 1 && diff > 0) {
                    del_count++;
                }
            }
        }
        if(del_count > 1)result = "NO";
        return result;
    }
}
