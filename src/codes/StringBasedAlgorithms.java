package codes;

import java.util.*;

public class StringBasedAlgorithms {

    public static void main(String[] args) {

        String s = "Programming";
        printDuplicate(s);
        countDuplicateCharacters(s);
       System.out.println(isAnagram("army","mary"));
       reverseString(s);
       String per = "ABC";
       permutation(per.length(),per.toCharArray());
       permutation("",per);
       System.out.println("Palindrome: "+isPalindrome("radar"));
    }

    /**
     * How to Print duplicate characters from String?
     */
    private static void printDuplicate(String s){

        Set<Character> duplicate = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            if(duplicate.contains(s.charAt(i)))
                System.out.print(s.charAt(i)+" ");
            else
                duplicate.add(s.charAt(i));
        }
        System.out.println();
    }
    private static void countDuplicateCharacters(String s){
        Map<Character,Integer> duplicates = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(duplicates.containsKey(s.charAt(i))){
                int val = duplicates.get(s.charAt(i));
                duplicates.replace(s.charAt(i),++val);
            }
            else
                duplicates.put(s.charAt(i),1);
        }

        duplicates.forEach((x,y) -> {
            if(y.intValue() > 1)
                System.out.println(x.charValue()+" : "+y.intValue());
        });
    }
    /**
     * Anagrams
     * A simple coding problem based upon String, but could also be asked with numbers.
     * You need to write a Java program to check if two given strings are anagrams of Each other.
     * Two strings are anagrams if they are written using the same exact letters, ignoring space, punctuation, and capitalization.
     * Each letter should have the same count in both strings. For example, the Army and Mary are an anagram of each other.
     *
     */

    private static boolean isAnagram(String s,String p){
        boolean anagram = false;
        s = s.toLowerCase();
        p = p.toLowerCase();
        int[] counter = new int[26];
        for(int i = 0; i< s.length(); i++) {
            //ASCII values minus ASCII values
            //Example a-a = 0 => index 0, b-a = 1;meaning index 1, c-a => index 2, then increment the frequency ++
            counter[s.charAt(i) - 'a']++;
            counter[p.charAt(i) - 'a']--;
        }
       for(int count : counter)
        if(count != 0)
            return false;

        return true;
    }

    private static void reverseString(String s){
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = s.length()-1;i >=0;i--)
            sb.append(s.charAt(i));

        System.out.println(sb.toString());
    }

    private static void permutation(int n,char[] s){

        if(n == 1){
            System.out.println(s);
        }else {
            for (int i = 0; i < n - 1; i++) {
                permutation(n-1,s);
                if(n % 2 == 0)
                    swap(s,i,n-1);
                else
                   swap(s,0,n-1);
            }
            permutation(n-1,s);
        }
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void permutation(String perm,String word){

        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }

    private static boolean isPalindrome(String s){
        String reversed = reverseStr(s);
        System.out.println(reversed);
        if(reversed.equals(s))
            return true;
        return false;
    }
    private static String reverseStr(String s){

        if(s == null || s.isEmpty())
            return s;
        System.out.println(s);
        return s.charAt(s.length()-1)+ reverseStr(s.substring(0,s.length()-1));
    }
}
