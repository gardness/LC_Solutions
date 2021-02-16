import java.util.*;

public class LC0743 {
    HashMap<Integer, Integer> dist;

    // DFS, directed
    // Time Complexity : O(V^V + ElogE)
    // Space Complexity : O(V + E)
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        // create graph
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new LinkedList<>());
            }

            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        // sort edges by weight
        for (int node : graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }

        // initialize dist map
        dist = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(graph, K, 0);

        // output the result
        int max = 0;

        for (int tmp : dist.values()) {
            if (tmp == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, tmp);
        }

        return max;
    }


    private void dfs(HashMap<Integer, List<int[]>> graph, int node, int elapsed) {
        // cc
        if (elapsed >= dist.get(node)) {
            return;
        }

        dist.put(node, elapsed);

        // all end nodes are not in the graph
        if (graph.containsKey(node)) {
            for (int[] cur : graph.get(node)) {
                dfs(graph, cur[1], elapsed + cur[0]);
            }
        }
    }


    // Dijkstra, directed, without heap, O(n^2) implementation
    // Time Complexity : O(E + V ^ 2)
    // Space Complexity : O(V + E)
    public int networkDelayTime1(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        dist = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dist.put(K, 0);

        boolean[] visited = new boolean[N + 1];

        while (true) {
            int candNode = -1;
            int candWeight = Integer.MAX_VALUE;

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && dist.get(i) < candWeight) {
                    candNode = i;
                    candWeight = dist.get(i);
                }
            }

            if (candNode == -1) {
                break;
            }

            visited[candNode] = true;

            if (graph.containsKey(candNode)) {
                for (int[] neighbor : graph.get(candNode)) {
                    dist.put(neighbor[1], Math.min(dist.get(neighbor[1]), neighbor[0] + dist.get(candNode)));
                }
            }
        }

        int max = 0;

        for (int tmp : dist.values()) {
            if (tmp == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, tmp);
        }

        return max;
    }


    // Dijkstra, directed, with heap, O(nlogn) implementation
    // Time Complexity : O(E * log V), see https://stackoverflow.com/questions/26547816/understanding-time-complexity-calculation-for-dijkstra-algorithm
    // Space Complexity : O(V + E)
    public int networkDelayTime2(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        heap.offer(new int[]{0, K});

        dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0];
            int node = info[1];

            if (dist.containsKey(node)) {
                continue;
            }

            dist.put(node, d);

            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    if (!dist.containsKey(edge[1])) {
                        heap.offer(new int[]{d + edge[0], edge[1]});
                    }
                }
            }
        }

        if (dist.size() != N) {
            return -1;
        }

        int max = 0;

        for (int weight : dist.values()) {
            max = Math.max(max, weight);
        }

        return max;
    }
}
