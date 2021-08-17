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
    static public Node head;
    
    public static void main(String[] args) {
    
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node middle = middleElement(node);
        System.out.println(middle.data);
    
        /* Start with the empty list */
        ListNode head = new LinkedLists().new ListNode(1);
        head.next = new LinkedLists().new ListNode(2);
        head.next.next = new LinkedLists().new ListNode(3);
        head.next.next.next = new LinkedLists().new ListNode(4);
        head.next.next.next.next = new LinkedLists().new ListNode(5);
        head.next.next.next.next.next = new LinkedLists().new ListNode(6);
        head.next.next.next.next.next.next =
                new LinkedLists().new ListNode(7);
        head.next.next.next.next.next.next.next =
                new LinkedLists().new ListNode(8);
    
        int k = 3;
        //head = deleteKthNode(head, k);
    
        displayList(head);
        
        BinarySearch binarySearch = new BinarySearch();
        Node headSearch = null;
        headSearch = BinarySearch.push(headSearch,1);
        headSearch = BinarySearch.push(headSearch,4);
        headSearch = BinarySearch.push(headSearch,7);
        headSearch = BinarySearch.push(headSearch,8);
        headSearch = BinarySearch.push(headSearch,9);
        headSearch = BinarySearch.push(headSearch,10);
        int value = 7;
        if (BinarySearch.binarySearch(headSearch, value) == null) {
            System.out.println("Value not present");
        } else {
            System.out.println("Present");
        }
    
        Node headDelPrime = null;
        headDelPrime = BinarySearch.push(headDelPrime,17);
        headDelPrime = BinarySearch.push(headDelPrime,7);
        headDelPrime = BinarySearch.push(headDelPrime,6);
        headDelPrime = BinarySearch.push(headDelPrime,16);
        headDelPrime = BinarySearch.push(headDelPrime,15);
    
        System.out.print("Original List: ");
        printList(headDelPrime);
        System.out.println("\nMin Max Node");
        minMaxPrimeNodes(headDelPrime);
        System.out.println( "Sum of nodes = "
                + sumOfNodesUtil(headDelPrime));
    
        headDelPrime = deletePrimeNodes(headDelPrime);
    
        System.out.print("\nModified List: ");
        printList(headDelPrime);
        Node node1 = new Node(1);
        node1.next = new Node(1);
        node1.next.next = new Node(2);
        node1.next.next.next = new Node(3);
        node1.next.next.next.next = new Node(3);
        Node withoutDupes = deleteDuplicated(node1);
        System.out.println("Without dups");
        printList(withoutDupes);
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
     * Given the head of a singly linked list, return true if it is a palindrome.
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     *
     * Algorithm
     *
     *     You have to Split the List in the Middle.
     *     Reverse the Second part of the List.
     *     Start from these two Lists. And Check if they are similar or not till you reach the end of the list.
     * @return
     */
    static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
    
        // find middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // two nodes at a time
            slow = slow.next;
        }
        slow = reversed(slow);
        fast = head;
        
        
        while (slow != null) {
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    /**
     * Algorithm
     *
     *     We use Three Pointers to reverse a List.
     *     The Three Pointers are Previous, Current and Next.
     *     Initialize Current pointer to Head.
     *     Traverse till the end of the List.
     *     Initialize the Previous pointer be null since there is nothing before head.
     *     At Each index, We have to know the next node. for traversing forward.
     *     Use Next to store the curr.next
     *     Now to Reverse the list. The current pointer’s next have to point the previous node.
     *     Now we have reversed the index. We have to repeat this step till the end of the list.
     *     We have to simply move one step ahead.
     *     For that, The current pointer becomes the previous pointer.
     *     The next pointer becomes the current.
     * @param head
     * @return
     */
    static Node reversed(Node head) {
        Node prev = null;
        while (head != null) {
            Node next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }
        return prev;
    }
    
    static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;
        
        Node newHead = null;
        Node fast = head;
        
        while (fast != null) {
            if (fast.next == null) {
                head = head.next;
            } else {
                fast = fast.next.next;
            }
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        while (newHead != null) {
            if (newHead.data != head.data) return false;
            newHead = newHead.next;
            head = head.next;
        }
        
        return true;
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
        while (node != null)
            head = head.next;
        
        Node current = head;
        while (current != null && current.next != null) {
            if(current.next.data == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return node;
    }
    
    static Node removeElementsRecursion(Node head, int val) {
        if(head == null) return null;
        head.next = removeElementsIterative(head.next, val);
        return head.data == val ? head.next : head;
    }
    
    
    static public class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    /**
     * Remove every k-th node of the linked list
     *
     * Examples :
     *
     * Input : 1->2->3->4->5->6->7->8
     *         k = 3
     * Output : 1->2->4->5->7->8
     * As 3 is the k-th node after its deletion list
     * would be 1->2->4->5->6->7->8
     * And now 4 is the starting node then from it, 6
     * would be the k-th node. So no other kth node
     * could be there.So, final list is:
     * 1->2->4->5->7->8.
     *
     * Input: 1->2->3->4->5->6
     *        k = 1
     * Output: Empty list
     * All nodes need to be deleted
     *
     * The idea is traverse the list from beginning and keep track of nodes visited after last deletion.
     * Whenever count becomes k, delete current node and reset count as 0.
     *
     * (1) Traverse list and do following
     *    (a) Count node before deletion.
     *    (b) If (count == k) that means current
     *         node is to be deleted.
     *       (i)  Delete current node i.e. do
     *
     *           //  assign address of next node of
     *           // current node to the previous node
     *           // of the current node.
     *           prev->next = ptr->next i.e.
     *
     *        (ii) Reset count as 0, i.e., do count = 0.
     *    (c) Update prev node if count != 0 and if
     *        count is 0 that means that node is a
     *        starting point.
     *    (d) Update ptr and continue until all
     *        k-th node gets deleted.
     */
    
    static ListNode deleteKthNode(ListNode head, int k) {
        // if linked list is empty
        if (head == null)
            return null;
        
        if (k == 1) {
            head = freeList(head);
            return null;
        }
        //Initialize ptr and prev before traversing
        ListNode ptr = head, prev = null;
        
        //Traverse the list and delete every k-th node
        int count = 0;
        while (ptr != null) {
            //Increment Node count
            // check if count is equal to k
            // if yes, then delete current node
            if (k == count) {
                //put the next of current Node in the next of previous node
                prev.next = ptr.next;
                //set count  = 0 to reach further k-th node
                count = 0;
            }
            //update prev if count is not 0
            if (count != 0 )
                prev = ptr;
            ptr = prev.next;
        }
        
        return head;
    }
    
    static ListNode freeList(ListNode node) {
        while (node != null) {
            ListNode next = node.next;
            node = next;
        }
        return node;
    }
    
    /* Function to print linked list */
    static void displayList(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
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
    
    /**
     * Binary Search on Singly Linked List
     * Difficulty Level : Easy
     *
     * Given a singly linked list and a key, find key using binary search approach.
     * To perform a Binary search based on Divide and Conquer Algorithm, determination of the middle element is important.
     * Binary Search is usually fast and efficient for arrays because accessing the middle index between two given indices
     * is easy and fast(Time Complexity O(1)). But memory allocation for the singly linked list is dynamic and non-contiguous,
     * which makes finding the middle element difficult. One approach could be of using skip list,
     * one could be traversing the linked list using one pointer.
     *
     * Prerequisite : Finding middle of a linked list.
     *
     * Note: The approach and implementation provided below are to show how Binary Search can be implemented on a linked list.
     * The implementation takes O(n) time.
     *
     * Approach :
     *
     * Here, start node(set to Head of list), and the last node(set to NULL initially) are given.
     * Middle is calculated using two pointers approach.
     * If middle’s data matches the required value of search, return it.
     * Else if middle’s data < value, move to upper half(setting start to middle's next).
     * Else go to lower half(setting last to middle).
     * The condition to come out is, either element found or entire list is traversed.
     * When entire list is traversed, last points to start i.e. last -> next == start.
     *
     * In main function, function InsertAtHead inserts value at the beginning of linked list.
     * Inserting such values(for sake of simplicity) so that the list created is sorted.
     *
     * Given a singly linked list and a key, find key using binary search approach.
     * To perform a Binary search based on Divide and Conquer Algorithm, determination of the middle element is important. Binary Search is usually fast and efficient for arrays because accessing the middle index between two given indices is easy and fast(Time Complexity O(1)). But memory allocation for the singly linked list is dynamic and non-contiguous, which makes finding the middle element difficult. One approach could be of using skip list, one could be traversing the linked list using one pointer.
     *
     * Prerequisite : Finding middle of a linked list.
     *
     * Note: The approach and implementation provided below are to show how Binary Search can be implemented on a linked list.
     * The implementation takes O(n) time.
     *
     * Examples :
     *
     * Input : Enter value to search : 7
     * Output : Found
     *
     * Input : Enter value to search : 12
     * Output : Not Found
     */
    static class BinarySearch {
        static int sum = 0;
        // Function to insert a node at the beginning of the Singly Linked List
        static Node push(Node head, int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        // Function to find middle element using Fast and Slow Pointers
        static Node middleNode(Node start, Node last) {
            if (start == null)
                return null;
            Node slow = start;
            Node fast = start.next;
            
            while (fast != last) {
                fast = fast.next;
                if (fast != last) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return slow;
        }
    
        /**
         * Algorithm
         *
         *     This approach is called a Two Pointer Approach.
         *     More Often than not, you will be implementing this approach to solve a LL Problem
         *     Initialize two Pointers Slow and Fast.
         *     Traverse till the End of the List based on the Fast pointer.
         *     For Each iteration, The Slow pointer moves one step while the Fast Pointer moves two Steps.
         *     So When the Fast Pointer Reaches the End of the List the Slow Pointer will be in the middle of the Linked List.
         * @param head
         * @return
         */
        static Node middleNode2(Node head) {
            if (head == null || head.next == null)
                return head;
            Node slow = head;
            Node fast = head;
            
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        
        // Function to insert a node at the beginning of the Singly Linked List
        static Node binarySearch(Node head, int value) {
            Node start = head;
            Node last = null;
            do {
                // Find Middle
                Node mid = middleNode(start, last);
                // If middle is Empty
                if (mid == null)
                    return null;
                // If value is present at middle
                if (mid.data == value)
                    return mid;
                // If value is less than mid
                else if (mid.data > value) {
                    start = mid.next;
                }
                // if the value is more than mid
                else
                    last = mid;
            } while (last == null || last != start);
            // value not present
            return null;
        }
    }
    // Delete all Prime Nodes from a Singly Linked List
    /**
     * Given a singly linked list containing N nodes, the task is to delete all nodes from the list which are prime.
     *
     * Examples:
     *
     * Input : List = 15 -> 16 -> 6 -> 7 -> 17
     * Output : Final List = 15 -> 16 -> 6
     *
     * Input : List = 15 -> 3 -> 4 -> 2 -> 9
     * Output :Final List = 15 ->4 -> 9
     *
     * Approach: The idea is to traverse the nodes of the singly linked list one by one and get the pointer of the nodes which are prime.
     * Delete those nodes by following the approach used in the post: Delete a node from Linked List.
     */
    static class DeletePrimeNode {
        static Node push(Node head, int data) {
            // allocate node
            Node new_node = new Node(data);
            // link the old list off the new node
            new_node = head;
            // move the head to point to the new node
            head = new_node;
            return head;
        }
    }
    static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        // This is checked so that we can skip middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
    // function to delete a node in a singly Linked List.
    // head_ref -. pointer to head node pointer.
    // del -. pointer to node to be deleted
    static Node deleteNode(Node head, Node del) {
        // Base case
        Node temp = head;
        if (head == null || del == null)
            return null;
        // if node to be deleted is head node
        if (head == del)
            head = del.next;
        // traverse list till not found
        // delete node
        while (temp.next != del) {
            temp = temp.next;
        }
        // copy address of node
        temp.next = del.next;
        return head;
    }
    // function to delete all prime nodes
    // from the singly linked list
    static Node deletePrimeNodes(Node head) {
        Node ptr = head;
        Node next;
        while (ptr != null) {
            next = ptr.next;
            // if true, delete node 'ptr'
            if (isPrime(ptr.data))
                deleteNode(head, ptr);
            ptr = next;
        }
        return head;
    }
    // function to print nodes in a given singly linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    
    /**
     * Minimum and Maximum Prime Numbers of a Singly Linked List
     *
     * Given a singly linked list containing N nodes, the task is to find the minimum and maximum prime number.
     *
     * Examples:
     *
     * Input : List = 15 -> 16 -> 6 -> 7 -> 17
     * Output : Minimum : 7
     *          Maximum : 17
     *
     * Input : List = 15 -> 3 -> 4 -> 2 -> 9
     * Output : Minimum : 2
     *          Maximum : 3
     * Approach:
     *
     * The idea is to traverse the linked list to the end and initialize the max and min variable to INT_MIN and INT_MAX respectively.
     * Check if the current node is prime or not. If Yes:
     * If current node’s value is greater than max then assign current node’s value to max.
     * If current node’s value is less than min then assign current node’s value to min.
     * Repeat above step until end of list is reached.
     * Below is the implementation of above idea:
     */
    // Function to find maximum and minimum
    // prime nodes in a linked list
    static void minMaxPrimeNodes(Node head_ref)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Node ptr = head_ref;
        while (ptr != null) {
            // if current node is prime
            if (isPrime(ptr.data)) {
                // update minimum
                min = Math.min(min, ptr.data);
                // update maximum
                max = Math.max(max, ptr.data);
            }
            ptr = ptr.next;
        }
        System.out.println("Minimum: "+min);
        System.out.println("Maximum: "+max);
    }
    /**
     * Sum of the nodes of a Singly Linked List
     * Given a singly linked list. The task is to find the sum of nodes of the given linked list.
     * Examples:
     * Input: 7->6->8->4->1
     * Output: 26
     * Sum of nodes:
     * 7 + 6 + 8 + 4 + 1 = 26
     *
     * Input: 1->7->3->9->11->5
     * Output: 36
     *
     * Recursive Solution:
     *
     * Call a function by passing the head and variable to store the sum.
     * Then recursively call the function by passing the next of current node and sum variable.
     * Add the value of the current node to the sum.
     * Below is the implementation of above approach:
     */
    // function to recursively find the sum of
    // nodes of the given linked list
    static int sum = 0;
    static void sumOfNodes(Node head) {
        // if head = null
        if (head == null)
            return;
        // recursively traverse the remaining nodes
        sumOfNodes(head.next);
        // accumulate sum
        sum = sum + head.data;
    }
    // utility function to find the sum of nodes
    static int sumOfNodesUtil(Node head) {
        sum = 0;
        // find the sum of nodes
        sumOfNodes(head);
        // required sum
        return sum;
    }
    // function to delete all non-prime nodes
    // from the singly linked list
    static Node deleteNonPrimeNodes(Node head) {
        // Remove all composite nodes at the beginning
        Node ptr = head;
        while (ptr != null && !isPrime(ptr.data)) {
            Node temp = ptr;
            ptr = ptr.next;
        }
        head = ptr;
        if (ptr == null)
            return null;
        // Remove remaining nodes
        Node curr = ptr.next;
        while (curr != null) {
            if (!isPrime(curr.data)) {
                ptr.next = curr.next;
                curr = ptr.next;
            } else {
                ptr = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    
    /**
     * Algorithm
     *
     *     Create a dummy variable. This is done to overcome edge conditions.
     *     Now traverse till both of the Linked Lists are Empty.
     *     This is done by using an OR Condition.
     *
     * (l1 != null || l2 != null)
     *
     * 4. When you introduce this condition, it is important that you think of the Edge Conditions. i,e What if one list is longer than the other. Then one node will be null while the other is not null. Here we don’t even have to check which one to merge since you just have to merge the one with the value.
     *
     * 5. At each iteration, Check which one of the element is smaller, merge that to the result list. Move forward in that list alone.
     *
     * 6. Repeat this till the End of both the Lists.
     * @param n1
     * @param n2
     * @return
     */
    Node mergeTwoList(Node n1, Node n2) {
        Node ans = new Node(0);
        Node a = ans;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                ans.next = n2;
                break;
            }
            if (n2 == null) {
                ans.next = n1;
                break;
            }
            if (n1.data < n2.data){
                ans.next = n1;
                n1 = n1.next;
            } else {
                ans.next = n2;
                n2 = n2.next;
            }
            ans = ans.next;
        }
        return a.next;
    }
    /**
     * Remove Nth Node From End of List
     *
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * Remove Nth Node From End of List
     *
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * Remove Nth Node From End of List
     *
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.After removing the second node from the end, the linked list becomes 1->2->3->5.
     */
    Node removeNthFromEnd(Node head, int n) {
        Node sen = new Node(0);
        sen.next = head;
        Node first = head;
        
        while (n > 0) {
            first = first.next;
            n--;
        }
        Node second = sen;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return sen.next;
    }
    /**
     * Reverse Linked List II
     *
     * Algorithm
     *
     *     Traverse till the mth node. Make it Current Node.
     *     Make the m-1 node as a start node.
     *     The Start Node indicates the start of the k-nodes that you have to reverse.
     *     Then you have Reverse the List from m to n.
     *     Now you have to link the start node to the last node of the reversed node.
     *     Link the Last Node to the current nth node.
     *     Return the List
     *
     */
    public Node reverseBetween(Node head, int m, int n) {
    
        Node curr  =head;
        Node start= null;
        while( m > 1)
        {
            start = curr;
            curr = curr.next;
            m--;
            n--;
        }
    
        Node tail = curr;
        Node prev = null;
        while( n >0)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        if(start != null)
            start.next = prev;
        else
            head = prev;
        tail.next = curr;
    
        return head;
    
    }
    //Remove Duplicates from Sorted List
    public static Node deleteDuplicated(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == current.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    //Deleting node from a singly linked list
    Node deleteNode(Node head, int d) {
        if (head == null)
            return null;
        Node n = head;
        if (n.data == d)
            return n.next; //Move head
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;//head didn't change
            }
            n = n.next;
        }
        return head;
    }
}
