
/**
 * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
 *
 * Write a function that, given a sentence like the one above, along with the position of an opening parenthesis,
 * finds the corresponding closing parenthesis.
 *
 * Example: if the example string above is input with the number 10 (position of the first parenthesis),
 * the output should be 79 (position of the last parenthesis).
 *
 * Solution
 * We simply walk through the string, starting at our input opening parenthesis position.
 * As we iterate, we keep a count of how many additional "(" we find as open_nested_parens.
 * When we find a ")" we decrement open_nested_parens. If we find a ")" and open_nested_parens is 0, we know that ")"
 * closes our initial "(", so we return its position.
 *
 * The trick to many "parsing" questions like this is using a stack to track which brackets/phrases/etc are "open" as you go.
 *
 * So next time you get a parsing question, one of your first thoughts should be "use a stack!"
 *
 * In this problem, we can realize our stack would only hold '(' characters.
 * So instead of storing each of those characters in a stack, we can store the number of items our stack would be holding.
 *
 * That gets us from O(n) space to O(1) space.
 *
 * It's pretty cool when you can replace a whole data structure with a single integer :)
 */
public class Parentheticals {

    public static void main(String[] args) {

        String s = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        getClosingParenthesis(s);
    }

    private static int getClosingParenthesis(String s){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count --;
        }
        System.out.println(count);
        return count;
    }
}
