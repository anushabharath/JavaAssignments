package assignment;

public class NQueenProblem {

    private static final int N = 8;

    // Function to print the solution
    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed on board[row][col]
    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve the N Queen problem using backtracking
    private static boolean solveNQueen(int[][] board, int col) {
        // Base case: If all queens are placed, return true
        if (col >= N) {
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, col)) {
                // Place the queen
                board[i][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQueen(board, col + 1)) {
                    return true;
                }

                // If placing the queen doesn't lead to a solution, remove the queen (backtrack)
                board[i][col] = 0;
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (!solveNQueen(board, 0)) {
            System.out.println("No solution exists");
        } else {
            printSolution(board);
        }
    }
}



