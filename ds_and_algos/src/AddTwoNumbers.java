/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
    
    }
    
    /**
     * Intuition
     * Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list,
     * which contains the least-significant digit.
     *
     * Algorithm:
     * Just like you would sum two numbers on a piece of paper, we begin by summing the least significant digits,
     * which is the head of l1 and l2. Since each digit is in the range of 0...9, summing two digits may "overflow".
     * For example 5+7=12. In this case, we set the current digit to 2 and bring over the carry =1 to the next iteration.
     * Carry must be either 0 or 1 because the largest possible sum of two digits (including the carry) is 9+9+1 = 19
     *
     * Pseudocode:
     * Initialize the current node to dummy head of the returning list.
     * Initialize carry to 0.
     * Initialize p and q to head of l1 and l2 respectively.
     * Loop through lists l1 and l2 until you reach both ends.
     *      Set x  to node p's value. If p has reached the end of l1, set to 0
     *      Set y to node q's value. If q has reached the end of l2 set to 0
     *      Set sum = x+y+carry
     *      Update carry  = sum/10
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        return null;
    }
}
class ListNodeX {
    int val;
    ListNode next;
    ListNodeX() {
    
    }
    ListNodeX(int val) {
        this.val = val;
    }
    ListNodeX(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
