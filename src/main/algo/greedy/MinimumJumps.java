package main.algo.greedy;

import main.Util;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] nums = Util.get_input_array(Util.getScanner());
        Util.println("Minimum Jumps to reach the end - " + jump(nums));
    }

    public static int jump(int[] nums) {
        // Here it is assumed that u can always reach the end.
        // Otherwise use Jump Game I sol to see if its possible to reach the end from start before proceeding with the solution
        
        int n = nums.length;
        if (nums[0] == 0 || n < 2) {
            return 0;
        }
        int curr_index = 1;
        int curr_max = nums[0];
        int count = 0;
        while(curr_max < n - 1) {
            int max = 0;
            for (int i = curr_index; i <= curr_max; i++) {
                int jump = i + nums[i];
                if (max < jump) {
                    max = jump;
                }
            }
            curr_index = curr_max + 1;
            curr_max = max;
            count++;
        }
        return count + 1;
    }
}
