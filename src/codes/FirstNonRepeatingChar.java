package codes;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
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
        String s = "abacabaabacaba";
       System.out.println( firstNonRepeatingChar.firstNonRepeating(s));
       System.out.println(firstNonRepeatingChar.firstNon(s));
    }

    char firstNonRepeating(String s){
        char nonRepeating = '_';
        List<Character> ls = s.chars().mapToObj(c-> (char)c).collect(Collectors.toList());

        for(int i =0; i < s.length(); i++){

            int pos = i;
            if(ls.stream().filter(x -> x == s.charAt(pos)).count() > 1){
                continue;
            }
            else{
                nonRepeating = s.charAt(i);
                break;
            }
        }

        return nonRepeating;
    }
    char firstNon(String s){
       char nonRepeating = '_';
       Map<Character,Integer> map = new HashMap<>();

       for(int i =0;i< s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
       }

        for(int i =0;i< s.length();i++) {
          if(map.get(s.charAt(i)) == 1)
              return s.charAt(i);
        }

      return nonRepeating;
    }
}
