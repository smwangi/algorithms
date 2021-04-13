/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class LinkedLists {
    public static void main(String[] args) {
    
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node middle = middleElement(node);
        System.out.println(middle.data);
    }
    
    /**
     * Approach 2: Fast and Slow Pointer
     * Intuition and Algorithm
     *
     * When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast.
     * When fast reaches the end of the list, slow must be in the middle.
     * @param head
     * @return
     */
    static Node middleElement(Node head) {
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    /**
     * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
     * instead you will be given access to the node to be deleted directly.
     *
     * It is guaranteed that the node to be deleted is not a tail node in the list.
     *
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9
     * after calling your function.
     *
     * Input: head = [4,5,1,9], node = 1
     * Output: [4,5,9]
     * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9
     * after calling your function.
     * Example 3:
     *
     * Input: head = [1,2,3,4], node = 3
     * Output: [1,2,4]
     * Example 4:
     *
     * Input: head = [0,1], node = 0
     * Output: [1]
     * Example 5:
     *
     * Input: head = [-3,5,-99], node = -3
     * Output: [5,-99]
     *
     * Constraints:
     *
     * The number of the nodes in the given list is in the range [2, 1000].
     * -1000 <= Node.val <= 1000
     * The value of each node in the list is unique.
     * The node to be deleted is in the list and is not a tail node
     *
     * SOLUTION
     * Approach: Swap with Next Node [Accepted]
     * The usual way of deleting a node node from a linked list is to modify the next pointer of the node before it,
     * to point to the node after it.
     *
     * Since we do not have access to the node before the one we want to delete, we cannot modify the next pointer of
     * that node in any way. Instead, we have to replace the value of the node we want to delete with the value
     * in the node after it, and then delete the node after it.
     *
     * @param node
     * @return
     */
    static Node deleteNode(Node node) {
    
        node.data = node.next.data;
        node.next = node.next.next;
        return node;
    }
    
    /**
     * Given the head of a linked list and an integer val,
     * remove all the nodes of the linked list that has Node.val == val, and return the new head.
     *
     * Input: head = [1,2,6,3,4,5,6], val = 6
     * Output: [1,2,3,4,5]
     *
     * Example 2:
     *
     * Input: head = [], val = 1
     * Output: []
     * Example 3:
     *
     * Input: head = [7,7,7,7], val = 7
     * Output: []
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [0, 104].
     * 1 <= Node.val <= 50
     * 0 <= k <= 50
     *
     * Here's an iterative solution without dummy head.
     * First, we shift a head of a list while its' value equals to val.
     * Then, we iterate through the nodes of the list checking if the next node's value equals
     * to val and removing it if needed.
     *
     * @param node
     * @param val
     * @return
     */
    static Node removeElementsIterative(Node node, int val) {
        while (node != null) head = head.next;
        Node current = head;
        while (current != null && current.next != null) {
            if(current.next.data == val) current.next = current.next.next;
            else current = current.next;
        }
        return node;
    }
    
    static Node removeElementsRecursion(Node head, int val) {
        if(head == null) return null;
        head.next = removeElementsIterative(head.next, val);
        return head.data == val ? head.next : head;
    }
    
    static public Node head;
    static public class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    /**
     * Note: Try to solve this task in O(n) time using O(1) additional space,
     * where n is the number of elements in the list, since this is what you'll be asked to do during an interview.
     *
     * Given a singly linked list of integers l and an integer k,
     * remove all elements from list l that have a value equal to k.
     *
     * Example
     *
     * For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
     * removeKFromList(l, k) = [1, 2, 4, 5];
     * For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
     * removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] linkedlist.integer l
     *
     * A singly linked list of integers.
     *
     * Guaranteed constraints:
     * 0 ≤ list size ≤ 105,
     * -1000 ≤ element value ≤ 1000.
     *
     * [input] integer k
     *
     * An integer.
     *
     * Guaranteed constraints:
     * -1000 ≤ k ≤ 1000.
     *
     * [output] linkedlist.integer
     *
     * Return l with all the values equal to k removed.
     */
    // Singly-linked lists are already defined with this interface:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if(l == null) {
            return l;
        }
    
        while (l.value == k && l != null) {
            l = l.next;
            if(l == null){
                break;
            }
        
        }
    
        if(l == null) {
            return l;
        }
        ListNode c = l;
        while (c.next  != null) {
            if((int)c.next.value == k) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return l;
    }
}
