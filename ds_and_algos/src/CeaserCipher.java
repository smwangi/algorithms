/**
 * The Caesar Cipher technique is one of the earliest and simplest method of encryption technique.
 * It’s simply a type of substitution cipher, i.e., each letter of a given text is replaced by a letter some fixed number of positions down the alphabet. For example with a shift of 1, A would be replaced by B, B would become C, and so on.
 * The method is apparently named after Julius Caesar, who apparently used it to communicate with his officials.
 * Thus to cipher a given text we need an integer value, known as shift which indicates the number of position each letter of the text has been moved down.
 * The encryption can be represented using modular arithmetic by first transforming the letters into numbers, according to the scheme, A = 0, B = 1,…, Z = 25. Encryption of a letter by a shift n can be described mathematically as.
 *
 * Text : ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * Shift: 23
 * Cipher: XYZABCDEFGHIJKLMNOPQRSTUVW
 *
 * Text : ATTACKATONCE
 * Shift: 4
 * Cipher: EXXEGOEXSRGI
 *
 * Algorithm for Caesar Cipher:
 * Input:
 *
 *
 * A String of lower case letters, called Text.
 * An Integer between 0-25 denoting the required shift.
 * Procedure:
 *
 *
 * Traverse the given text one character at a time .
 * For each character, transform the given character as per the rule, depending on whether we’re encrypting or decrypting the text.
 * Return the new string generated.
 * Program that receives a Text (string) and Shift value( integer) and returns the encrypted text
 *
 * ABC, 3 -> DEF
 * ABD, -3  -> XYZ
 * A, -1 -> Z
 * A, 52, -> Z
 *
 * @ -> 64
 * 'A' - 65
 * 'B' - 66
 * 'C' - 67
 * 'D' - 68
 * 'Z' - 90
 * '[' - 91
 */
public class CeaserCipher {
    public static void main(String[] args) {
        String text = "xyz";//""ATTACKATONCE";
        String text2 = "ovmqkwtujqmfkao";
        int s = 25;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text2, 52));
        System.out.println(shiftString(text, s));
    }
    //Best Solution
    static StringBuilder encrypt(String text, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int)text.charAt(i) + s - 65 ) % 26 + 65);
                sb.append(ch);
            } else {
                char ch = (char) (((int)text.charAt(i) + s - 97) % 26 + 97);
                sb.append(ch);
            }
        }
        return sb;
    }
    static String shiftString(String s1, int shiftLen) {
        char[] chars = s1.toCharArray();
        shiftLen = shiftLen % 26;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i]))
                continue;
            
            boolean isLower = Character.isLowerCase(chars[i]);
            if (isLower)
                chars[i] = Character.toUpperCase(chars[i]);
            chars[i] = (char) (chars[i] + shiftLen);
            if (chars[i] < 'A') {
                chars[i] = (char) (chars[i] + 26);
            } else if (chars[i] > 'Z') {
                chars[i] = (char) (chars[i] - 26);
            }
            if (isLower) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }
}
