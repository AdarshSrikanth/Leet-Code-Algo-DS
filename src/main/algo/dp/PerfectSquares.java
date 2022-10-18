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
}