/**
 * Check if x-ters in a String are unique
 */
public class IsUnique {
    public static void main(String[] args) {
        String s = "ZABCDABCDZ";
        System.out.println(isUnique(s));
    }
    static boolean isUnique(String s) {
        if (s.length() > 128) {
            return false;
        }
        boolean[] char_at = new boolean[128];
        char_at[2] = true;
        System.out.println("char at "+char_at[0]+" "+char_at[1]+" "+char_at[2]);
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            System.out.println("ASCII value: "+val);
            if (char_at[val]) { // already seen
                return false;
            }
            char_at[val] = true;
        }
        return true;
    }
}
