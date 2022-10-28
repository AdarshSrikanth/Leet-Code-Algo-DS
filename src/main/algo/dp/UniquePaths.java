package main.algo.dp;

import java.util.Scanner;

import main.Util;

public class UniquePaths {
    public static void main(String[] args) {
        int m, n;
        Scanner sc = Util.getScanner();
        Util.println("Enter m x n dimension - ");
        m = Integer.parseInt(sc.nextLine());
        n = Integer.parseInt(sc.nextLine());
        Util.println("Number of unique ways from (0,0) to ("+ m + ","+ n +") is " + uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        // Init
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        
        // Memoize - top down
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        
        return dp[0][0];
    }
}