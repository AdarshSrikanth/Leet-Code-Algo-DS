package main.algo.dp;

import java.util.Scanner;

import main.Util;

public class CountBits {
    public static void main() {
        Scanner sc = Util.getScanner();
        Util.println("Enter a number");
        int n = Integer.parseInt(sc.nextLine());
        Util.println("Number of Bits: " + countBits(n));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[(i - 1) & i] + 1;
        }
        return ans;        
    }
}
