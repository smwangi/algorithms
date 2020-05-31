package codes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s, this node A is visible.
 * We need to count the number of visible nodes in a binary tree.
 */
public class BinaryTreeVisibleNodes {

    static ArrayList<Integer> visible  = new ArrayList<>();

    public static void main(String[] args) {

        int n = 51/10;
        int x = 51%10;
        System.out.println(n+x);
        TreeNode root   =   new TreeNode(5);
        root.left       =   new TreeNode(3);
        root.right      =   new TreeNode(10);
        root.left.left  =   new TreeNode(20);
        root.left.right =   new TreeNode(21);

        root.right.left =   new TreeNode(1);

        dfs(root,0);
        System.out.println(Arrays.toString(visible.toArray()));
    }

    static void dfs(TreeNode node, int max){
        if(node == null)
            return;
        System.out.println("max1 "+max+" node val "+node.val);
        if(node.val >= max){
            visible.add(node.val);
            max = Math.max(node.val,max);
        }
        System.out.println("max2 "+max+" left node val "+node.val);
        dfs(node.left, max);
        System.out.println("max2 "+max+" right node val "+node.val);
        dfs(node.right, max);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


}
