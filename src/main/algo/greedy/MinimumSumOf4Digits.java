package main.algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

import main.Util;

public class MinimumSumOf4Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Util.get_input_array(sc);
        Util.println("Minimum number: " + minimumSum(nums));
        sc.close();
    }
    
    /**
     * Greedy - O(n logn)
     * Because the problem size is fixed, we can iterate and find the 2 smallest numbers in O(2n) time.
     * 
     * @param nums
     * @return
     */
    public static int minimumSum(int[] nums) {
        Arrays.sort(nums);
        int num1 = nums[0] * 10 + nums[2];
        int num2 = nums[1] * 10 + nums[3];
        return num1 + num2;
    }
}
