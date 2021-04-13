//Check if two strings are a rotation of one another

/**
 *  A String is said to be a rotation of another String, if it has the same length,
 *  contains the same characters, and they were rotated around one of the characters.
 *  For example,  String"bcda" is a rotation of "abcd" but "bdca" is not a rotation of String "abcd".
 *  One of the simplest solutions to this interesting problem is first to check if two String has the same length,
 *  if not then one String cannot be the rotation of another. If they are of the same length then just create another
 *  String by concatenating first String with itself, now check if second String is a substring of this concatenated String or not,
 *  if yes, the second String is a rotation of first.
 *
 *  Let's understand this with an example, Suppose "JavaProgrammer" is first String and "ProgrammerJava" is second String.
 *  You can rotate String around any character starting from index 0, which is 'J' to index=length-1, which is 'r'.
 *
 * Now if you concatenate "JavaProgrammer" with itself, you get "JavaProgrammerJavaProgrammer", now you can see that
 * it contains every possible rotation of first string.
 */
public class StringRotation {

    public static void main(String[] args) {
        String s1= "ABACD";
        String s2 = "CDABA";
        //s1+s1 = ABA'CDABA'CD
        System.out.println(isStrRotated(s1,s2));
        System.out.println(checkRotation(s1, s2));
    }

    static boolean isStrRotated(String s1, String s2){
        //The lengths must be the same and s2 must be a substring of s1 concatenated with s1
        System.out.println((s1+s1).indexOf(s2));
        int N = 5,k=2;
        for(int i = 0; i< N;i++){
            System.out.println((i + k) % N);
        }
       return (s1.length() == s2.length() && (s1 + s1).indexOf(s2) != - 1);

    }
    
    static boolean checkRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenated = s1 + s2;
        System.out.println(concatenated);
        if (concatenated.indexOf(s2) != -1)
            return true;
        return false;
    }
    /**
     * The logic of Solution 2:
     * Here are the steps to check if a given String s2 is the rotation of String s1 without using String concatenation.
     * Check if the length of both strings is the same or not, If not then they are not rotation. If yes, then proceed to the next step.
     * Check if both Strings are equal, if yes then s2 is a rotation of s1. If not, then move to the next step.
     * Take the first string's first character and find the index in the second string. If not found, then it's not the rotation,
     * but if found, proceed to the next step.
     * Subtract the length of the rotated string with the index found to find the final position.
     * Check if the first character of the rotated String is the same as the character at the final position of input String and the
     * input.substring(finalPos) is equal to the rotated.substring(0, index) .
     */
    public static boolean isRotated(String input, String rotated) {
        if (input == null || rotated == null) {
            return false;
        } else if (input.length() != rotated.length()) {
            return false;
        }
        int index = rotated.indexOf(input.charAt(0));
        if (index > - 1) {
            if (input.equalsIgnoreCase(rotated))
                return true;
            
            int finalPos = rotated.length() - index;
            return rotated.charAt(0) == input.charAt(finalPos) && input.substring(finalPos).equals(rotated.substring(0, index));
        }
        return false;
    }
 }
