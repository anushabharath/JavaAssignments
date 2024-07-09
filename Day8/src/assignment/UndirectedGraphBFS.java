package assignment;

import java.util.*;

public class UndirectedGraphBFS {
    private final Map<Integer, List<Integer>> adjList;

    public UndirectedGraphBFS() {
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

    public void bfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphBFS graph = new UndirectedGraphBFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        System.out.print("BFS Traversal starting from node 1: ");
        graph.bfs(1); // Output: 1 2 3 4 5 6
    }
}
