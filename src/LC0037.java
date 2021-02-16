import java.util.*;

public class LC0037 {
    boolean solved = false;
    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] boxes = new HashSet[9];

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    placeNumber(board, num, i, j);
                }
            }
        }

        helper(board, 0, 0);

        return;
    }

    private void helper(char[][] board, int row, int col) {
        if (row == board.length) {
            solved = true;

            return;
        }

        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
                if (isValid(board, i, row, col)) {
                    placeNumber(board, i, row, col);
                    placeNextNumbers(board, row, col);

                    if (!solved) {
                        removeNumber(board, row, col);
                    } else {
                        return;
                    }
                }
            }
        } else {
            placeNextNumbers(board, row, col);
        }

        return;
    }

    private void removeNumber(char[][] board, int row, int col) {
        Character c = board[row][col];
        int boxIdx = (row / 3) * 3 + col / 3;

        board[row][col] = '.';
        rows[row].remove(c);
        cols[col].remove(c);
        boxes[boxIdx].remove(c);
    }

    private void placeNumber(char[][] board, int num, int row, int col) {
        Character c = (char)(num + '0');
        int boxIdx = (row / 3) * 3 + col / 3;

        board[row][col] = c;
        rows[row].add(c);
        cols[col].add(c);
        boxes[boxIdx].add(c);
    }

    private void placeNextNumbers(char[][] board, int row, int col) {
//        if (row == board.length - 1 && col == board[0].length - 1) {
//            solved = true;
//
//            return;
//        }

        if (col == board[0].length - 1) {
            helper(board, row + 1, 0);
        } else {
            helper(board, row, col + 1);
        }
    }

    private boolean isValid(char[][] board, int num, int row, int col) {
        Character c = (char) (num + '0');
        int boxIdx = (row / 3) * 3 + col / 3;

        if (rows[row].contains(c) || cols[col].contains(c) || boxes[boxIdx].contains(c)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LC0037 solution = new LC0037();

        solution.solveSudoku(new char[][]{{'5', '3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});
    }
}
