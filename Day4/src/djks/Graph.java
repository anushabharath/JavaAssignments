package djks;

import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private List<List<Node>> adjacencyList;

    // Node class representing a vertex and its weight
    static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    public Graph(int v) {
        this.V = v;
        adjacencyList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new Node(dest, weight)); // For directed graph
        adjacencyList.get(dest).add(new Node(src, weight)); // For undirected graph
    }

    // Dijkstra's algorithm to find the shortest path from source
    public void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.weight));
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;

            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.dest;
                int weight = neighbor.weight;

                // Relaxation step
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        // Print shortest distances from source
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " distance: " + distances[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 5, 2);

        graph.dijkstra(0);
    }
}
