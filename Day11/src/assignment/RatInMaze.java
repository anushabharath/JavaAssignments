package assignment;

public class RatInMaze {

    private static final int N = 6;

    // Function to print the solution
    private static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if x, y is valid index for N x N maze
    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Function that solves the maze using backtracking
    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        // if (x, y) is the goal, return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // Mark x, y as part of the solution path
            solution[x][y] = 1;

            // Move forward in the x direction
            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            // If moving in x direction doesn't give solution,
            // then move down in the y direction
            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            // If none of the above movements work, then
            // BACKTRACK: unmark x, y as part of the solution path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    // Function to solve the maze problem
    public static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(solution);
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
