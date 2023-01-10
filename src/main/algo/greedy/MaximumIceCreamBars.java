package main.algo.greedy;

import java.util.Arrays;
import java.util.Scanner;
import main.Util;

public class MaximumIceCreamBars {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        int[] costs = Util.get_input_array(sc);
        Util.println("Enter number of coins:\n");
        int coins = Integer.parseInt(sc.next());
        Util.println("Maximum number of ice creams bars purchasable: " + maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        while(i < costs.length && costs[i]<=coins) {
            coins -= costs[i];
            i++;
        }
        return i;
    }
}
