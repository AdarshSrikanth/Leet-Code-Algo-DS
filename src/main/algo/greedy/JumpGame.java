package main.algo.greedy;

import java.util.Scanner;

import main.Util;

class JumpGame {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] nums = Util.get_input_array(sc);
        Util.println("Can Jump - " + canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int last_index = n - 1;
        for (int j = n - 2; j >= 0; j--) {
            if (j + nums[j] >= last_index) {
                last_index = j;
            } 
        }
        return last_index <= nums[0];
    }
}