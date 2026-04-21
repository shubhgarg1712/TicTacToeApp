import java.util.Random;

public class TicTacToeApp {
    private static char[][] board = new char[3][3];
    private static char currentPlayerSymbol;
    private static char player1Symbol;
    private static char player2Symbol;

    public static void main(String[] args) {
        initializeBoard();
        performToss();
        printBoard();
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
        int toss = rand.nextInt(2); // Generates 0 or 1
        
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
}
