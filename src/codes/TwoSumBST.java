import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 * Example 3:
 *
 * Input: root = [2,1,3], k = 4
 * Output: true
 * Example 4:
 *
 * Input: root = [2,1,3], k = 1
 * Output: false
 * Example 5:
 *
 * Input: root = [2,1,3], k = 3
 * Output: true
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -10^4 <= Node.val <= 10^4
 * root is guaranteed to be a valid binary search tree.
 * -10^5 <= k <= 10^5
 */
public class TwoSumBST {
    public static void main(String[] args) {

    }

    /**
     * Approach 1 Using HashSet[Accepted]
     *
     * The simplest solution will be to traverse over the whole tree and consider every possible pair of nodes
     * to determine if they can form the required sum kk. But, we can improve the process if we look at a little catch here.
     *
     * If the sum of two elements x + y equals k, and we already know that xx exists in the given tree,
     * we only need to check if an element yy exists in the given tree, such that y = k - x. Based on this simple catch,
     * we can traverse the tree in both the directions(left child and right child) at every step.
     * We keep a track of the elements which have been found so far during the tree traversal, by putting them into a set.
     *
     * For every current node with a value of p, we check if k-p already exists in the array.
     * If so, we can conclude that the sum k can be formed by using the two elements from the given tree.
     * Otherwise, we put this value pp into the set.
     *
     * If even after the whole tree's traversal, no such element pp can be found, the sum k can't be formed
     * by using any two elements.
     *
     * Complexity Analysis
     *
     * Time complexity : O(n). The entire tree is traversed only once in the worst case.
     * Here, nn refers to the number of nodes in the given tree.
     *
     * Space complexity : O(n). The size of the set can grow up to n in the worst case.
     */
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return find(root,k,set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;
        if(set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left,k,set) || find(root.right,k,set);
    }

    /**
     * Approach 2 Using BFS and HashSet [Accepted]
     *
     * In this approach, the idea of using the set is the same as in the last approach.
     * But, we can carry on the traversal in a Breadth First Search manner, which is a very common traversal method used in Trees. The way BFS is used can be summarized as given below. We start by putting the root node into a queuequeue. We also maintain a setset similar to the last approach. Then, at every step, we do as follows:
     *
     * Remove an element, p, from the front of the queue.
     *
     * Check if the element k-p already exists in the set. If so, return True.
     *
     * Otherwise, add this element, p to the set. Further, add the right and the left child nodes of the current node
     * to the back of the queue.
     *
     * Continue steps 1. to 3. till the queue becomes empty.
     *
     * Return false if the queue becomes empty.
     */
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer>set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            if(queue.peek() != null){
                TreeNode node = queue.remove();
                if(set.contains(k- node.val)){
                    return true;
                }
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            }else{
                queue.remove();
            }
        }
        return false;
    }
}
