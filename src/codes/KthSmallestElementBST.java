import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 *
 *
 * Constraints:
 *
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Hints
 * Try to utilize the property of a BST.
 * Try in-order traversal. (Credits to @chan13)
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode root = new KthSmallestElementBST().new TreeNode(3);
        root.left = new KthSmallestElementBST().new TreeNode(1);
        root.left.right = new KthSmallestElementBST().new TreeNode(2);;
        root.right = new KthSmallestElementBST().new TreeNode(4);;

        KthSmallestElementBST smallestElementBST = new KthSmallestElementBST();
        System.out.println(smallestElementBST.kthSmallest(root,1));
        System.out.println(smallestElementBST.kthSmallestIterative(root,1));
    }

    /**
     * It's a very straightforward approach with O(N) time complexity.
     * The idea is to build an inorder traversal of BST which is an array sorted in the ascending order.
     * Now the answer is the k - 1th element of this array.
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k-1);
    }

    public int kthSmallestIterative(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }

    /**
     * Complexity Analysis
     *
     * Time complexity:     O(N) to build a traversal.
     * Space complexity:    O(N) to keep an inorder traversal.
     * @param root
     * @param arr
     * @return
     */
    public ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
        if(root == null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }

    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode (){}
        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
