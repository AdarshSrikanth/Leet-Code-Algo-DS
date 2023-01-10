package main.algo.dc;

import java.util.*;

class CheckDuplicate {
    public static void main (String[] args) {
        try {
            System.out.println("Enter the array size followed by the numbers");
            Scanner sc = new Scanner(System.in);
            Integer size = Integer.parseInt(sc.next());
            int[] input = new int[size];
            for (int i = 0; i < size; i++) {
                input[i] = (int) Integer.parseInt(sc.next());
            }
            // boolean result = containsDuplicate(input);
            System.out.println("Enter k");
            Integer k = Integer.parseInt(sc.next());
            boolean result = containsDuplicate2(input, k);
            
            System.out.println("Contains Duplicate: " + result);
            sc.close();
        }
        catch (Exception ex) {
            throw ex;
        }
        
    }

    /**
     * https://leetcode.com/problems/contains-duplicate/
     * 
     * CheckDuplicate - duplicate element in an array
     * DS: HashSet         Algo: Naive             Analysis: O(n)
     * 
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(Integer.valueOf(nums[i]))) {
                return true;
            }
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/contains-duplicate-ii/
     * 
     * CheckDuplicate2 - duplicate element between given indices
     * DS: HashSet         Algo: Naive             Analysis: O(n)
     * 
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        for (; i <= k && i < nums.length; i++) {
            if (!set.add(Integer.valueOf(nums[i]))) {
                return true;
            }
        }
        for (int j = i - k - 1; i < nums.length; i++, j++) {
            set.remove(nums[j]);
            if (!set.add(Integer.valueOf(nums[i]))) {
                return true;
            }
        }
        return false;
    }
}