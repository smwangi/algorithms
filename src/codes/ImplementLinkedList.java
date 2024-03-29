public class ImplementLinkedList {
    
    
    class LinkedList {
        private Node head;
        private int length = 0;
        
        public LinkedList() {
            this.head = new Node(null);
        }
        public int size() {
            return length;
        }
        
        //Adds an element to the end of the list
        public void add(Object data) {
            Node node = new Node(data);
            Node iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.next;
            }
            iterator.setNext(node);
            length++;
        }
        //obtains an element by index
        public Object get(int index) {
            if (head.getNext() == null || index > length) {
                return null;
            }
            Node iterator = head.getNext();
            int counter = 0;
            while (counter < index) {
                iterator = iterator.getNext();
                counter++;
            }
            return iterator.getData();
        }
        //returns the index of the element in the list
        public int indexOf(Object data) {
            Node obj = head;
            for (int i = 0; i < length; i++) {
                obj = obj.getNext();
                if (obj.getNext() == data) {
                    return i;
                }
            }
            return -1;//or throw new exception ("Data not found");
        }
        // Removes an element from the list
        public boolean remove(Object data) {
            if (head.getNext() == null) {
                return false;
            }
            Node iterator = head;
            while (iterator.getNext() != null) {
                if (iterator.getNext().getData().equals(data)) {
                    iterator.setNext(iterator.getNext().getNext());
                    length--;
                    return true;
                }
                iterator = iterator.getNext();
            }
            return false;
        }
    }
    
    private class Node {
        private Object data;
        private Node next;
        
        public Node(Object data) {
            this.data = data;
            next = null;
        }
        
        public Object getData() {
            return data;
        }
    
        public void setData(Object data) {
            this.data = data;
        }
        public Node getNext() {
            return this.next;
        }
    
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
