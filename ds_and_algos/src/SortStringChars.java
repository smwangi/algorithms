/**
 * Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.
 * Examples:
 *
 *
 * Input : bbccdefbbaa
 * Output : aabbbbccdef
 *
 * Input : geeksforgeeks
 * Output : eeeefggkkorss
 *
 * An efficient approach will be to observe first that there can be a total of 26 unique characters only.
 * So, we can store the count of occurrences of all the characters from ‘a’ to ‘z’ in a hashed array.
 * The first index of the hashed array will represent character ‘a’, second will represent ‘b’ and so on.
 * Finally, we will simply traverse the hashed array and print the characters from ‘a’ to ‘z’ the number of times they occurred in input string.
 */
public class SortStringChars {
    static final int MAX_CHAR = 26;
    
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        sortString(s);
    }
    static void sortString(String str) {
        // Hash array to keep count of characters
        int letters[] = new int[MAX_CHAR];
        //Traverse string and increment count of characters
        for (char x : str.toCharArray()) {
            // 'a'-'a' will be 0, 'b'-'a' will be 1,
            // so for location of character in count
            // array we will do str[i]-'a'.
            letters[x - 'a']++;
        }
        // Traverse the hash array and print characters
        for (int i = 0; i < MAX_CHAR; i++) {
            for (int j = 0; j < letters[i]; j++) {
                System.out.print((char) (i + 'a'));
            }
        }
    }
}
