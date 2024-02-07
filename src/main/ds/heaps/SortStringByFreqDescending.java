package main.ds.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import main.Util;

public class SortStringByFreqDescending {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        System.out.println("Enter a string:");
        String s = sc.nextLine();
        System.out.println("String sorted by frequence of chars: " + frequencySort(s));
    }

    /*
     * https://leetcode.com/problems/sort-characters-by-frequency/description/
     * 
     * Given a string s, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string. Return the sorted string
     * 
     * HashMap + MaxHeap
     * 
     * Time: O(nlogn) Space: O(2n)
     * 
     */
    public static String frequencySort(String str) {
        String s = str.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Char> maxHeap = new PriorityQueue<Char>(new SortByFreqDescending());
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Char c = new Char(entry.getKey(), entry.getValue());
            maxHeap.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Char c = maxHeap.poll();
            for (int i = 0; i < c.freq; i++) {
                sb.append(c.c);
            }
        }
        return sb.toString();
    }

    public static class Char {
        char c;
        int freq;

        public Char(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public static class SortByFreqDescending implements Comparator<Char> {
        @Override
        public int compare (Char c1, Char c2) {
            return c2.freq - c1.freq;
        }
    }
}
