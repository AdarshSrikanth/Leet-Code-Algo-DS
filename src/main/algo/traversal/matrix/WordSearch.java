package main.algo.traversal.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import main.Util;

public class WordSearch {
    public static void main(String[] args) {
        String[][] board = new String[][]{{"A","B","C","E"},
        {"S","F","E","S"},
        {"A","D","E","E"}};
        String word = "ABCESEEEFS";
        Util.println("Word found - " + exist(board, word));
    }

    public static boolean exist(String[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        char start = word.charAt(0);
        
        HashSet<Cell> startCells = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals(String.valueOf(start))) {
                    startCells.add(new Cell(i, j));
                }
            }
        }
        
        for (Cell startCell : startCells) {
            if (wordSearch(board, startCell, word)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * https://leetcode.com/problems/word-search
     * 
     * BFS works for basic cases. It does not for the current testcase.
     * DFS might be a better fit. Need to try out
     * 
     * @param board
     * @param start
     * @param word
     * @return
     */
    public static boolean wordSearch(String[][] board, Cell start, String word) {
        int m = board.length;
        int n = board[0].length;
        
        Queue<Cell> q = new LinkedList<Cell>();
        HashSet<Cell> visited = new HashSet<>();
        q.add(start);
        // visited.add(start);
        
        int index = 0;
        
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            int x = cell.x, y = cell.y;
            visited.add(cell);
            
            if (index == word.length() - 1) {
                return true;
            }
            else {
                int v_size = visited.size();
                Cell top = new Cell(x-1, y);
                Cell bottom = new Cell(x+1, y);
                Cell left = new Cell(x, y-1);
                Cell right = new Cell(x, y+1);
                if (x - 1 >= 0 && !visited.contains(top)) {
                    if (board[x-1][y].equals(String.valueOf(word.charAt(index + 1)))) {
                        q.offer(top);
                        // visited.add(top);
                    }                    
                }
                if (x + 1 < m && !visited.contains(bottom)) {
                    if (board[x+1][y].equals(String.valueOf(word.charAt(index + 1)))) {
                        q.offer(bottom);
                        // visited.add(bottom);
                    }
                }
                if (y - 1 >= 0 && !visited.contains(left)) {
                    if (board[x][y - 1].equals(String.valueOf(word.charAt(index + 1)))) {
                        q.offer(left);
                        // visited.add(left);
                    }
                }
                if (y + 1 < n && !visited.contains(right)) {
                    if (board[x][y + 1].equals(String.valueOf(word.charAt(index + 1)))) {
                        q.offer(right);
                        // visited.add(right);
                    }
                }
                if (visited.size() > v_size) {
                    index++;
                }
            }
        }
        return false;
    }
    
    static class Cell {
        public int x;
        public int y;
        
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell that = (Cell) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}