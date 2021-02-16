package ADT;

import java.util.*;

public class MyGraph {
    class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Node {
        int value;
        int weight;

        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    List<List<Node>> adjList = new ArrayList<>();

    MyGraph(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            adjList.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    public static void printGraph(MyGraph myGraph)  {
        int srcVertex = 0;
        int listSize = myGraph.adjList.size();

        System.out.println("The contents of the myGraph:");
        while (srcVertex < listSize) {
            //traverse through the adjacency list and print the edges
            for (Node edge : myGraph.adjList.get(srcVertex)) {
                System.out.print("Vertex:" + srcVertex + " ==> " + edge.value +
                        " (" + edge.weight + ")\t");
            }

            System.out.println();
            srcVertex++;
        }
    }
}
