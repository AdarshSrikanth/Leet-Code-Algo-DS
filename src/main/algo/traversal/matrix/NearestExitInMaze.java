package main.algo.traversal.matrix;

import java.util.LinkedList;
import java.util.Queue;

import main.Util;

public class NearestExitInMaze {
    public static void main (String[] args) {
        NearestExitInMaze obj = new NearestExitInMaze();
        char[][] maze = new char[][] {{'+', '.', '+'}, {'.','.','.'}, {'+','.','+'}};
        int[] entrance = new int[]{1, 2};
        Util.println("Nearest exit: " + obj.nearestExit(maze, entrance));
    }

    /**
     * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
     * 
     * Time complexity: O (m + n)
     * 
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        // BFS finds the shortest path from start node to target node.
        // On using DFS, all possible paths have to be backtracked to find the shortest path length.

        Queue<Cell> q = new LinkedList<Cell>();
        int currSteps = 0;
        q.offer(new Cell(entrance[0], entrance[1]));
        while (!q.isEmpty()) {
            int n = q.size();
            
            for(int i = 0; i < n; i++) {
                Cell c = q.poll();
                if (!(c.x == entrance[0] && c.y == entrance[1])) {
                    if (c.x == 0 || c.x == maze.length - 1 || c.y == 0 || c.y == maze[0].length - 1) {
                        // edge cell
                        return currSteps;
                    }
                }

                // Add Cell's neighbours to queue

                // Once added to the queue, mark the cell visited immediately.
                // Otherwise, it could lead to cell getting added to the queue twice.

                // up
                if (c.x - 1 >= 0 && maze[c.x - 1][c.y] == '.') {
                    q.offer(new Cell(c.x - 1, c.y));
                    maze[c.x - 1][c.y] = 'v';
                }

                // down
                if (c.x + 1 < maze.length && maze[c.x + 1][c.y] == '.') {
                    q.offer(new Cell(c.x + 1, c.y));
                    maze[c.x + 1][c.y] = 'v';
                }

                // left
                if (c.y - 1 >= 0 && maze[c.x][c.y - 1] == '.') {
                    q.offer(new Cell(c.x, c.y - 1));
                    maze[c.x][c.y - 1] = 'v';
                }

                // right
                if (c.y + 1 < maze[0].length && maze[c.x][c.y + 1] == '.') {
                    q.offer(new Cell(c.x, c.y + 1));
                    maze[c.x][c.y + 1] = 'v';
                }
                
                maze[c.x][c.y] = 'v';
            }
            currSteps++;
        }
        
        return -1;
    }
    
    class Cell {
        public int x;
        public int y;
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
