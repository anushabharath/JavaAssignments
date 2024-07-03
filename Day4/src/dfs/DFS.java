package dfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public DFS(int v) {
        this.V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // DFS traversal from a given source 's'
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.println("Visiting node " + currentVertex);
                visited[currentVertex] = true;
            }

            // Get all adjacent vertices of the popped vertex currentVertex
            for (int adjacentVertex : adjacencyList[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    stack.push(adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(4, 5);

        System.out.println("Depth First Traversal starting from vertex 2:");
        graph.dfs(2);
    }
}
