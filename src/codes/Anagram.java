import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Anagram
 * To examine if t is a rearrangement of s, we can count occurrences of each letter in the two strings and compare them. 
 * Since both s and t contain only letters from a−z, a simple counter table of size 26 is suffice.
 * 
 * Do we need two counter tables for comparison? Actually no, because we could increment
 * the counter for each letter in s and decrement
 * the counter for each letter in t, then check if the counter reaches back to zero.
 *
 * A simple solution would to sort given string. If the strings become equal after sorting, they are anagrams. The time
 * complexity of this solution is O(n.log(n)), where n is the length of the input string
 */
public class Anagram {

    public static void main(String[] args) throws IOException {

        isAnagram("abcd", "dcab");

        String s = "cbaebabacd",p="abc";
        String home = System.getProperty("user.home");
        Path path = Paths.get(home);
        BasicFileAttributeView basicFileAttributes = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes fileAttributes = basicFileAttributes.readAttributes();
        System.out.println(fileAttributes.creationTime());
        System.out.println(Files.isExecutable(path));
        System.out.println(System.getProperty("user.home"));
        //findAnagrams(s,p).forEach(System.out::println);
        String X = "tommarvoloriddle";        // Tom Marvolo Riddle
        String Y = "iamlordvoldemort";        // I am Lord Voldemort
    
        if (isAnagram4(X, Y)) {
            System.out.print("Anagram");
        }
        else {
            System.out.print("Not an Anagram");
        }

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
            if (char_counts[s.charAt(right++)]-- >= 1)
                count--;
            if (count == 0) result.add(left);
            if (right-left == p.length() && char_counts[s.charAt(left++)]++ >= 0)
                count++;
        }

        return result;
    }
    
    public static boolean isAnagram3(String word, String anagram) {
        if (word.length() != anagram.length())
            return false;
        
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1);
            } else {
                return false;
            }
        }
        return anagram.isEmpty();
    }
    
    public static boolean checkAnagram(String first, String second) {
        char[] chars = first.toCharArray();
        StringBuilder sb = new StringBuilder(second);
        for (char c : chars) {
            int index = second.indexOf("" + c);
            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return sb.length() == 0 ? true : false;
    }
    /**
     * We can also solve this problem in O(n) time. The idea is to maintain the frequency of each character of the first
     * string in a map or a count array. Then for each character of the second string, decrement its frequency and return
     * false if the frequency becomes negative of the character is not present on the map
     */
    static boolean isAnagram4(String x, String y) {
        if (x.length() != y.length())
            return false;
        // Create an empty map
        Map<Character, Integer> freq = new HashMap<>();
        // Maintain a count of each character of `X` on the map
        for (char c : x.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        // do for each character `y` of `Y`
        for (char c : y.toCharArray()) {
            // if `y` is not found in the map, i.e., either `y` is not present
            // in string `X` or has more occurrences in string `Y`
            if (!freq.containsKey(c))
                return false;
            // Decrease freq
            freq.put(c, freq.get(c) - 1);
            // if frequency becomes 0, erase it from the map
            if (freq.get(c) == 0)
                freq.remove(c);
        }
        return freq.isEmpty();
    }
    
    /**
     * Create two maps and store the frequency of each character of the first and second string in them.
     * Then check if both maps are equal or not. If both are found to be equal, then both strings are anagrams.
     * @param X
     * @param Y
     * @return
     */
    // Function to check if `X` and `Y` are anagrams or not
    public static boolean isAnagram5(String X, String Y)
    {
        // if X's length is not the same as Y's, they can't be an anagram
        if (X.length() != Y.length()) {
            return false;
        }
        
        // create an empty map
        Map<Character, Integer> freqX = new HashMap<>();
        
        // maintain a count of each character of `X` on the map
        for (char c: X.toCharArray()) {
            freqX.put(c, freqX.getOrDefault(c, 0) + 1);
        }
        
        // create a second map
        Map<Character, Integer> freqY = new HashMap<>();
        
        // maintain a count of each character of `Y` on the map
        for (char c: Y.toCharArray()) {
            freqY.put(c, freqY.getOrDefault(c, 0) + 1);
        }
        
        // return true if both maps have the same content
        return freqX.equals(freqY);
    }
} 