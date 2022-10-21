package main.algo.greedy;

import java.util.Scanner;

import main.Util;

public class WaterContainer {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        int[] heigth = Util.get_input_array(sc);
        Util.println("Max Water storage capacity : " + maxArea(heigth));
        sc.close();
    }
    
    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxarea = 0;
        while(i<j) {
            int area = (j - i) * Math.min(height[i],height[j]);
            if (maxarea < area) {
                maxarea = area;
            }
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxarea;
    }
}
