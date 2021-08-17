import java.util.Iterator;

/**
 * Iterators are used in Collection framework in Java to retrieve elements one by one.
 * Every class that implements Iterable interface appropriately can be used in the enhanced For loop.
 * The need to implement the iterator interfaces arises while designing custom data structure.
 * Steps:
 * 1. Implement Iterable interface along with its methods in the said Data Structure
 * 2. Create and Iterator class which implements Iterator interface and corresponding methods.
 *
 * How next() and hasNext() work?
 * To implement an Iterator, we need a cursor or pointer to keep track of which element we currently are on.
 * Depending on the underlying data structure, we can progress from one element to another.
 * This is done in the next() method which returns the current element and the cursor advances to next element.
 * Before advancing the pointer, we check whether next element exists. i.e. we can picturize the behind-the-scenes code as follows:
 *
 * While(iterator.hasNext()) { //if next element exists
 *     next(); // advance the pointer
 * }
 *
 * Initializing the cursor
 * The cursor initialization completely depends on the data structure.
 * For example, in a linked list we would initialize cursor to the head element.
 * In an array list, we would initialize cursor to the 0th element.
 * From the point of view of implementation:
 *
 *     If the Iterator class is implemented as an inner class, we can simply use “this” keyword
 *          (e.g. cursor = CustomDataStructure.this.element) to access the desired element
 *     If the Iterator class is implemented as a separate class, we can pass this object of the data structure
 *          to the iterator class constructor as demonstrated in the example below.
 */
public class ImplementIterator {
    
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("abc");
        myList.add("mno");
        myList.add("pqr");
        myList.add("xyz");
        
        for (String str : myList)
            System.out.println(str);
    }
}

/**
 * Given below is a Custom Linked List which makes use of Generics.
 * The linked list consists of Node objects which contain a Generic data value and pointer to next node.
 * The class provides some standard ‘get’ methods like getHead() and getTail(), and the necessary Iterator() function,
 * which has to be implemented while implementing Iterable interface.
 *
 * Then the necessary custom class ‘ListIterator’ is created, which will implement the Iterator interface,
 * along with it the functionalities of hasNext() and next() are also to be implemented.
 * These two functions form the core of Iterable and Iterator interface.
 * @param <T>
 */
class MyList<T> implements Iterable<T> {
    ItrNode<T> head, tail;
    //add a new Element at tail of the linked list in O(1)
    public void add(T data) {
        ItrNode<T> node = new ItrNode<>(data, null);
        if (head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }
    
    public ItrNode<T> getHead() {
        return head;
    }
    
    public ItrNode<T> getTail() {
        return tail;
    }
    
    //return the Iterator instance
   public Iterator<T> iterator() {
       return new ListIterator<T>(this);
   }
}


class ItrNode<T> {
    T data;
    ItrNode<T> next;
    
    public ItrNode(T data, ItrNode<T> next) {
        this.data = data;
        this.next = next;
    }
    // Setter for getter methods for Data and Next Pointer
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(ItrNode<T> next) {
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public ItrNode<T> getNext() {
        return next;
    }
}


class ListIterator<T> implements Iterator<T> {
    ItrNode<T> current;
    //Initialize pointer to head of the list for iteration
    public ListIterator(MyList<T> list) {
        current = list.getHead();
    }
    //returns false if next element does not exist
    public boolean hasNext() {
        return current != null;
    }
    //return current data and update pointer
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
    //remove
    public void remove() {
        throw new UnsupportedOperationException();
    }
}