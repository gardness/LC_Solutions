package ADT;
import java.util.*;


// Written by zDong1995
public class Dijkstra {
    private static class Entry {
        String vertex;
        int distance; // distance from source to vertex

        public Entry(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static Map<String, Integer> dijkstra(Graph graph) {
        // assumption: source is valid
        Map<String, Integer> settleVertices = new HashMap<>(); // settled vertices and shortest distance
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((Entry e1, Entry e2) -> e1.distance - e2.distance);
        // 1. Add source node to the heap
        String source = graph.source.vertex;
        minHeap.offer(new Entry(source, 0));
        while (!minHeap.isEmpty()) { // OR (settleVertices.size() != graph.numVertices)
            // 2. Extract-min from the heap
            Entry cur = minHeap.poll();
            if (settleVertices.containsKey(cur.vertex)) {
                continue;
            }
            // 3. Mark the Node as visited and update the shortest distance
            settleVertices.put(cur.vertex, cur.distance);
            // 4. Update the distance to source for all the neighbors
            for (Graph.Node neighbor : graph.getNeighbors(cur.vertex)) {
                // 5. Skip already settled nodes
                if (settleVertices.containsKey(neighbor.vertex)) {
                    continue;
                }
                int neiDistance = neighbor.cost + cur.distance;
                // 6. Add new node with updated distance into heap to update order
                minHeap.offer(new Entry(neighbor.vertex, neiDistance));
            }
        }
        return settleVertices;
    }

    public static void main(String[] args) {
        // build graph
        String connections = "A-B:7, A-C:9, B-C:10, B-D:15, C-D:11, C-F:2, D-E:6, E-F:9, F-A:14";
        String source = "A";
        Graph graph = new Graph(source, 6, connections);
        System.out.println(graph);
        Map<String, Integer> distances = dijkstra(graph);

        for (Map.Entry<String, Integer> entry: distances.entrySet()) {
            System.out.printf("Shortest path from %s to %s is %d\n", source, entry.getKey(), entry.getValue());
        }
    }
}