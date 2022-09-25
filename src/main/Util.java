package main;

import java.util.Scanner;

public class Util {
    public static int[] get_input_array(Scanner sc) {
        System.out.println("Enter the array size followed by the numbers");
        Integer size = Integer.parseInt(sc.next());
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = (int) Integer.parseInt(sc.next());
        }
        return input;
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printarr(int[] arr, String str) {
        println(str);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        println("\n");
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
    }

    public static void postorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            inorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}