/**
 * Given head of a linkedList return true if it is a palindrome
 * e.g. [1,2,2,1] => true
 * [1,2] => false
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    }
    public boolean isPalindrome(LinkedLists.Node head) {
        // check if the list is empty or it has single node
        if (head == null || head.next == null) return true;

        // initialize two pointers
        LinkedLists.Node slow = head;
        LinkedLists.Node fast = head;

        // find middle node of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half of the list
        slow.next = reverse(slow.next);
        // update slow point
        slow = slow.next;
        fast = head;

        // iterate through both lists simultaneously
        while (slow != null) {
            if (slow.data != fast.data) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static LinkedLists.Node reverse(LinkedLists.Node head) {
        LinkedLists.Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
