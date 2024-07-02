package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    private int v; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list

    // Constructor
    public BFS(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // Method to perform BFS traversal
    public void bfs(int start) {
        if (start < 0 || start >= v) {
            System.out.println("Invalid start node");
            return;
        }

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[v];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the start node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            // Dequeue a vertex from the queue and print it
            start = queue.poll();
            System.out.print(start + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            Iterator<Integer> iterator = adjList[start].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS graph = new BFS(4);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Perform BFS traversal starting from vertex 2
        System.out.println("BFS traversal starting from vertex 2:");
        graph.bfs(2);
    }
}
