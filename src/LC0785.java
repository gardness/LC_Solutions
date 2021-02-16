import java.util.*;

public class LC0785 {
    // DFS
    // Time Complexity : O(V + E)
    // Space Complexity : O(V)
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return true;
        }

        int[] color = new int[graph.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(color, 0);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }

            color[i] = 1;
            stack.push(i);

            while (!stack.isEmpty()) {
                int cur = stack.pop();

                for (int nei : graph[cur]) {
                    if (color[nei] == color[cur]) {
                        return false;
                    } else if (color[nei] == 0) {
                        color[nei] = -color[cur];
                        stack.push(nei);
                    }
                }
            }
        }

        return true;
    }


    // BFS
    // Time Complexity : O(V + E)
    // Space Complexity : O(V)
    public boolean isBipartite1(int[][] graph) {
        if (graph == null) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }

            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int j = 0 ; j < queue.size(); j++) {
                    int cur = queue.poll();

                    for (int tmp : graph[cur]) {
                        if (color[tmp] == color[cur]) {
                            return false;
                        } else if (color[tmp] == 0) {
                            color[tmp] = -color[cur];
                            queue.offer(tmp);
                        }
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        LC0785 solution = new LC0785();

        solution.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }
}
