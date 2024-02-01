package main.algo.greedy;

import main.Util;

import java.util.Arrays;
import java.util.Scanner;

public class DivideNumbersIntoMinimumDiffArrays {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        int[] nums = Util.get_input_array(sc);
        System.out.println("Enter the max diff: ");
        int k = Integer.parseInt(sc.next());
        int[][] out = divideArray(nums, k);
        if (out.length == 0) {
            System.out.println("Cannot divide the numbers into groups with " + k + " diff");
        } else {
            System.out.println("Numbers with at most " + k + " diff");
            for (int i = 0; i < out.length; i++) {
                Util.printarr(out[i], null);;
            }
        }
    }

    /**
     * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
     * 
     * Algo: Greedy - Sort the input numbers and assign them one by one into output groups.
     * When difference between group's last number and first number is more than k, return empty array.
     * 
     * Time: O(n)  Space: O(1)
     * 
     */
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int num_arrs = n/3;
        int idx = 0;
        int[][] out = new int[num_arrs][3];
        for (int i = 0; i < num_arrs; i++) {
            for (int j = 0; j < 3; j++) {
                out[i][j] = nums[idx];
                idx++;
            }
            if (out[i][2] - out[i][0] > k) {
                return new int[0][0];
            }
        }

        return out;
    }
}
