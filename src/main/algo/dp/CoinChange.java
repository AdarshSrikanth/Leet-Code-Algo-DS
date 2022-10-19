package main.algo.dp;

import java.util.Arrays;

import main.Util;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = Util.get_input_array(Util.getScanner());
        int amount = 0;
        Util.println("Number of coins neede - " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int [amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length && coins[i] <= j; i++) {
                if (dp[j - coins[i]] ==Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }   
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;   
        }
        return dp[amount];
    }
}
