package main.algo.dp;

import main.Util;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        Util.println("Number of squares needed to sum up " + n + " is " + numSquares(n));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int lastps = 1, seclastps = 1;
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            if(isPerfectSquare(i)) {
                dp[i] = 1;
                seclastps = lastps;
                lastps = i;
            } else {
                dp[i] = Math.min(dp[i - lastps] + 1, dp[i - seclastps] + 1);
            }
        }
        return dp[n];
    }
    
    public static boolean isPerfectSquare(int n) {
        int r = (int) Math.floor(Math.sqrt(n));
        return n == r * r;
    }
}