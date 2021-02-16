import java.util.*;

public class LC0051 {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }

        List<List<String>> res = new LinkedList<>();

        helper(n, new LinkedList<>(), 0, 0, res);

        return res;
    }

    private void helper(int n, List<String> list, int row, int col, List<List<String>> res) {
        if (row == n) {
            List<String> tmp = new LinkedList<>();

            for (String s : list) {
                tmp.add(s);
            }

            res.add(tmp);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append('.');
        }

        for (int i = 0; i < n; i++) {
            if (isValid(n, list, row, i)) {
                sb.setCharAt(i, 'Q');
                list.add(sb.toString());
                helper(n, list, row + 1, col + 1, res);
                sb.setCharAt(i, '.');
                list.remove(list.size() - 1);
            }
        }
    }

    // 3 arrays
    private boolean isValid(int n, List<String> list, int row, int col) {
        boolean[] up = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        boolean[] rightDiagonal = new boolean[2 * n - 1];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i).charAt(j) == 'Q') {
                    if (up[j] || leftDiagonal[-i + j + n - 1] || rightDiagonal[i + j]) {
                        return false;
                    }

                    up[j] = true;
                    leftDiagonal[-i + j + n - 1] = true;
                    rightDiagonal[i + j] = true;
                }
            }
        }

        if (up[col] || leftDiagonal[-row + col + n - 1] || rightDiagonal[row + col]) {
            return false;
        }

        return true;
    }

    // Math
    private boolean isValid1(int n, List<String> list, int row, int col) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i).charAt(j) == 'Q' && (col == j || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC0051 solution = new LC0051();

        solution.solveNQueens(4);
    }
}
