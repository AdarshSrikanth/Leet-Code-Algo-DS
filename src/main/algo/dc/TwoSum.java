package main.algo.dc;

import java.util.HashMap;
import java.util.Scanner;

class TwoSum {
    public static void main (String[] args) {
        try {
            System.out.println("Enter the array size followed by the numbers");
            Scanner sc = new Scanner(System.in);
            Integer size = Integer.parseInt(sc.next());
            int[] input = new int[size];
            for (int i = 0; i < size; i++) {
                input[i] = (int) Integer.parseInt(sc.next());
            }
            System.out.println("Enter the sum");
            Integer sum = Integer.parseInt(sc.next());
            int[] result = twoSum(input, sum);
            
            System.out.println("Indices: (" + result[0] + " , " + result[1] + " )");
            sc.close();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * https://leetcode.com/problems/two-sum/
     * 
     * TwoSum - Find the index of pairs of numbers adding up to given sum
     * Ds: HashMap         Algo: Naive             Analysis: O(n)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(nums[i])) {
                return new int[]{i, sumMap.get(nums[i])};
            }
            sumMap.put(target - nums[i], i);
        }
        return new int[]{0, 0};
    }
}