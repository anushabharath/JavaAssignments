package assignment;

import java.util.*;

public class DirectedGraph {
    private final Map<Integer, List<Integer>> adjList;

    public DirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public boolean addEdge(int from, int to) {
        addNode(from);
        addNode(to);

        // Add the edge
        adjList.get(from).add(to);

        // Check for cycles
        if (hasCycle()) {
            // If a cycle is detected, remove the edge
            adjList.get(from).remove((Integer) to);
            return false;
        }

        return true;
    }

    private boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (dfs(node, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
            if (dfs(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        System.out.println(graph.addEdge(1, 2)); // true
        System.out.println(graph.addEdge(2, 3)); // true
        System.out.println(graph.addEdge(3, 4)); // true
        System.out.println(graph.addEdge(4, 1)); // false (creates a cycle)
    }
}