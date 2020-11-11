import java.util.ArrayList;
import java.util.List;

/**
 * Anagram
 * To examine if t is a rearrangement of s, we can count occurrences of each letter in the two strings and compare them. 
 * Since both s and t contain only letters from a−z, a simple counter table of size 26 is suffice.
 * 
 * Do we need two counter tables for comparison? Actually no, because we could increment
 * the counter for each letter in s and decrement
 * the counter for each letter in t, then check if the counter reaches back to zero.
 */
public class Anagram {

    public static void main(String[] args) {

        isAnagram("abcd", "dcab");

        String s = "cbaebabacd",p="abc";

        findAnagrams(s,p).forEach(System.out::println);

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

    static boolean isAnagram2(String s1, String s2){
        return  false;
    }

    public static List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();

        if(s.length() == 0 || s==null)return result;

        int[] char_counts = new int[26];
        for(char c : p.toCharArray()){
            char_counts[c-'a']++;
        }
    //Sliding window approach
        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()){
            if(char_counts[s.charAt(right++)]-- >= 1)count--;
            if(count == 0) result.add(left);
            if(right-left == p.length() && char_counts[s.charAt(left++)]++ >= 0)count++;
        }

        return result;
    }
} 