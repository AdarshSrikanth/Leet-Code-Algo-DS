package main.ds.heaps;

import main.Util;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class Rankings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = Util.get_input_array(sc);
        String[] resp = findRelativeRanks(score);
        Util.printarr(resp, "Rankings are:");
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] resp = new String[score.length];
        
        PriorityQueue<Scores> maxheap = new PriorityQueue<Scores>(new SortByScoreDescending());
        
        for (int i = 0; i < score.length; i++) {
            maxheap.offer(new Scores(i, score[i]));
        }
        
        int j = 1;
        while(!maxheap.isEmpty()) {
            Scores s = maxheap.poll();
            switch(j) {
                case 1: resp[s.index] = "Gold Medal"; break;
                case 2: resp[s.index] = "Silver Medal"; break;
                case 3: resp[s.index] = "Bronze Medal"; break;
                default: resp[s.index] = String.valueOf(j);
            }
            j++;
        }
        return resp;
    }
    
    public static class Scores {
        public int index;
        public int score;
        public Scores(int i, int s) {
            index = i;
            score = s;
        }
    }
    
    /**
     * Max Heap comparator to sort the class Scores in descending order of score
     * 
     */
    public static class SortByScoreDescending implements Comparator<Scores> {

        @Override
        public int compare(Scores a, Scores b)
        {
            return b.score - a.score;
        }
    }
    

    /**
     * Unused method. In-place max-heapify
     * O(n)
     * 
     * @param arr
     */
    public void maxHeapify(int[] arr) {
        int i = arr.length - 1;
        int root = 0;
        while(i > 1) {
            if (i % 2 == 0) {
                root = (i / 2) - 1;
            } else {
                root = i / 2;
            }
            if (arr[root] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[root];
                arr[root] = temp;
            }
            i--;
        }
        if (arr[0] < arr[1]) {
            int temp = arr[1];
            arr[1] = arr[0];
            arr[0] = temp;
        }
    }
}
