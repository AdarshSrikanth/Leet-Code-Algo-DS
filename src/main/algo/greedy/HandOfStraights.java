package main.algo.greedy;

import java.util.HashMap;
import java.util.Scanner;

import main.Util;

import java.util.Arrays;

public class HandOfStraights {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int hand[] = Util.get_input_array(sc);
        Util.println("Enter group size: ");
        int groupSize = Integer.parseInt(sc.nextLine());
        Util.println("Possible to rearrange the cards: " + isNStraightHand(hand, groupSize));
    }

    /**
     * https://leetcode.com/problems/hand-of-straights/
     * 
     * Time Complexity: Initially looks to be O(nlogn + nk) => O(n^2)
     * But it could actually be Big-Theta(nlogn + n) => Big-Theta(nlogn) as we do not visit a number more than once while looping.
     * Min Heaps can be used to sort and remove items of a group in O(nlogn)
     * 
     * Tree Maps can be used to sort and keep track of item count in O(nlogn) as well.
     * 
     * 
     * @param hand
     * @param groupSize
     * @return
     */
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);  // O(nlogn)
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i] ,0) + 1);
        }
        int i = 0;
        // O (n)
        while(i < n) {
            if (map.get(hand[i]) <= 0) {
                i++;
            } else {
                // O(k), but k can be as big as n => O (n)
                for (int j = 0; j < groupSize; j++) {
                    if (map.getOrDefault(hand[i] + j, 0) > 0) {
                        map.put(hand[i] + j, map.get(hand[i] + j) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}