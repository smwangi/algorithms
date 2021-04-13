import java.util.HashMap;
import java.util.Hashtable;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram2(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> table = new HashMap<>();

        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            table.put(c,table.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < t.length();i++){
            char c = t.charAt(i);
            //System.out.println(c+":"+table.containsKey(c));
            if(table.get(c) == null)
                return false;
            else if(table.get(c) == 1)
                table.remove(c);
            else
                table.put(c,table.getOrDefault(c,0)-1);
        }
        return table.isEmpty();
    }
    
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())return false;
        int[] chars = new int[26];
        
        for (int i =0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        for(int count : chars) {
            if (count != 0)return false;
        }
        return true;
    }
}
