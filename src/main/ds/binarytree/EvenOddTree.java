package main.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import main.Util.TreeNode;

public class EvenOddTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(10), new TreeNode(8));
        System.out.println("Is EvenOdd tree: " + isEvenOddTree(root));
    }

    /*
     * https://leetcode.com/problems/even-odd-tree/
     * 
     * Perform breadth first search and check for the EvenOdd tree condition at each level.
     * Time: O(V + E)
     * Memory: O(1)
     */
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean is_even = true;
        while(!queue.isEmpty()) {
            int q_size = queue.size();
            int prev_val = is_even ? 0 : 1000001;
            for (int i = 0; i < q_size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                if (is_even) {
                    if (val % 2 == 0 || val <= prev_val) {
                        return false;
                    }
                    prev_val = val;
                } else {
                    if (val % 2 != 0 || val >= prev_val) {
                        return false;
                    }
                    prev_val = val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            is_even = is_even ? false : true;
        }

        return true;
    }
}
