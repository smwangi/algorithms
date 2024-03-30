public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node = new ListNode(null,1);
        node.next = new ListNode(null,2);
        node.next.next = new ListNode(null,3);
        node.next.next.next = new ListNode(null,4);
        node.next.next.next.next = new ListNode(null,5);
        int n = 4;
        RemoveNthNodeFromEndOfList(node, n);
    }
    public static ListNode RemoveNthNodeFromEndOfList(ListNode head, int n) {
        ListNode start = new ListNode(null,0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }

        // move fast to the end, maintaining the gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // skip the desired node.
        slow.next = slow.next.next;

        return start.next;
    }
}
