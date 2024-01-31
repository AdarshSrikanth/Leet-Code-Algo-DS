package main.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

import main.Util;

public class NextHighestTemperature {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        int[] temp = Util.get_input_array(sc);
        Util.printarr(nextHighestTemperature(temp), "Days until next highest temperature:");
    }

    /*
     * https://leetcode.com/problems/daily-temperatures/description/
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to
     * wait after the ith day to get a warmer temperature. 
     * 
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     * 
     * worst case upper bound: 
     *      Time: O(n + n)
     *      Space: O(n)
     * 
     */
    public static int[] nextHighestTemperature (int[] temp) {
        int n = temp.length;
        int[] out = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n - 1; i++) {
            if (temp[i + 1] > temp[i]) {
                out[i] = 1;
                while(!stack.isEmpty() && temp[stack.peek()] < temp[i + 1]) {
                    int idx = stack.pop();
                    out[idx] = (i + 1) - idx;
                }
            } else {
                stack.push(i);
            }
        }
        return out;
    }
}
