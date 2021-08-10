import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest value
 * to that target value contained in the BST.
 *
 * You can assume that there will be only one closest value.
 *
 * Each BST node has an integer value, a left child node and a right child node. A node is said to be a valid BST node if and only if it
 * satisfies the BST property. its value is strictly greater than the values of every node to its left; its value is less than or equal
 * to the values of every node to its right; and its children nodes are either valid BST nodes themselves or None/null
 *
 *          10
 *         /   \
 *        5     15
 *       / \   /  \
 *      2   5 13   22
 *     /        \
 *    1          14
 *
 *    target = 12
 */
public class BSTClosestVal {
    public static void main(String[] args) {
    
    }
    // Iterative
    // Average time O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space
    static int findClosestValueInBst(BST tree, int target) {
        BST currentNode = tree;
        double minDiff = Double.MAX_VALUE;
        int closestValue = currentNode.value;
        
        while (currentNode != null) {
            double currentDiff = Math.abs(target - currentNode.value);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closestValue = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closestValue;
    }
    
    //Recursive
    static int findClosestValueInBst(BST tree, int target, int closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return closest;
        }
    }
    
    static class BST {
      public int value;
      public BST left, right;
      
      public BST(int value) {
      
      }
    }
}
