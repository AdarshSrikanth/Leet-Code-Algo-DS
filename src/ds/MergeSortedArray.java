package ds;

import java.util.Scanner;

class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println("Enter the array size followed by the numbers");
        Scanner sc = new Scanner(System.in);
        Integer m = Integer.parseInt(sc.next());
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = (int) Integer.parseInt(sc.next());
        }
        System.out.println("Enter the array size followed by the numbers");
        Integer n = Integer.parseInt(sc.next());
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = (int) Integer.parseInt(sc.next());
        }
        sc.close();
    }

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int temp[] = new int[m];
        
        // copy nums1 into a temp array
        for (int m1=0; m1 < m; m1++) {
            temp[m1] = nums1[m1];
        }
        
        while(i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
                k++;
            } else {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        while (k < m+n && i < m) {
            nums1[k] = temp[i];
            i++;
            k++;
        }
        
        while (k < m+n && j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}