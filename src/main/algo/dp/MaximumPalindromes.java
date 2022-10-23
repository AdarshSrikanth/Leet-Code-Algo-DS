package main.algo.dp;

import main.Util;

public class MaximumPalindromes {
    public static void main(String[] args) {
        String s = "babad";
        Util.println("Longest Palindrome in \"" + s + "\" is \"" + countSubstrings(s) + "\"");
    }
    
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int palindromeCount = 0;
        
        for (int i = 0; i < n; i++) {
            // Same char
            dp[i][i] = true;
            palindromeCount++;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j]) {
                    palindromeCount++;
                }
            }
        }
        
        return palindromeCount;
    }
}
