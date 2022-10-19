package main.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
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
