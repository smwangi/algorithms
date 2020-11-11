
import java.io.BufferedWriter;
import java.io.IOException;

public class TailLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null){
            bufferedWriter.write(String.valueOf(node.data));
            node =  node.next;

            if(node != null){
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head,int data){

        if(head == null){
            return new SinglyLinkedListNode(data);
        }else{
            /*SinglyLinkedListNode node = head;

            while (node.next != null)
                node = node.next;
            return head;*/
            head.next = insertNodeAtTail(head.next,data);
            return head;
        }
    }
}
