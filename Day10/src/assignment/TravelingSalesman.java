package assignment;

public class TravelingSalesman {

    // Function to find the minimum cost to visit all cities and return to the starting city
    public static int FindMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1; // All cities visited

        // DP array to store the minimum cost
        int[][] dp = new int[1 << n][n];

        // Initialize DP array with a large value
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2; // Use a large value to prevent overflow
            }
        }

        // Starting point, the cost to start from the first city
        dp[1][0] = 0;

        // Iterate over all subsets of cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) { // If u is in the subset mask
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) { // If v is not in the subset mask
                            dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + graph[u][v]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to visit all cities and return to the starting city
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[VISITED_ALL][i] + graph[i][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + FindMinCost(graph));
    }
}
