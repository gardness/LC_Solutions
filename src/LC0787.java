import java.util.*;

public class LC0787 {
    class City {
        public int dst;
        public int price;
        public int stop;

        City(int dst, int price, int stop) {
            this.dst = dst;
            this.price = price;
            this.stop = stop;
        }
    }

    // A slight variation of Dijkstra
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0) {
            return -1;
        }

        List<int[]>[] graph = new ArrayList[n];

        for (int[] edge : flights) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }

            graph[edge[0]].add(new int[]{edge[2], edge[1]});
        }

        PriorityQueue<City> heap = new PriorityQueue<>((a, b) -> a.price - b.price);

        heap.offer(new City(src, 0, 0));

        while (!heap.isEmpty()) {
            City cur = heap.poll();

            if (cur.dst == dst) {
                return cur.price;
            }

            if (cur.stop > K) {
                continue;
            }

            if (graph[cur.dst] != null) {
                for (int[] nei : graph[cur.dst]) {
                    heap.offer(new City(nei[1], cur.price + nei[0], cur.stop + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }


    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    } else if (stops < currentStops[nei]) {

                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        currentStops[nei] = stops;
                    }
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }


    public static void main(String[] args) {
        LC0787 solution = new LC0787();

        solution.findCheapestPrice(5
                , new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}},
                0, 2, 2);
    }
}
