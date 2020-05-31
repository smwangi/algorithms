package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
    //cbaebabacd
        String s = "abcdecdbacb",p="abc";
        findAnagrams(s,p).forEach(x ->System.out.print(" "+x));
    }

    static List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || s.length() < p.length()  || s == null)
            return result;

        int[] sLen = new int[26];
        int[] pLen = new int[26];
        //Store the number of frequency of character in string p
        //All Starting from 0
        for(char c : p.toCharArray()) {
            //ASCII values minus ASCII values
            //Example a-a = 0 => index 0, b-a = 1;meaning index 1, c-a => index 2, then increment the frequency ++
            sLen[c - 'a']++;
            pLen[c - 'a']++;
        }

        int m = p.length();
        int n = s.length();

        for(int i = m; i < n; i++){
           // System.out.println(i+" "+m+" "+Arrays.toString(sLen));
            if(Arrays.equals(sLen,pLen))
                result.add(i-m);

            //cbaeb
            //System.out.println(Arrays.toString(sLen));
            sLen[s.charAt(i)-'a']++;
            //System.out.println(Arrays.toString(sLen));

            //System.out.println(i+" "+(s.charAt(i)-'a'));
            sLen[s.charAt(i-m)-'a']--;
           // System.out.println(Arrays.toString(sLen));
            //break;
        }
        //Sliding window and Frequency table
        //right is ending boundary


        //.stream(charCounts).forEachOrdered(x -> System.out.print(" "+x));
        /*while (right < s.length()) {
            //Example: charCount[s.charAt(0)-'a']
            //System.out.println(s.charAt(right++));
            if(charCounts[s.charAt(right++)-'a']-- >= 1 ){
                //System.out.print(" "+count);
                count --;

            }
    System.out.println(right-left+" right: "+right+" left: "+left+" count: "+count);

            if(count == 0)
                result.add(left);

            if(right - left == p.length() && charCounts[s.charAt(left++)-'a']++ >= 0)
                count++;

        }*/
        //Consider last window
        if(Arrays.equals(pLen,sLen))
            result.add(n-m);
        return result;
    }
}
