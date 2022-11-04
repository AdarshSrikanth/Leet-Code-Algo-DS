package main.algo.dp;

import main.Util;

public class PlaceHouse {
    public static void main(String[] args) {
        int num = 10;
        Util.println("Number of ways to arrange houses in " + num + " plots: " + countHousePlacements(num));
    }
    
    /**
     * https://leetcode.com/problems/count-number-of-ways-to-place-houses
     * 
     * Fibonaci extension
     */
    public static int countHousePlacements(int n) {
        long[] dp = new long[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            long c = (dp[0] + dp[1]) % ((int)1e9 + 7);
            dp[0] = dp[1];
            dp[1] = c;
        }
        return (int)((dp[1] * dp[1]) % ((int)1e9 + 7));
    }
}
