import java.util.Scanner;
import java.util.Random;

public class TicTacToeAI {
    private char[][] board;
    private char player;
    private char ai;
    private Random random;

    public TicTacToeAI() {
        board = new char[3][3];
        player = 'X';
        ai = 'O';
random = new Random();
    }

    public void startGame() {
        initializeBoard();
        while (true) {
            playerTurn();
            if (hasWon(player)) {
                System.out.println("Player wins!");
                break;
            }
            aiTurn();
            if (hasWon(ai)) {
                System.out.println("AI wins!");
                break;
            }
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
}

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column (1-3):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        board[row - 1][col - 1] = player;
    }

    private void aiTurn() {
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        while (board[row][col] != ' ') {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }
        board[row][col] = ai;
    }

private boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToeAI game = new TicTacToeAI();
 game.startGame();
    }
}
