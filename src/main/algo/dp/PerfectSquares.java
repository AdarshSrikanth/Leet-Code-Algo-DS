package main.algo.dp;

import java.util.ArrayList;
import java.util.List;

import main.Util;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 48;
        Util.println("Number of squares needed to sum up " + n + " is " + numSquares(n));
    }

    /**
     * https://leetcode.com/problems/perfect-squares
     * 
     * Time complexity: O (n logn) - Pseudo Polynomial in terms of input (one whole number)
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        List<Integer> ps = new ArrayList<>();
        ps.add(1);
        for (int i = 3; i <= n; i++) {
            if(isPerfectSquare(i)) {
                dp[i] = 1;
                ps.add(i);
            } else {
                int min = Integer.MAX_VALUE;
                for (Integer j : ps) {
                    // O (log n)
                    min = min > dp[i - j] ? dp[i - j] : min;
                }
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }
    
    public static boolean isPerfectSquare(int n) {
        int r = (int) Math.floor(Math.sqrt(n));
        return n == r * r;
    }

    /*
     * More time solution. Calculate the perfect squares at the start and save it to avoid calculating perferct squares in the future.
     * 
     * Space: O(n + sqrt(n)) = O(n)
     * Time: O(nlogn)
     * 
     */
    public static int numSquares2 (int n) {
        if (n < 4) {
            return n;
        }
        int closestPerfectSqInt = (int)Math.floor(Math.sqrt(n));
        int[] perfectSquares = new int[closestPerfectSqInt];

        for (int i = 0; i < closestPerfectSqInt; i++) {
            perfectSquares[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < perfectSquares.length && perfectSquares[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - perfectSquares[j]] + 1);
            }
        }

        return dp[n];
    }
}