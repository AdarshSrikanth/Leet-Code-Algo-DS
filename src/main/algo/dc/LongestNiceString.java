package main.algo.dc;

import java.util.HashSet;
import java.util.Scanner;
import main.Util;

public class LongestNiceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Util.println("Enter a string");
        String s = sc.nextLine();
        Util.println(printLongestNicePath(s));
        sc.close();
    }

    /**
     * https://leetcode.com/problems/longest-nice-substring/
     * 
     * Recurance tree: O(n) for divide + 2T(n / 2) for conquer + O(1) for combine
     * Time Complexity: Big-Theta (nlogn) for average case
     * Space Complexity: O(n).
     * 
     * Time complextity of divide is O(n) because the amortized hash set lookup cost is O(1). Otherwise it would be O(n^2)
     * 
     * @param s
     * @return
     */
    public static String printLongestNicePath(String s) {
        if (s.length() <= 1) {
            return "";
        }
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for (char c : arr) {
            set.add(c); // amortized cost of O(1)
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(Character.toUpperCase(arr[i])) && set.contains(Character.toLowerCase(arr[i]))) {
                continue;
            }
            // else Divide here. Divide takes O(n) checks when the item to divide is at the end of the array.
            String s1 = printLongestNicePath(s.substring(0, i));
            String s2 = printLongestNicePath(s.substring(i + 1, arr.length));
            return s1.length() > s2.length() ? s1 : s2;     // returns the max nice substring. Combine step: O(1)
        }
        return s;   // If entire string is a nice string
    }
}