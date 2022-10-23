package main.ds.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.Util;

public class ClosestPoints {
    public static void main(String[] args) {
        int[][] points=  new int[][]{{1,3},{-2,2}};
        int k = 1;
        int[][] res = kClosest(points, k);
        for (int i = 0; i < res.length; i++) {
            Util.println("(" + res[i][0] + "," + res[i][1] + ")");
        }
        return;
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>((Point a, Point b)-> {return a.dist_from_origin > b.dist_from_origin ? 1 : -1;});
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(new Point(points[i][0], points[i][1]));
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = minHeap.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
    
    static class Point {
        int x;
        int y;
        double dist_from_origin;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist_from_origin = Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - y, 2));
        }
    }
    
    static class SortPointsAscending implements Comparator<Point> {
        @Override
        public int compare (Point a, Point b) {
            return (int) (a.dist_from_origin - b.dist_from_origin);
        }
    }
}
