package main.ds.arrays;

import main.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/* https://leetcode.com/problems/contains-duplicate/ */
public class ContainsDuplicate {
    public static void main (String[] args) {
        int[] nums = Util.get_input_array(new Scanner(System.in));
        System.out.println("\nInput array contains duplicates: " + containsDuplicate(nums));
    }

    // Time: O(nlogn) and Memory: O(1)
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // Time: O(n) and Memory: O(n)
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true; 
            }
        }
        return false;
    }
}
