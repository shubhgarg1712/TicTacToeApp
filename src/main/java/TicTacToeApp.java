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
        
        int slot = getPlayerInput();
        System.out.println("You entered slot: " + slot);
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
}
