package main.algo.dp;

import main.Util;

public class RangeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Util.println("Range sum - " + sumRange(nums, 0, 2));
    }
    
    public static int sumRange(int[] nums, int left, int right) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + nums[i - 1];
        }
        return dp[right + 1] - dp[left];
    }
}
