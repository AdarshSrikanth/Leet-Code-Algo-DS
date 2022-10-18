package main.algo.dp;

import main.Util;

public class HouseRobberCyclic {
    public static void main(String[] args) {
        int[] nums = Util.get_input_array(Util.getScanner());
        Util.println("Maximum value robbed in cyclic neighbourhood - " + robCyclic(nums));
    }

    public static int robCyclic(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int opt_2 = nums[0];
        int opt_1 = Math.max(nums[0], nums[1]);
        
        int dp1, dp2;
        
        // rob house 0. then problem reduced to houses 0 to n-1
        for (int i = 2; i < n-1; i++) {
            int temp = Math.max(nums[i] + opt_2, opt_1);
            opt_2 = opt_1;
            opt_1 = temp;
        }
        dp1 = opt_1;
        
        opt_2 = nums[1];
        opt_1 = Math.max(nums[2], nums[1]);
        // dont rob house 0. then problem reduced to houses 1 to n
        for (int i = 3; i < n; i++) {
            int temp = Math.max(nums[i] + opt_2, opt_1);
            opt_2 = opt_1;
            opt_1 = temp;
        }
        dp2 = opt_1;
        
        return Math.max(dp1, dp2);
    }
}
