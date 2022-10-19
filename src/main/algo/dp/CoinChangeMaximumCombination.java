package main.algo.dp;

import java.util.Scanner;

import main.Util;

public class CoinChangeMaximumCombination {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] coin = Util.get_input_array(sc);
        Util.println("Enter the amount - ");
        int amount = Integer.parseInt(sc.next());
        Util.println("Maximum number of ways in which change for " + amount + " can be given: " + change(amount, coin));
    }

    /**
     * Calculate the ways to achieve a total n by using (1,2,3..,m) coins.
     * Space:   O(n^2)
     * Time:    O(n^3) - This could be simplified to O(n^2) if i don't iterate based on coins twice.
     *          This is doable if the opt array is amount x coins instead of coins x amount.
     *          In that case, the inner loop iterates over coins, which can be used to compute (amount - coin)
     *          over 1 loop instead of 2.
     * 
     * @param amount
     * @param coin
     * @return
     */
    public static int change(int amount, int[] coin) {
        int coins = coin.length;
        int opt[][] = new int[coins + 1][amount + 1];
        
        for (int i = 1; i <= coins; i++) {
            opt[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                for (int k = i - 1; k >= 0 ; k--) {
                    if (j - coin[k] >= 0) {
                        opt[i][j] += opt[k+1][j - coin[k]];
                    }
                }
            }
        }
        
        for (int i = 0; i <= coins; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(opt[i][j]);
            }
            System.out.print("\n");
        }
        
        return opt[coins][amount];
    }
}
