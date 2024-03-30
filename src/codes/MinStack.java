import java.util.Stack;

/**
 * Min Stack
 * Aim
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) — Push element x onto stack.
 *     pop() — Removes the element on top of the stack.
 *     top() — Get the top element.
 *     getMin() — Retrieve the minimum element in the stack.
 *
 *     Aim
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) — Push element x onto stack.
 *     pop() — Removes the element on top of the stack.
 *     top() — Get the top element.
 *     getMin() — Retrieve the minimum element in the stack.
 *
 * Algorithm👨‍🎓
 *
 *     For a normal Stack there are three functions: push(), pop(), peek().
 *     If we have to introduce another function called min(). It has to return the minimum element that is present in the stack at any period of time.
 *     What we are going to do is. Initialize a min variable whose scope is global. So that the functions in the stack can access it at any period of time.
 *     Push Operation(): Introduce an if condition.
 *     If the value of the current pushed element is less than the minimum present in the stack.
 *     Push the existing minimum element into the stack. Make the current element as the minimum element Followed by another push which will enter the current element.
 *     This is done in order to make the minimum element be always present as the last element in the stack and second last element to be the second last minimum, so on.
 *     If we insert twice for push operation. What should you do for the pop Operation?
 *     You guessed it right. We will have to pop twice if it is a minimum element.
 *     Change the second last element to be the minimum element. Since you are removing the minimum element.
 *     When we call min function.
 *     Return the min global Variable
 *
 *
 *
 * Using Constant Space
 *
 * In this approach instead of using an array and increasing the space complexity, we will rather use a variable minElement which will store the current minimum element of the stack at every point.
 *
 * Have you thought about the above given critical idea? Hmm, the problem is when we have to pop this minElement from the stack. How will we update the minElem then?
 *
 * To solve this issue, we will use a very different idea. The idea is to whenever we will encounter an element smaller than minElement instead of pushing the ‘elem’ to the stack and updating minElement, we will instead push (2*elem - minElement) to the stack and update minElement with ‘elem’.
 *
 * During the pop operation, if we encounter any element smaller than minElement, we will know it is the same altered element that we pushed and it’s time to modify our minElement. We will return the minElement and update our minElement with (2*minElement - top Element). Too many maths involved here. Let's move on to the solution steps.
 *
 * Solution steps
 *
 *     We will modify our push operation such that it simply pushes the element and update minElement if the stack is empty. Otherwise, it will compare the ‘elem’ with the minElement. If smaller, we will push (2*elem-minElement) instead to the stack and update minElement with ‘elem’.
 *     Similarly, we will modify our pop operation so that whenever we will encounter that that top element to be deleted is less than minElement, we will update our minElement with (2*minElement-top element).
 *     For top operation, we will check if the last inserted element of the stack is smaller than minElement. If yes, we will return minElement. Else we will return the last element pushed into the stack. (Think why?)
 *     For getMin operation, we will simply return the value of minElement.
 *
 * Illustration for this solution
 *
 * We will take the above approach and will insert 2, 4, -1 into the stack.
 *
 * Insert 2 →stack is empty simply push 2. minElement is 2
 * Insert 4 → 4 > 2, push 4 to stack. minElement is still 2.
 * Insert -1, -1 < 2, push (2*elem — minElement) i.e. -4 to the stack. minElement is -1.
 * Pop top element i.e. -4, it is the time to change our minElement. minElement will be 2*minElement- top Element i.e. 2*-1-(-4) = 2.
 * Wow, that is exactly what we want.
 *
 * Why this approach works?
 *
 * If you have observed, we have taken two assumptions:
 *
 *     (2*elem-minElement) < minElement and,
 *     previous minElement was (2*minElement - y) which was used to make new minElement after deleting y, where y is the smaller number than current minElement that is to be deleted(pop operation).
 *
 * Let us try to prove this using mathematics:
 *
 * Proving our point (i)
 *
 * For simplicity let us take elem as e, minElement as m, previous minElement as p
 * e < m which implies e-m < 0
 * //Adding e to both sides
 * 2*e - m < e
 * Thus, we can conclude:
 * 2*elem - minElement < elem
 *
 * Proving our point (ii)
 *
 * //For simplicity let us take elem as e, minElement as m, previous minElement as p and n for new minElement
 * We know y was pushed as 2*e - p when e < current minElement
 * y = 2*e - p
 * // minElement was updated to e
 * m = e
 * n = 2*m - y
 *   = 2*e - (2*e - p)
 *   = p
 * So the new minElement is equal to previous minElement.
 * Hurrah! This is what we wanted.
 */
