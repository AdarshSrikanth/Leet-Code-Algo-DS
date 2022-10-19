package main.ds.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import main.Util;

public class TwoSumSorted {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] numbers = Util.get_input_array(sc);
        Arrays.sort(numbers);
        Util.println("Enter the target:");
        int target = Integer.parseInt(sc.nextLine());
        int[] res = twoSum(numbers, target);
        Util.printarr(res, "Elements at the following indexes add upto the target");
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int [2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (map.containsKey(numbers[i])) {
                res[0] = i + 1;
                res[1] = map.get(numbers[i]) + 1;
                return res;
            }
            map.put(target - numbers[i], i);
        }
        return res;
    }
}
