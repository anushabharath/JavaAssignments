package ksk;

import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        
        int[][] edges = new int[5][3];
        
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 10;
      
        edges[1][0] = 1;
        edges[1][1] = 2;
        edges[1][2] = 9;
      
        edges[2][0] = 2;
        edges[2][1] = 4;
        edges[2][2] = 2;
      
        edges[3][0] = 4;
        edges[3][1] = 3;
        edges[3][2] = 5;
 
        edges[4][0] = 3;
        edges[4][1] = 2;
        edges[4][2] = 3;
      
        int ans = KruskalAlgo(5, edges);
        System.out.println("The min cost is");
        System.out.println(ans);
      
    }

    static int[] parent;
    static int[] rank;
    
    // creating a class of Pair to maintain it in an array 
    public static class Pair implements Comparable<Pair> {
         
        int vertex1;
        int vertex2;
        int weight;

        Pair(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            // comparing the edges by their weights.
            return this.weight - o.weight;
        }
    }

    public static int KruskalAlgo(int n, int[][] edge) {
        System.out.print("Minimum Spanning Tree is :-");
        System.out.println();
        System.out.println("V1" + " V2" + " Wt");
        
        // 1. to store the edges in sorted order.
        // array of all the edges containing pair of vertices and weight given to that edge.
        Pair[] edges = new Pair[edge.length];
      
        // inserting all the pairs of vertices and their respective weights in 'edges'.
        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edge[i][0];
            int vertex2 = edge[i][1];
            int weight = edge[i][2];
            edges[i] = new Pair(vertex1, vertex2, weight);
        }

        int ans = 0;
        Arrays.sort(edges);
      
        parent = new int[n + 1];
        rank = new int[n + 1];
      
        // assigning each element as a unique group and assigning rank 1 to them.
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int vertex1 = edges[i].vertex1;
            int vertex2 = edges[i].vertex2;
            int weight = edges[i].weight;
        
            // checking if the vertices belong to the same group or not.
            boolean flag = union(vertex1, vertex2);
        
            // if vertices are from unique groups that implies, if both vertices would be connected, it won't create a loop.
            if (flag == false) {
                System.out.println(vertex1 + "  " + vertex2 + "  " + weight);
                ans += weight;
            }
        }
      
        return ans;
    }

    public static int find(int component) {
        // if the component which is a leader already is returned.
        if (parent[component] == component) {
            return component;
        }
      
        // finding the parent or group leader of that element
        int temp = find(parent[component]);
        parent[component] = temp;
        return temp;
    }

    public static boolean union(int vertex1, int vertex2) {
        // finding the parent or group leader of both of these vertices.
        int parentOfVertex1 = find(vertex1);
        int parentOfVertex2 = find(vertex2);
      
        // if parent or leader of both vertices is the same, this implies, that if they get connected, it would create a loop
        if (parentOfVertex1 == parentOfVertex2) {
            return true;
        }
      
        // deciding the parent of the vertex according to their ranks.
        if (rank[parentOfVertex1] > rank[parentOfVertex2]) {
            parent[parentOfVertex2] = parentOfVertex1;
        } else if (rank[parentOfVertex1] < rank[parentOfVertex2]) {
            parent[parentOfVertex1] = parentOfVertex2;
        } else {
            parent[parentOfVertex1] = parentOfVertex2;
            rank[parentOfVertex2]++;
        }
      
        return false;
    }
}
