package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<>());
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        if (!adjList.containsKey(source)) {
            System.out.println("Source vertex " + source + " does not exist.");
            return;
        }
        if (!adjList.containsKey(destination)) {
            System.out.println("Destination vertex " + destination + " does not exist.");
            return;
        }

        adjList.get(source).add(destination);
        
        // Uncomment the following line if the graph is undirected
        adjList.get(destination).add(source);
    }

    // Method to display the graph
    public void display() {
        for (int vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ": ");
            for (int edge : adjList.get(vertex)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding vertices to the graph
        graph.addVertex(11);
        graph.addVertex(12);
        graph.addVertex(13);
        graph.addVertex(14);

        // Adding edges to the graph
        graph.addEdge(11, 12);
        graph.addEdge(11, 13);
        graph.addEdge(12, 13);

        // Displaying the graph
        graph.display();
    }
}
