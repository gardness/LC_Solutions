package ADT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use HashMap to optimize Adjacency List as <Vertex, Node list>
 * Vertex "A" -> Node("B", 1), Node("C", 2)
 * Representation:
 * A -- 1 --> B
 *  \-- 2 --> C
 */

class Graph {
    Map<String, List<Node>> adjacencyList;
    int numVertices;
    Node source;

    public Graph(int numVertices, Node source) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        this.source = source;
    }

    public static class Node {
        String vertex;
        int cost;

        public Node(String vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public Graph(String source, int numVertices, String connections) {
        this(numVertices, new Node(source, 0)); // invoke constructor must in the first line
        String[] edges = connections.split(", ");

        for (String edge : edges) { // edge example: "A-B:1"
            try {
                String[] parts = edge.split(":");
                int cost = Integer.parseInt(parts[1]);
                String[] vertices = parts[0].split("-");
                // first direction
                adjacencyList.putIfAbsent(vertices[0], new ArrayList<>());
                adjacencyList.get(vertices[0]).add(new Node(vertices[1], cost));
                // second direction
                adjacencyList.putIfAbsent(vertices[1], new ArrayList<>());
                adjacencyList.get(vertices[1]).add(new Node(vertices[0], cost));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Node> getNeighbors(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return adjacencyList.get(vertex);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, List<Node>> entry : adjacencyList.entrySet()) {
            res.append(entry.getKey()).append(": ");
            for (Node node : entry.getValue()) {
                res.append(node.vertex).append("(").append(node.cost).append("), ");
            }
            res.delete(res.length() - 2, res.length());
            res.append("\n");
        }
        return res.toString();
    }
}
