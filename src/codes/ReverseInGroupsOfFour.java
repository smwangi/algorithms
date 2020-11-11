import java.util.Arrays;

/**
 * Given a string S of length N, write a Java function that transforms the string by reversing characters in
 * groups of four, and returns the transformed string.
 * e.g. when S = 'Lorem at' the output should be 'eroLta m'
 * when S = ' Tempor ip' the output should be 'meT roppi'
 */
public class ReverseInGroupsOfFour {
    public static void main(String[] args) {
        String s = " Tempor ip";//"Lorem at";
        //samuel is en  => umasi lene s
        int size = 4;
        reverseInGroupOfFour(s,size);
    }

    /**
     * Split the string into substrings of length 4
     * For each substring swap the end character with first character, increment the left index and decrement the right index
     * Store the result of each substring swap in StringBuilder object
     * Once the loop is done, return StringBuilder as a string.
     * @param s
     * @param size
     */
    private static void reverseInGroupOfFour(String s, int size){

        StringBuilder sb = new StringBuilder();

        for(int i =0 ;i< s.length();i +=size){
            char[] chars = s.substring(i,Math.min(s.length(),i +size)).toCharArray();
            int left = 0;
            int right = Math.min(size,chars.length);

            while (left < right){
                swap(chars,left++,--right);
            }
            sb.append(chars);
        }

        System.out.println(sb.toString());
    }

    /**
     * Method to swap character.
     * @param chars
     * @param i
     * @param j
     */
    static void swap(char[] chars,int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

