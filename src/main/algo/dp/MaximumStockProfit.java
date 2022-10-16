package main.algo.dp;

import main.Util;

public class MaximumStockProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5 , 3, 6, 4};
        Util.println("Maximum profit: " + maxProfit(prices));
    }
    
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        int min = prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
            if (min < prices[i - 1]) {
                min = prices[i - 1];
            }
        }
        return dp[n];
    }
}
