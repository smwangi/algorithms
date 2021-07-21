/**
 * Write a method to  replace all spaces in a string with '%20'.
 * You may assume the string has sufficient space at the end to hold the additional
 * characters, and that you're given the "true" length of the string.
 */
public class URLify {
    public static void main(String[] args) {
        String s = "Mr John Smith     ";
        int trueLength = findLastCharacter(s.toCharArray()) + 1;
        replaceSpaces(s.toCharArray(), trueLength);
    }
    /**
     * Soln
     * Create character array from the string.
     * Count the number of white spaces, since we will replace with %20, double the count of the spaces
     * Walk backwards replacing the spaces with %20
     */
    static void replaceSpaces(char[] chars, int trueLength) {
        /*int numberOfSpaces = countChar(chars, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;
        // If there are excess spaces, and a null character, This indicates that the
        // spaces after that point have not been replaced with '%20'
        if (newIndex + 1 < chars.length) {
            chars[newIndex + 1] = '\0';
        }
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -=1) {
            if (chars[oldIndex] == ' ') {
                // insert %20
                chars[newIndex] = '0';
                chars[newIndex - 1] = '2';
                chars[newIndex - 2] = '%';
                newIndex -=3;
            } else {
                chars[newIndex] = chars[oldIndex];
                newIndex -= 1;
            }
        }*/
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        for (i = trueLength - 1; i >=0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index = index - 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }
        System.out.println(String.valueOf(chars));
    }
    /**
     * Count occurrences of target between start (inclusive) and end (exclusive).
     */
    static int countChar(char[]chars, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (chars[i] == target)
                count++;
        }
        return count;
    }
    
    static int findLastCharacter(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
