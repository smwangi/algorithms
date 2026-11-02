
import java.util.*;
import java.util.stream.Collectors;

/**
 *  Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it.
 *  If there is no such character, return '_'.
 *
 * Example
 *
 *     For s = "abacabad", the output should be
 *     firstNotRepeatingCharacter(s) = 'c'.
 *
 *     There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
 *
 *     For s = "abacabaabacaba", the output should be
 *     firstNotRepeatingCharacter(s) = '_'.
 *
 *     There are no characters in this string that do not repeat.
 *
 * Input/Output
 *
 *     [execution time limit] 3 seconds (java)
 *
 *     [input] string s
 *
 *     A string that contains only lowercase English letters.
 *
 *     Guaranteed constraints:
 *     1 ≤ s.length ≤ 105.
 *
 *     [output] char
 *         The first non-repeating character in s, or '_' if there are no characters that do not repeat.
 *
 * [Java] Syntax Tips
 *
 * // Prints help message to the console
 * // Returns a string
 * //
 * // Globals declared here will cause a compilation error,
 * // declare variables inside the function instead!
 * String helloWorld(String name) {
 *     System.out.println("This prints to the console when you Run Tests");
 *     return "Hello, " + name;
 * }
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        FirstNonRepeatingChar firstNonRepeatingChar  = new FirstNonRepeatingChar();
        String s = "abacabad";//""abacabaabacaba";
       System.out.println( firstNonRepeatingChar.firstNonRepeating(s));
       System.out.println(firstNonRepeatingChar.firstNon(s));
       System.out.println(firstNonRepeatingIntArr(s));
       System.out.println(firstNonRepeatingCharacter("abcdcaf"));
        System.out.println(firstNonRepeatingCharacter2("abcdcaf"));
    }

    char firstNonRepeating(String s) {
        char nonRepeating = '_';
        List<Character> ls = s.chars().mapToObj(c-> (char)c).collect(Collectors.toList());

        for(int i =0; i < s.length(); i++) {

            int pos = i;
            if(ls.stream().filter(x -> x == s.charAt(pos)).count() > 1){
                continue;
            }
            else {
                nonRepeating = s.charAt(i);
                break;
            }
        }

        return nonRepeating;
    }

    char firstNon(String s) {
       char nonRepeating = '_';
       Map<Character,Integer> map = new HashMap<>();

       for(int i =0; i< s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
       }

       for(int i =0;i< s.length();i++) {
          if(map.get(s.charAt(i)) == 1)
              return s.charAt(i);
        }

      return nonRepeating;
    }

    static char firstNonRepeatingIntArr(String s) {
        int[] chars = new int[26];

        for(char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for(char c : s.toCharArray()) {
            if(chars[c - 'a'] == 1)return c;
        }
        return '_';
    }
    /**
     * A function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non-repeating
     * character.
     * The first non-repeating character is the first character in a string that occurs only once
     * If the input string doesn't have any non-repeating characters, your function should return -1
     */
    static int firstNonRepeatingCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean foundDuplicate = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j)
                    foundDuplicate = true;
            }
            if (!foundDuplicate)
                return i;
        }
        return -1;
    }
    static int firstNonRepeatingCharacter2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        
        for (int j = 0; j < str.length(); j++) {
            if (map.get(str.charAt(j)) == 1)
                return j;
        }
        return -1;
    }
}
