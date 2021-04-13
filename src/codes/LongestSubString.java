
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        String s = "findlongest";//"abcabcbb";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int max = 0;

        int left = 0;
        int right = 0;
        Set<Character> characters = new LinkedHashSet<>();
        while (right < s.length()){
            if (characters.contains(s.charAt(right))) {
                characters.remove(s.charAt(left++));
            } else {
                characters.add(s.charAt(right++));
                max = Math.max(max, characters.size());
            }

        }
        System.out.println(max);
        for (char c : characters) {
            System.out.print(c+"");
        }
        return max;
    }
    
   
}
