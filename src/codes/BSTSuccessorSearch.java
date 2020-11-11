
public class BSTSuccessorSearch {

    class Node{
        int data;
        Node left,right,parent;
        Node(int d){
            data = d;
            left = right = parent;
        }
    }
    public static void main(String[] args) {
        BSTSuccessorSearch successorSearch = new BSTSuccessorSearch();
        Node root = null,temp = null,suc = null, min = null,suc2 = null;
        root = successorSearch.insert(root,20);
        root = successorSearch.insert(root,8);
        root = successorSearch.insert(root,22);
        root = successorSearch.insert(root,4);
        root = successorSearch.insert(root,12);
        root = successorSearch.insert(root,10);
        root = successorSearch.insert(root,14);

        temp = root.left.right.right;
        suc = successorSearch.inorderSuccessor(root,temp);
        suc2 = successorSearch.inorderSuccessor(temp);
        if(suc2 != null){
            System.out.println("Inorder successor of "+temp.data+" is "+suc2.data);
        }
        if(suc != null){
            System.out.println("Inorder successor of "+temp.data+" is "+suc.data);
        }else{
            System.out.println("Inorder successor does not exist");
        }
    }
    static Node head;
    /* Given a binary search tree and a number,
     inserts a new node with the given number in
     the correct place in the tree. Returns the new
     root pointer which the caller should then use
     (the standard trick to avoid using reference
     parameters). */
    Node insert(Node node, int val){
        //1 if tree is empty, return  a new single node.
        if(node == null){
            return new Node(val);
        }else{
            Node temp = null;
            //2 Otherwise, recur down the tree
            if(val <= node.data){
                temp = insert(node.left,val);
                node.left = temp;
                temp.parent = node;
            }else{
                temp = insert(node.right,val);
                node.right = temp;
                temp.parent = node;
            }
            //Return the unchanged node pointer
            return node;
        }

    }

    /**
     * 1.	If right subtree of node is not NULL, then successor lies in right subtree. Do the following.
     *      Go to right subtree and return the node with minimum key value in the right subtree.
     * 2.	If right subtree of node is NULL, then successor is one of the ancestors. Do the following.
     *      Travel up using the parent pointer until you see a node which is left child of its parent.
     *      The parent of such a node is the successor.
     *
     *      Complexity Analysis:
     *
     * Time Complexity: O(h), where h is the height of the tree.
     * As in the second case(suppose skewed tree) we have to travel all the way towards the root.
     * Auxiliary Space: O(1).
     * Due to no use of any data structure for storing values.
     * @param root
     * @param n
     * @return
     */
    Node inorderSuccessor(Node root, Node n){
        //Step 1
        if(n.right != null){
            return minValue(n.right);
        }
        //Step 2
        Node p = n.parent;
        while (p != null && n == p.right){
            n = p;
            p = p.parent;
        }
        return p;
    }
    /** Given a non-empty binary search
       tree, return the minimum data
       value found in that tree. Note that
       the entire tree does not need
       to be searched.
     */
    Node minValue(Node node){
        Node current = node;
        //Loop to find leftmost leaf
        while (current.left != null){
            current = current.left;
        }
        return current;
    }

    Node inorderSuccessor(Node n){
        //Case 1 right node is not null -> go down to the next
        Node result = null;
        Node temp = n.right;
        while(temp != null){
            result = temp;
            temp = temp.left;
        }
        if(result != null)return result;

        //Case 2 While right child is null -> go up to the parent until  the node is a left child
        temp = n;
        while (temp != null){
            if (temp.parent != null && temp.parent.left == temp){
                return temp.parent;
            }
            temp = temp.parent;
        }
        return null;
    }
}
