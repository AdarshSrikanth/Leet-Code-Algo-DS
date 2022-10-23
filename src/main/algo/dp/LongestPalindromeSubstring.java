package main.algo.dp;

import main.Util;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        Util.println("Longest Palindrome in \"" + s + "\" is \"" + longestPalindrome(s) + "\"");
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        int maxLen = 0, maxStart = 0, maxEnd = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        
        return s.substring(maxStart, maxEnd);
    }
}
