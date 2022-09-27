package main.algo.dc;

import java.util.Arrays;
import java.util.Scanner;

import main.Util;
import main.Util.TreeNode;

public class BuildBinarySearchTreeFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = Util.get_input_array(sc);
        MergeSort.mergeSortAsc(nums, 0, nums.length - 1);
        TreeNode root = buildBSTFromSortedArray(nums);
        Util.inorderTraversal(root);
    }

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
     * 
     * Make the median of the sorted array as the root of BST
     * Root.Left = median of the left sub tree
     * Root.right = median of the right sub tree
     * 
     * Recurrance tree: T(n) = 2T(n/2) + O(1)
     * Time Complexity: Big-Theta (n)
     * 
     * @param input
     * @return
     */
    public static TreeNode buildBSTFromSortedArray(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        
        if (nums.length < 1) {
            return null;
        }
        
        int mid = Math.floorDiv(0 + (nums.length - 1), 2);
        TreeNode node = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        node.left = buildBSTFromSortedArray(left);
        node.right = buildBSTFromSortedArray(right);
        return node;
    }
}
