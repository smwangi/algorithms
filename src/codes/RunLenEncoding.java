/**
 *
 */
public class RunLenEncoding {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(encode(s));
        System.out.println(runLengthEncoding(s));
        rle(s);
    }
    static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int runLength = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                runLength++;
                i++;
            }
            sb.append(runLength);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    static String runLengthEncoding(String s) {
        StringBuilder sb = new StringBuilder();
        int currentRunLength = 1;
       
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char previousChar = s.charAt(i - 1);
        
            if ((currentChar != previousChar) || (currentRunLength == 9)) {
                sb.append(Integer.toString(currentRunLength));
                sb.append(previousChar);
                currentRunLength = 0;
            }
            currentRunLength += 1;
        }
        //Handle the last run
        sb.append(Integer.toString(currentRunLength));
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
    static void rle(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            // Print character and its count;
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }
}
