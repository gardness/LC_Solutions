import java.util.*;

public class LC1293 {
    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{-1, 0},
            new int[]{1, 0}
    };

    class Point {
        int r;
        int c;
        int dist;
        int obsts;

        Point(int r, int c, int obsts) {
            this.r = r;
            this.c = c;
            this.obsts = obsts;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid[0].length == 0) {
            return -1;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][][] visited = new boolean[rowLen][colLen][k + 1];
        Queue<Point> queue = new LinkedList<>();

        if (grid[0][0] == 1) {
            visited[0][0][1] = true;
            queue.offer(new Point(0, 0, 1));
        } else {
            visited[0][0][0] = true;
            queue.offer(new Point(0, 0, 0));
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                if (cur.r == rowLen - 1 && cur.c == colLen - 1) {
                    return steps;
                }

                for (int[] direction : DIRECTIONS) {
                    int r = cur.r + direction[0];
                    int c = cur.c + direction[1];
                    int obsts = cur.obsts;

                    if (r < 0 || r > rowLen - 1 || c < 0 || c > colLen - 1
                            || (grid[r][c] == 1 && ++obsts > k)
                            || visited[r][c][obsts] == true) {
                        continue;
                    }

                    Point tmp = new Point(r, c, obsts);

                    visited[r][c][obsts] = true;
                    queue.offer(tmp);
                }
            }

            steps++;
        }

        return -1;
    }


    public static void main(String[] args) {
        LC1293 solution = new LC1293();

        solution.shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, 1);
    }
}
