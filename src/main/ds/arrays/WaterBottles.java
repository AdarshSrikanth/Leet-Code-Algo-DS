package main.ds.arrays;

import java.util.Scanner;

import main.Util;

public class WaterBottles {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        System.out.println("Enter the number of full bottles available in the start:");
        int numBottle = Integer.parseInt(sc.next());
        System.out.println("Enter the empty bottles needed to exchange for a full bottle:");
        int numExchange = Integer.parseInt(sc.next());
        System.out.println("Num of water bottles user can get in total: " + numWaterBottles(numBottle, numExchange));
    }

    /*
     * https://leetcode.com/problems/water-bottles/
     * Time: O(n) Memory: O(1)
     */
    public static int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while (numBottles >= numExchange) {
            int new_count = numBottles / numExchange;
            int diff = numBottles - (new_count * numExchange);
            sum += new_count;
            numBottles = new_count + diff;
        }
        return sum;
    }
}
