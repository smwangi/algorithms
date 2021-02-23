import java.util.Arrays;

public class StrReverse {

    public static void main(String[] args) {
        String s = "James is working here";
        reverse(s);
        reverseStr(s);
    }
    static String reverse(String s){
        if(s == null || s.isEmpty())return "";
        char[] chars = s.toCharArray();
        int i = 0, j = s.length()-1;
        while (i <= j){
            swap(chars,i,j);
            i++;
            j--;
        }
        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);
    }
    static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    static String reverseStr(String s){
        char[]chars = s.toCharArray();
        int left = 0,right = s.length()-1;

        while (left <= right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);
    }
}
