package main.algo.dp;

import main.Util;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] nums = Util.get_input_array(Util.getScanner());
        Util.println("maximum length of a increasing subsequence - " + lengthOfLIS(nums));
    }
    
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int opt[] = new int[n];
        for (int i = 0; i < n; i++) {
            opt[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (opt[i] < opt[j] + 1) {
                        opt[i] = opt[j] + 1;
                    }
                }
            }
        }
        
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if (max_len < opt[i]) {
                max_len = opt[i];
            }
        }
        
        return max_len;
    }
}
