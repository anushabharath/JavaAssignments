package assignment;

import java.util.*;

public class UndirectedGraphDFS {
    private final Map<Integer, List<Integer>> adjList;

    public UndirectedGraphDFS() {
        adjList = new HashMap<>();
    }

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(int node1, int node2) {
        addNode(node1);
        addNode(node2);
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1); // since it's an undirected graph
    }

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startNode, visited);
    }

    private void dfsRecursive(int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphDFS graph = new UndirectedGraphDFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        System.out.print("DFS Traversal starting from node 1: ");
        graph.dfs(1); // Output: 1 2 4 5 3 6
    }
}

