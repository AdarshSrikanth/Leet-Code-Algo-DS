package main.ds.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import main.Util;

public class KFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        // int[] nums = {3, 0, 1, 0};
        // int[] nums = {1};
        int k = 2;
        Util.printarr(topKFrequent(nums, k), "Top " + k + " frequent elements found in O(nlogk)\n");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] resp = new int[k];
        HashMap<Integer, Integer> count_map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            if (count_map.containsKey(nums[i])) {
                count_map.put(nums[i], count_map.get(nums[i]) + 1);
            } else {
                count_map.put(nums[i], 1);
            }
        }
        
        Element[] elements = new Element[count_map.keySet().size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : count_map.entrySet()) {
            elements[i] = new Element(entry.getKey(), entry.getValue());
            i++;
        }
        
        // min heap of k elements
        PriorityQueue<Element> minheap = new PriorityQueue<Element>(new SortElementOnFrequency());
        
        i = 0;
        while(i < k) {
            minheap.offer(elements[i]);
            i++;
        }
        
        while(i < elements.length) {
            minheap.offer(elements[i]);
            minheap.poll();
            i++;
        }
        
        for (int j = k - 1; j >= 0; j--) {
            resp[j] = minheap.poll().val;
        }
        
        return resp;
    }
    
    public static class Element {
        public int val;
        public int freq;
        public Element(int v, int f) {
            val = v;
            freq = f;
        }
    }
    
    public static class SortElementOnFrequency implements Comparator<Element> {
        
        @Override
        public int compare(Element a, Element b) {
            return a.freq - b.freq;
        }
    }
}
