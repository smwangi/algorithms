/**
 * Reverse Words in String
 * Write a function that takes in a String of words separated by one or more whitespaces and returns a string that has these words
 * in reverse order. Example: "tim is great" you should return "great is tim"
 *
 * The words can contain special characters, punctuation, and numbers. The words in the string will be separated by one or more
 * whitespaces, and the reversed string must contain the same whitespaces as the original string.
 * Example: given the string "whitespaces    4" should return "4    whitespaces"
 */
public class ReverseWordInString {
    public static void main(String[] args) {
        String s = "whitespaces    4";
        System.out.println(reverseWordsInString(s));
    }
    static String reverseWordsInString(String string) {
        char[] chars = string.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int startOfWord = 0;
        while (startOfWord < chars.length) {
            int endOfWord = startOfWord;
            while (endOfWord < chars.length && chars[endOfWord] != ' ') {
                endOfWord += 1;
            }
            reverse(chars, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }
        return String.valueOf(chars);
    }
    static char[] reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        
        return chars;
    }
}
