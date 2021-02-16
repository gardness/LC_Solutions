import java.util.HashSet;
import java.util.PriorityQueue;

public class LC0378 {
    class Point {
        int value;
        int r;
        int c;

        Point(int value, int r, int c) {
            this.value = value;
            this.r = r;
            this.c = c;
        }

        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point tmp = (Point) o;

                return this.r == tmp.r && this.c == tmp.c;
            }

            return false;
        }

        public int hashCode() {
            return r * 10 + c;
        }
    }


    // Deduplicate by overriding equals() & hasCode()
    // Time Complexity : O(klog(min(k, m + n - 1)))
    // Space Complexity : O(n)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> a.value - b.value);
        HashSet<Point> visited = new HashSet<>();

        Point start = new Point(matrix[0][0], 0, 0);
        heap.offer(start);
        visited.add(start);

        while (--k > 0) {
            Point tmp = heap.poll();

            if (tmp.c + 1 < matrix[0].length) {
                Point p = new Point(matrix[tmp.r][tmp.c + 1], tmp.r, tmp.c + 1);

                if (!visited.contains(p)) {
                    heap.offer(p);
                    visited.add(p);
                }
            }

            if (tmp.r + 1 < matrix.length) {
                Point p = new Point(matrix[tmp.r + 1][tmp.c], tmp.r + 1, tmp.c);

                if (!visited.contains(p)) {
                    heap.offer(p);
                    visited.add(p);
                }
            }
        }

        return heap.poll().value;
    }


    public static void main(String[] args) {
        LC0378 solution = new LC0378();

        solution.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8);
    }
}
