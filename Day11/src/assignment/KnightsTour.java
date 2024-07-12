package assignment;

public class KnightsTour {
    private static final int N = 8;

    // Possible moves for the knight
    private static final int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

    // Function to check if the position is valid
    private static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Function to print the board
    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to solve the Knight's Tour problem
    private static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount) {
        int nextX, nextY;
        if (moveCount == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Initialize the board with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Starting position of the knight
        int startX = 0;
        int startY = 0;

        // The knight starts at the first position
        board[startX][startY] = 0;

        if (solveKnightsTour(board, startX, startY, 1)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
