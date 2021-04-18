
public class LinkedListKthLastNode {
    public String value;
    public LinkedListKthLastNode next;

    public LinkedListKthLastNode(String value){
        this.value = value;
    }
    public static void main(String[] args) {
        LinkedListKthLastNode a = new LinkedListKthLastNode("Angel Food");
        LinkedListKthLastNode b = new LinkedListKthLastNode("Bundt");
        LinkedListKthLastNode c = new LinkedListKthLastNode("Cheese");
        LinkedListKthLastNode d = new LinkedListKthLastNode("Devil's Food");
        LinkedListKthLastNode e = new LinkedListKthLastNode("Eccles Food");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

    }

    public static LinkedListKthLastNode kthLastNode(int k, LinkedListKthLastNode head){
        //STEP 1, Get the length of the list
        //Start 1 not 0
        // else we would fail to count the head node
        int listLength = 1;
        LinkedListKthLastNode currentNode = head;

        //traverse the whole list
        // counting all the nodes
        while (currentNode.next != null){
            currentNode = currentNode.next;
            listLength +=1;
        }
        //STEP 2, walk to the target node
        //Calculate how far to go from the head, to get to the kth to last node
        int howFarToGo = listLength - k;
        currentNode = head;
        for (int i = 0; i < howFarToGo;i++){
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.value);
        return currentNode;
    }
}
