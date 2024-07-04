package ufa;

import java.util.*;

// A class to store a graph edge
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the undirected graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
            adjList.get(edge.dest).add(edge.source);  // Adding the reverse edge for undirected graph
        }
    }
}

// A class to represent a disjoint set
class DisjointSet {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    // Perform MakeSet operation
    public void makeSet(int n) {
        // create `n` disjoint sets (one for each vertex)
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    // Find the root of the set in which element `k` belongs with path compression
    public int find(int k) {
        // if `k` is not the root
        if (parent.get(k) != k) {
            parent.put(k, find(parent.get(k)));  // path compression
        }
        return parent.get(k);
    }

    // Perform Union of two subsets with union by rank
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // Union by rank
            if (rank.get(rootA) > rank.get(rootB)) {
                parent.put(rootB, rootA);
            } else if (rank.get(rootA) < rank.get(rootB)) {
                parent.put(rootA, rootB);
            } else {
                parent.put(rootB, rootA);
                rank.put(rootA, rank.get(rootA) + 1);
            }
        }
    }
}

public class Main {
    // Returns true if the graph has a cycle
    public static boolean findCycle(Graph graph, int n) {
        // initialize `DisjointSet` class
        DisjointSet ds = new DisjointSet();

        // create a singleton set for each element of the universe
        ds.makeSet(n);

        // create a set to store visited edges
        Set<String> visitedEdges = new HashSet<>();

        // consider every edge (u, v)
        for (int u = 0; u < n; u++) {
            // Recur for all adjacent vertices
            for (int v : graph.adjList.get(u)) {
                // To avoid processing the reverse of the same edge, use a set to track edges
                String edge = u < v ? u + "-" + v : v + "-" + u;
                if (visitedEdges.contains(edge)) {
                    continue;
                }
                visitedEdges.add(edge);

                // find the root of the sets to which elements `u` and `v` belong
                int rootU = ds.find(u);
                int rootV = ds.find(v);

                // if both `u` and `v` have the same parent, the cycle is found
                if (rootU == rootV) {
                    return true;
                } else {
                    ds.union(rootU, rootV);
                }
            }
        }
        return false;
    }

    // Union–find algorithm for cycle detection in a graph
    public static void main(String[] args) {
        // List of graph edges
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 6), new Edge(0, 7),
                new Edge(1, 2), new Edge(1, 5), new Edge(2, 3),
                new Edge(2, 4), new Edge(7, 8), new Edge(7, 11),
                new Edge(8, 9), new Edge(8, 10), new Edge(10, 11)
                // edge (10, 11) introduces a cycle in the graph
        );

        // total number of nodes in the graph (labelled from 0 to 11)
        int n = 12;

        // construct graph
        Graph graph = new Graph(edges, n);

        // Check for cycle in the graph
        if (findCycle(graph, n)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}
