import java.util.*;

/**
 * Anagram
 * To examine if t is a rearrangement of s, we can count occurrences of each letter in the two strings and compare them. 
 * Since both s and t contain only letters from a−z, a simple counter table of size 26 is suffice.
 * 
 * Do we need two counter tables for comparison? Actually no, because we could increment the counter for each letter in s and decrement 
 * the counter for each letter in t, then check if the counter reaches back to zero.
 */
public class Anagram {

    public static void main(String[] args) {
        isAnagram("abcd", "dcab");
    }

    static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for(int i=0; i<s.length();i++){
            //System.out.println(counter[s.charAt(i)-'a']++);
            //System.out.println(counter[t.charAt(i)-'a']++);
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
       // System.out.println(Arrays.toString(counter));
        for(int count: counter){
         //   System.out.print(count+" ");
            if(count != 0)
                return false;
        }
        
        return true;
    }
} 