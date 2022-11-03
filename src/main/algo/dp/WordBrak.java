package main.algo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBrak {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String> ();
        words.add("aaaa");
        words.add("aaa");
        wordBreak("aaaaaaa", words);
    }
    
    /**
     * https://leetcode.com/problems/word-break/submissions
     * 
     * O(n^2) run time and O(n) space
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String subs = wordDict.get(j);
                if (i + subs.length() > n) {
                    continue;
                }
                String ssub = s.substring(i, i + subs.length());
                if (subs.equals(ssub)) {
                    dp[i + subs.length()] = dp[i + subs.length()] || dp[i];
                    // initially dp[i + subs.length()] is false. If we had found any match in the past, then
                    // make sure this never becomes false as dp[i] for current word might be false;
                }
            }
        }
        return dp[n];
    }
}
