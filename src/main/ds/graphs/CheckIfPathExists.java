package main.ds.graphs;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

import main.Util;

public class CheckIfPathExists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Util.println("Enter number of nodes");
        int n = Integer.parseInt(sc.next());
        // int[][] adjM = Util.getAdjacencyMatrix(sc);
        int[][] edges = Util.getEdgeList(sc);
        Util.println("Enter src and dest nodes");
        int src, dest;
        src = Integer.parseInt(sc.nextLine());
        dest = Integer.parseInt(sc.nextLine());
        Util.println("Path exists: " + validPath(n, edges, src, dest));
        sc.close();
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q = new LinkedList<Integer>();
        @SuppressWarnings("unchecked")
        HashSet<Integer>[] graph = new HashSet[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
		
        if(graph[source].contains(destination)){  // direct connection exists
            return true;
        }
        boolean[] visited = new boolean[n];
        // int[][] adjM = buildAdjacencyMatrix(edges, n);
        q.add(source);
        while (!q.isEmpty()) {
            int visited_node = q.remove();
            visited[visited_node] = true;
            if (visited_node == destination) {
                return true;
            }
            for (Integer adjN : graph[visited_node]) {
                if (!visited[adjN]) {
                    q.offer(adjN);
                }
            }
        }
        return false;
    }
}
