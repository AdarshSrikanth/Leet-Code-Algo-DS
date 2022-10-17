package main.algo.dp;

import main.Util;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = Util.get_input_array(Util.getScanner());
        Util.println("Maximum loot without alerting cops - " + rob(nums));
    }
    
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0]; 
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
