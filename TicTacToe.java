import java.util.Scanner;

public class TicTacToe {
    // 3x3 board
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X'; // Start with player 'X'

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        // Game loop
        for (int turn = 1; turn <= 9; turn++) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Validate move
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                turn--; // Repeat the turn
                continue;
            }

            // Make the move
            board[row][col] = currentPlayer;
            printBoard();

            // Check for a winner
            if (checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                return;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // If all turns are done and no winner
        System.out.println("It's a draw!");
    }

    // Method to print the board
    public static void printBoard() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
    }

    // Method to check if a player has won
    public static boolean checkWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; // Row
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true; // Column
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true; // Diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true; // Diagonal
        return false;
    }
}

