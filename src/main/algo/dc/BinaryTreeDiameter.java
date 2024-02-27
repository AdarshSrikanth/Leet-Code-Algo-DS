package main.algo.dc;

import main.Util.TreeNode;

public class BinaryTreeDiameter {
    private static int max_diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        findDiameter(root);
        System.out.println("Diameter of the tree: " + max_diameter);;
    }
    

    /*
     * https://leetcode.com/problems/diameter-of-binary-tree/description/
     * 
     * Find depth of the left tree and right tree. Calculate the diameter at current node.
     * current diameter = left depth + right depth
     * Keep track of current_depth at every node and find the max value.
     * 
     * Recurrence tree: O(1) + 2T(n/2)
     * TIme complexity: Big-Theta (n)
     */
    private static int findDiameter (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left_depth = findDiameter(node.left);
        int right_depth = findDiameter(node.right);
        int current_diameter = left_depth + right_depth;
        max_diameter = Math.max(current_diameter, max_diameter);
        return 1 + Math.max(left_depth, right_depth);
    }
}
