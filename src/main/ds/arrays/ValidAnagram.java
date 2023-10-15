package main.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/* https://leetcode.com/problems/valid-anagram/description/ */
public class ValidAnagram {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(String.format("Strings %s and %s are anagrams: %b", s, t, isAnagram(s, t)));
        sc.close();
    }

    // Time - O(nlogn) Space - O(n)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        PriorityQueue<Character> minHeap = new PriorityQueue<Character>();
        for (int i = 0; i < s.length(); i++) {
            minHeap.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (!minHeap.remove(Character.valueOf(t.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    // Time - O(n). HashMap amortised cost for get and put are O(1). Space - O(n) 
    public static boolean isAnagram2(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        if (slen != tlen) {
            return false;
        }
        
        Map<Character, Integer> count_map = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            count_map.put(Character.valueOf(s.charAt(i)), count_map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < tlen; i++) {
            count_map.put(Character.valueOf(t.charAt(i)), count_map.getOrDefault(t.charAt(i), 0) - 1);
            if (count_map.getOrDefault(t.charAt(i), 0) == 0) {
                count_map.remove(t.charAt(i));
            }
        }
        
        return count_map.size() == 0;
    }
}
