import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0286 {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    // BFS, Time Limit Exceeded
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == Integer.MAX_VALUE) {
                    rooms[i][j] = distanceToNearestGate(rooms, i, j);
                }
            }
        }
    }

    private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
        int rowLen = rooms.length;
        int colLen = rooms[0].length;
        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];

                    if (r < 0 || r > rowLen - 1 || c < 0 || c > colLen - 1
                            || rooms[r][c] == -1) {
                        continue;
                    }

                    if (rooms[r][c] == 0) {
                        return distance + 1;
                    }

                    queue.offer(new int[]{r, c});
                }
            }

            distance++;
        }

        return Integer.MAX_VALUE;
    }


    // BFS, starting from gates
    public void wallsAndGates1(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int rowLen = rooms.length;
        int colLen = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int r = cur[0] + direction[0];
                    int c = cur[1] + direction[1];

                    if (r < 0 || r > rowLen - 1 || c < 0 || c > colLen - 1 || rooms[r][c] != Integer.MAX_VALUE) {
                        continue;
                    }

                    rooms[r][c] = distance + 1;
                    queue.offer(new int[]{r, c});
                }
            }

            distance++;
        }
    }

    public static void main(String[] args) {
        LC0286 solution = new LC0286();

        solution.wallsAndGates(new int[][]{{2147483647,-1,0,2147483647}
                    ,{2147483647,2147483647,2147483647,-1}
                    ,{2147483647,-1,2147483647,-1}
                    ,{0,-1,2147483647,2147483647}});
    }
}
