package main.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import main.Util.TreeNode;

public class BottomLeftTreeVal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(2));
        System.out.println("Leftmost element in the binary tree: " + bfs(root));
    }
    
    /*
     * https://leetcode.com/problems/find-bottom-left-tree-value/
     * 
     * Use BFS to find the elements at the last level. Rremember the left most element at a level.
     * Time: O(V + E)
     */
    public static int bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int left_last = -1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode n = queue.remove();
                if (i == 0) {
                    left_last = n.val;
                }
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        return left_last;
    }
}
