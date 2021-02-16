import java.util.*;

public class LC0052 {
    int cnt = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }

        helper(n, 0, new LinkedList<>());

        return cnt;
    }

    private void helper(int n, int row, List<Integer> res) {
        if (row == n) {
            cnt++;

            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(n, i, res)) {
                res.add(i);
                helper(n, row + 1, res);
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean isValid(int n, int col, List<Integer> res) {
        boolean[] cols = new boolean[n];
        boolean[] hills = new boolean[2 * n - 1];
        boolean[] dales = new boolean[2 * n - 1];

        res.add(col);

        for (int i = 0; i < res.size(); i++) {
            int j = res.get(i);

            if (cols[j] || hills[i + j] || dales[-i + j + n - 1]) {
                res.remove(res.size() - 1);

                return false;
            }

            cols[j] = true;
            hills[i + j] = true;
            dales[-i + j + n - 1] = true;
        }

        res.remove(res.size() - 1);

        return true;
    }
}
