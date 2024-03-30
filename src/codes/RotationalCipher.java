/**
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 * Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
 * Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
 * and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
 * Note that the non-alphanumeric characters remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 *
 * Signature
 * string rotationalCipher(string input, int rotationFactor)
 *
 * Input
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 *
 * Output
 * Return the result of rotating input a number of times equal to rotationFactor.
 *
 * Example 1
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 *
 * Example 2
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {
    public static void main(String[] args) {
        String str = "abcdZXYzxy-999.@";
        int factor = 200;
        System.out.println(rotationalCipher(str, factor));
    }
    static String rotationalCipher(String str, int factor) {
    
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        //if rotational factor is greater than 25
        /*int rotationalFactor = factor > 26 ? factor % 26 : factor;
        System.out.println(rotationalFactor);
        
        
        for (int i = 0; i < chars.length; i++) {
            char c = (char) (chars[i] + rotationalFactor);
            if ((Character.isUpperCase(chars[i]) && c > 'Z') || (Character.isLowerCase(chars[i]) && c > 'z')) {
                c = (char) (str.charAt(i) - (26 - rotationalFactor));
                sb.append(c);
            } else if (Character.isDigit(chars[i])) {
                char newChar = c;
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }*/
        for (char c : chars) {
            if (Character.isDigit(c)) {
                int i = c - '0';
                int f = (i + factor) % 10;
                sb.append(f);
            } else if (Character.isUpperCase(c)) {
                char c1 = (char) (((c - 'A') + factor) % 26);
                sb.append((char) ('A' + c1));
            } else if (Character.isLowerCase(c)) {
                char c2 = (char) (((c - 'a') + factor) % 26);
                sb.append((char) ('a' + c2));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}
