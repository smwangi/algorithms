package codes;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements,
 * with two principal operations: push, which adds an element to the collection, and pop,
 * which removes the last element that was added.(Wikipedia)
 * A string containing only parentheses is balanced if the following is true:
 * 1. if it is an empty string
 * 2. if A and B are correct, AB is correct,
 * 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 *
 * Given a string, determine if it is balanced or not.
 *
 * Input Format
 *
 * There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.
 *
 * The part of the code that handles input operation is already provided in the editor.
 *
 * Output Format
 *
 * For each case, print 'true' if the string is balanced, 'false' otherwise.
 *
 * Sample Input
 *
 * {}()
 * ({()})
 * {}(
 * []
 * Sample Output
 *
 * true
 * true
 * false
 * true
 */
public class JavaStackBalancedBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            Deque<Character> stack = new LinkedList<>();
            char upperElem = 0;
            String input=sc.next();
            //Complete the code
            char[]arr = input.toCharArray();
            //System.out.println(input);
            //Arrays.toString(arr)
            for(int i = 0; i < input.length(); i++){
                //System.out.println(input.charAt(i));
                if(!stack.isEmpty()){
                    upperElem = stack.peek();
                }
                stack.push(input.charAt(i));
                if(!stack.isEmpty() && stack.size() > 0){
                    System.out.println(upperElem+" "+stack.peek());
                    if(
                            (upperElem == '{' && stack.peek() == '}') ||
                                    (upperElem == '['  && stack.peek() == ']') ||
                                    (upperElem == '(' && stack.peek() == ')')
                    ){

                        stack.pop();
                        stack.pop();
                    }
                }
            }
            System.out.println("size: "+stack.size());
            System.out.println(stack.isEmpty()?"true":"false");
        }
        sc.close();
    }
}
