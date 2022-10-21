package main.algo.dp;

import java.util.Scanner;

import main.Util;

public class ClimbStairs {
    public static void main(String[] args) {
        Util.println("Enter the stair number to reach:");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        Util.println(climbStairs(n) + " ways to reach step " + n);
        sc.close();
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
