package main.ds.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.Util;

public class StoneGame {
    public static void main(String[] args) {
        int[] stones = Util.get_input_array(Util.getScanner());
        Util.println("Last Stone Weight - " + lastStoneWeight(stones));
    }
    
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((Integer i1, Integer i2)-> {return i2 - i1;});
        
        for (int i = 0; i < stones.length; i++) {
            minHeap.offer(stones[i]);
        }
        
        while(minHeap.size() > 1) {
            Integer x = minHeap.poll();
            Integer y = minHeap.poll();
            if (x != y) {
                minHeap.offer(Math.abs(x - y));
            }
        }
        
        return minHeap.size() == 1 ? minHeap.poll() : 0;
    }

    static class SortDescending implements Comparator<Integer> {
        
        @Override
        public int compare (Integer a, Integer b) {
            return b - a;
        }
    }
}
