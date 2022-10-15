package main.algo.dp;

import java.util.Scanner;

import main.Util;

public class MinCostClimbStairs {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] cost = Util.get_input_array(sc);
        Util.println("Minimum cost to climb the stairs: " + minCostClimbingStairs(cost));
    }
    
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
