import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 *
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 *
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *
 *     It contains no unmatched brackets.
 *     The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 *
 * Given
 * strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 *
 * Function Description
 *
 * Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.
 *
 * isBalanced has the following parameter(s):
 *
 *     s: a string of brackets
 *
 * Input Format
 *
 * The first line contains a single integer
 * , the number of strings.
 * Each of the next lines contains a single string
 *
 * , a sequence of brackets.
 *
 * Constraints
 *
 * , where
 *
 *     is the length of the sequence.
 *     All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 *
 * Output Format
 *
 * For each string, return YES or NO.
 *
 * Sample Input
 *
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 *
 * Sample Output
 *
 * YES
 * NO
 * YES
 *
 * Explanation
 *
 *     The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 *     The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
 *     The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        String brackets1 = "{[(])}";
        String brackets3 = "{[()]}";
        String brackets2 = "}][}}(}][))]";
       System.out.println(isBalanced2(brackets3));
    }

    /**
     * Credit Baeldung
     * Deque is a form of the Queue that provides add, retrieve and peek operations at both ends of the queue.
     * We will leverage the Last-In-First-Out (LIFO) order feature of this data structure to check for the balance in the input string.
     *
     * Now that our deque is constructed, we will loop through each character of the input string one by one.
     * If the character is an opening bracket, then we will add it as the first element in the Deque:
     *
     * if (ch == '{' || ch == '[' || ch == '(') {
     * 	    deque.addFirst(ch);
     *        }
     *    First, we check whether the LinkedList is empty or not. An empty list means that the closing bracket is unmatched.
     *    Therefore, the input string is unbalanced. So we return false.
     *
     * However, if the LinkedList is not empty, then we peek on its last-in character using the peekFirst method.
     * If it can be paired with the closing bracket, then we remove this top-most character from the list using the
     * removeFirst method and move on to the next iteration of the loop:
     * @param s
     * @return
     */
    static String isBalanced2(String s){
        Stack<Character> deque = new Stack<>();
        char upperElement = 0;
        for(int i = 0; i < s.length(); i++){
            if (!deque.isEmpty()) {
                upperElement = deque.peek();
            }
            deque.push(s.charAt(i));
            System.out.print(s.charAt(i)+ " ");
            if (!deque.isEmpty() && deque.size() > 1) {
                if (
                        (upperElement == '[' && deque.peek() == ']') ||
                        (upperElement == '{' && deque.peek() == '}') ||
                        (upperElement == '(' && deque.peek() == ')')
                ) {
                    deque.pop();
                    deque.pop();
                }
            }
        }
        return deque.isEmpty() ? "YES":"NO";
    }
}
