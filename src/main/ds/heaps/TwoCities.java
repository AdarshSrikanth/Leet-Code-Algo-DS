package main.ds.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.Util;

public class TwoCities {
    public static void main(String[] args) {
        int[][] costs = new int[][]{ {10, 20}, {30, 200}, {400, 50}, {30, 20}};
        Util.println("Minimum cost to fly n candidates to cities A and B - " + twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        PriorityQueue<Candidate> candidates = new PriorityQueue<Candidate>(new SortCandidateDiffDescending());
        for (int i = 0; i < n; i++) {
            candidates.offer(new Candidate(costs[i][0], costs[i][1]));
        }
        int a_count = 0, b_count = 0, total = 0;
        while(!candidates.isEmpty() && a_count < n / 2 && b_count < n / 2) {
            Candidate c = candidates.poll();
            if (c.min_city == City.A) {
                total += c.cost_A;
                a_count++;
            } else {
                total += c.cost_B;
                b_count++;
            }
        }
        while(!candidates.isEmpty() && a_count < n / 2) {
            Candidate c = candidates.poll();
            total += c.cost_A;
            a_count++;
        }
        while(!candidates.isEmpty() && b_count < n / 2) {
            Candidate c = candidates.poll();
            total += c.cost_B;
            b_count++;
        }
        return total;
    }
    
    public static class Candidate {
        int cost_A;
        int cost_B;
        int diff;
        public City min_city;
        public Candidate(int a, int b) {
            cost_A = a;
            cost_B = b;
            min_city = Math.min(a, b) == a ? City.A : City.B;
            diff = Math.abs(a - b);
        }
    }
    
    public static class SortCandidateDiffDescending implements Comparator<Candidate> {
        
        @Override
        public int compare (Candidate a, Candidate b) {
            return b.diff - a.diff;
        }
    }
    
    public static enum City {
        A,
        B
    }
}
