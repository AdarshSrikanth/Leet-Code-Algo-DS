package main.algo.dc;

import java.util.Scanner;

class MaximumSubArray {
    public static void main (String[] args) {
        try {
            System.out.println("Enter the array size followed by the numbers");
            Scanner sc = new Scanner(System.in);
            Integer size = Integer.parseInt(sc.next());
            int[] input = new int[size];
            for (int i = 0; i < size; i++) {
                input[i] = (int) Integer.parseInt(sc.next());
            }
            int result = maximumSubArray(input);
            
            System.out.println("Maximum Sum: " + result);
            sc.close();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * https://leetcode.com/problems/maximum-subarray/
     * 
     * Overall O(n) soluton - Kadane's Algorithm
     * 
     * @param nums
     * @return
     */
    public static int maximumSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i] , nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    /**
     * 
     * DP - Memoization. Note kadane's solution is memory optimized version of this bottom up memoization.
     * 
     * @param nums
     * @return
     */
    /*
    public static int maximumSubArray(int[] nums) {
        int n = nums.length;
        int opt[] = new int[n + 1];
        opt[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            opt[i] = Math.max(opt[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(opt[i], max);
        }
        return max;
    }
    */
}