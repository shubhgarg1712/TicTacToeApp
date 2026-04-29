import java.util.Random;
import java.util.Scanner;

public class TicTacToeApp {
    private static char[][] board = new char[3][3];
    private static char currentPlayerSymbol;
    private static char player1Symbol;
    private static char player2Symbol;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        performToss();
        printBoard();
        
        while (true) {
            int slot;
            if (currentPlayerSymbol == player1Symbol) {
                slot = getPlayerInput();
            } else {
                slot = getComputerMove();
                System.out.println("Computer chose slot: " + slot);
            }

            int[] indices = convertSlotToIndices(slot);
            int row = indices[0];
            int col = indices[1];
            
            if (isValidMove(row, col)) {
                System.out.println("Move accepted!");
                updateBoard(row, col, currentPlayerSymbol);
                printBoard();

                if (checkWin(currentPlayerSymbol)) {
                    System.out.println("Player " + currentPlayerSymbol + " wins!");
                    break;
                }

                if (checkDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }

                switchTurn();
            } else {
                System.out.println("Invalid move. The cell is either out of bounds or already occupied.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void performToss() {
        Random rand = new Random();
        int toss = rand.nextInt(2);
        
        if (toss == 0) {
            System.out.println("Player 1 wins the toss and starts first!");
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayerSymbol = 'X';
        } else {
            System.out.println("Player 2 wins the toss and starts first!");
            player2Symbol = 'X';
            player1Symbol = 'O';
            currentPlayerSymbol = 'X';
        }
    }

    private static int getPlayerInput() {
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    private static int[] convertSlotToIndices(int slot) {
        int index = slot - 1; 
        int row = index / 3;
        int col = index % 3;
        return new int[]{row, col};
    }

    private static boolean isValidMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return board[row][col] == '-';
        }
        return false;
    }

    private static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    private static int getComputerMove() {
        Random rand = new Random();
        int slot;
        int[] indices;
        do {
            slot = rand.nextInt(9) + 1;
            indices = convertSlotToIndices(slot);
        } while (!isValidMove(indices[0], indices[1]));
        return slot;
    }

    private static void switchTurn() {
        if (currentPlayerSymbol == 'X') {
            currentPlayerSymbol = 'O';
        } else {
            currentPlayerSymbol = 'X';
        }
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
