import java.util.Stack;

/**
 * Recursively reverse a stack using only its abstract data type standard operations i.e
 * push(), pop(), peek(), isEmpty(), size()
 *
 * The idea is to hold all items in a call stack until the stack becomes empty. Then, insert each item in the call stack
 * at the bottom of the stack
 *
 * To insert an item x at the bottom of a given stack, pop all items from the stack and hold them in the call stack.
 * When the stack becomes empty, push the given item x into the stack. Then as the recursion unfolds, push each item in the
 * call stack into the stack's top
 */
public class ReverseStackRecursively {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            s.push(i);
        }
    
        reverseStack(s);
    
        System.out.print("Reversed stack is ");
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
    // Recursive function to insert an item at the top of a given stack
    public static void insertAtBottom(Stack<Integer>s, int item) {
        // base case: if the stack is empty, insert the given item at the bottom
        if (s.empty()) {
            s.push(item);
            return;
        }
        // Pop all items from the stack and hold them in the call stack
        int top = s.pop();
        insertAtBottom(s, item);
        // After the recursion unfolds, push each item in the call stack at the top of the stack
        s.push(top);
    }
    //Recursive function to reverse a given stack
    public static void reverseStack(Stack<Integer>s) {
        //base case: stack is empty
        if (s.empty()) {
            return;
        }
        // Pop all items from the stack and hold them in the call stack
        int item = s.pop();
        reverseStack(s);
        //After the recursion unfolds, insert each item in the call stack at the bottom of the stack
        insertAtBottom(s, item);
    }
}
