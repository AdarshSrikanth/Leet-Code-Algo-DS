package main.algo.greedy;

import java.util.Arrays;

import main.Util;

public class JumpGameVII {
    public static void main(String[] args) {
        String s = "011010";
        Util.println("Can Jump - " + canReach(s, 1, 1));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        boolean[] dp = new boolean [n];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i] == false || s.charAt(i) != '0') {
                dp[i] = false;
                continue;
            }
            if (dp[i] == true) {
                continue;
            }
            else {
                for (int j = i + minJump; j < n && j <= i + maxJump; j++) {
                    if (s.charAt(i) == '0') {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
