import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelReverse {

    public static void main(String[] args) {
        VowelReverse reverse = new VowelReverse();
        String s = "leetcode";
        System.out.println(reverse.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        Set<Character> characterSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int l = 0,r = s.length()-1;
        char[] chars = s.toCharArray();
        while (l < r){
            System.out.println(l+" "+r);
            if(!characterSet.contains(s.charAt(l)))
                l++;
            else if(!characterSet.contains(s.charAt(r)))
                r--;
            else{
                swap(chars,l,r);
                System.out.println(s);
                l++;
                r--;
            }

        }
        return new String(chars);
    }

    private static void swap(char[] c,int l, int r){
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
    }
}
