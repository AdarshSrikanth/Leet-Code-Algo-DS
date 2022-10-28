package main.algo.dp;

import main.Util;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0}, {1,1}, {0,0}};
        Util.println("Number of ways to reach the destination with obstacles - " + uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        // We could have worked on obstacle grid itself, but it could just make the sol more confusing.
        int[][] dp = new int[m][n];
        
        boolean obstacleFound = false;
        for (int i = m - 1; i >= 0; i--) {
            if (!obstacleFound && obstacleGrid[i][n - 1] != 1) {
                dp[i][n - 1] = 1;
            } else {
                dp[i][n - 1] = 0;
                obstacleFound = true;
            }
        }
        
        obstacleFound = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!obstacleFound && obstacleGrid[m - 1][i] != 1) {
                dp[m - 1][i] = 1;
            } else {
                dp[m - 1][i] = 0;
                obstacleFound = true;
            }
        }
        
        // top down memoization
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        
        return dp[0][0];
    }
}
