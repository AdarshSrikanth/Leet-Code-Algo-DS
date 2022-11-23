package main.ds.hashset;

import java.util.HashSet;

import main.Util;

public class VerifySudoku {
    public static void main(String[] args) {
        String[][] sudoku = new String[][]{{"8","3",".",".","7",".",".",".","."}
        ,{"6",".",".","1","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","6","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".","6",".",".",".",".","2","8","."}
        ,{".",".",".","4","1","9",".",".","5"}
        ,{".",".",".",".","8",".",".","7","9"}};
        Util.println("Is valid Sudoku: " + isValidSudoku(sudoku));
    }

    public static boolean isValidSudoku(String[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!(board[i][j].equals("."))) {
                    if (!set.add(Integer.parseInt(board[i][j]))) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (!(board[i][j].equals("."))) {
                    if (!set.add(Integer.parseInt(board[j][i]))) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        int r = 0, c = 0;
        for (int k = 0; k < 9; k++) {
            if (c >= 9) {
                c = 0;
                r += 3;
            }
            if (r >= 9) {
                break;
            }
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (!(board[i][j].equals("."))) {
                        if (!set.add(Integer.parseInt(board[i][j]))) {
                            return false;
                        }
                    }
                }
            }
            set.clear();
            c += 3;
        }
        return true;
    }
}
