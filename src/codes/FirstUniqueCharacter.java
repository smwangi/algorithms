package codes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";
       System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){

            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        map.forEach((x,y) -> System.out.println(x+":"+y));

        for(int i = 0; i < s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
