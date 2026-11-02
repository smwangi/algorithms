import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
public class StrRemoveAdjacentDups {
    public static void main(String[] args) {
    
        String s = "abbaca";
        StrRemoveAdjacentDups removeAdjacentDups = new StrRemoveAdjacentDups();
        System.out.println(removeAdjacentDups.removeDuplicates(s));
    }
    /**
     * Problem can be solved using a stack
     *
     * We can put one element into the stack, we check the top of the stack, if it is equal to out current character
     * (adjacent characters are the same), we pop that element and also don't put our current character into the stack. In that way,
     * we can neglect all the adjacent characters.
     *
     */
    
    String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        //abbaca
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if the top of the stack is equal to the current character, we pop that element
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else { //add that character into the stack
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    //Reverse String
    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, r = s.length() - 1;
        
        while (left < r) {
            char temp = chars[left];
            chars[left++] = chars[r];
            chars[r--] = temp;
        }
        return String.valueOf(chars);
    }
}