public class MinStack {
    // Main stack to store elements
    private static Stack<Integer> s = new Stack<>();
    // variable to store the minimum element
    private int min;
    
    private Stack<Integer> mStack = new Stack<Integer>();
    private Stack<Integer> mMinStack = new Stack<Integer>();
    
    public static void main(String[] args) {
        MinStack s = new MinStack();
    
        s.push(6);
        System.out.println(s.min());
    
        s.push(7);
        System.out.println(s.min());
    
        s.push(5);
        System.out.println(s.min());
    
        s.push(3);
        System.out.println(s.min());
    
        s.pop();
        System.out.println(s.min());
    
        s.pop();
        System.out.println(s.min());
    }
    // Inserts a given element on top of the stack
    public void push(int x) {
        /*if (s.empty()) {
            s.push(x);
            min = x;
        } else if (x > min) {
            s.push(x);
        } else {
            s.push(2 * x - min);
            min = x;
        }*/
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        /*if(x <= min){
            s.push(min);
            min=x;
        }
        s.push(x);*/
        mStack.push(x);
        if (mMinStack.size() != 0) {
            int min = mMinStack.peek();
            if (x < min)
                mMinStack.push(x);
        } else
            mMinStack.push(x);
    }
    // Removes the top element from the stack and returns it
    public void pop() {
        /*if (s.empty()) {
            System.out.println("Stack underflow!");
        }
        int top = s.peek();
        if (top < min)
            min = 2 * min - top;
        s.pop();*/
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        int x = mStack.pop();
        if (mMinStack.size() != 0) {
            if (x == mMinStack.peek()) {
                mMinStack.pop();
            }
        }
    }
    public int top() {
        return mStack.peek();
    }
    
    // Removes the minimum element from the stack in constant time
    public int min() {
        return mMinStack.peek();
    }
    
    int top =-1;
    int arr[];
    int minStack=-1;
    /** initialize your data structure here. */
    public MinStack() {
        arr = new int[50000];
        top = -1;
    }
    
    public void push2(int val) {
        top++;
        arr[top] = val;
    }
    
    public void pop2() {
        if(top != -1){
            top--;
        }
    }
    
    public int top2() {
        return arr[top];
    }
    
    public int getMin2() {
        int min = arr[0];
        for(int i =1; i<=top;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

private Stack<Integer> s2;       // main stack to store elements
    private Stack<Integer> aux;     // auxiliary stack to store minimum elements
    
    // Constructor
    /*public MinStack()
    {
        s = new Stack<>();
        aux = new Stack<>();
    }*/
    
    // Inserts a given element on top of the stack
    public void push3(int x)
    {
        // push the given element into the main stack
        s2.push(x);
        
        // if the auxiliary stack is empty, push the given element into it
        if (aux.empty()) {
            aux.push(x);
        }
        else {
            // push the given element into the auxiliary stack
            // if it is less than or equal to the current minimum
            if (aux.peek() >= x) {
                aux.push(x);
            }
        }
    }
    
    // Removes the top element from the stack and returns it
    public int pop3()
    {
        if (empty())
        {
            System.out.println("Stack underflow!!");
            return -1;
        }
        
        // remove the top element from the main stack
        int top = s2.pop();
        
        // remove the top element from the auxiliary stack
        // only if it is minimum
        if (top == aux.peek()) {
            aux.pop();
        }
        
        // return the removed element
        return top;
    }
    
    // Returns the top element of the stack
    public int peek() {
        return s2.peek();
    }
    
    // Returns the total number of elements in the stack
    public int size() {
        return s2.size();
    }
    
    // Returns the true if the stack is empty; false otherwise
    public boolean empty() {
        return s2.empty();
    }
    
    // Returns the minimum element from the stack in constant time
    public int min3()
    {
        if (aux.empty())
        {
            System.out.print("Stack underflow!! ");
            return -1;
        }
        
        return aux.peek();
    }
}
