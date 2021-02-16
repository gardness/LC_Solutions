import java.util.*;

public class LC0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            throw new IllegalArgumentException();
        }

        int rowLen = triangle.size();
        int colLen = triangle.get(rowLen - 1).size();
        Integer[][] cache = new Integer[rowLen + 1][colLen];

        return dfs1(triangle, cache, 0, 0);
    }

    private int dfs1(List<List<Integer>> triangle, Integer[][] cache, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }

        Integer left = cache[row + 1][col];
        Integer right = cache[row + 1][col + 1];

        if (left == null) {
            left = dfs1(triangle, cache, row + 1, col);
        }

        if (right == null) {
            right = dfs1(triangle, cache, row + 1, col + 1);
        }

        cache[row][col] = Math.min(left, right) + triangle.get(row).get(col);

        return cache[row][col];
    }
}
