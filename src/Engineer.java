// Numan Salahuddin - 251264939
package BridgeBuilderAdv;

import java.util.Random; // Importing random utilities

public class Engineer { // Creating Engineer class
    // Adding two private variables
    private char token;
    private boolean hardMode;
 // Initializing token and setting the boolean to hard mode.
    public Engineer(boolean hardMode) {
        this.token = '0'; // Engineer's token
        this.hardMode = hardMode;
    }
    // Creating Difficulty level for game (HardMode and EasyMode) Depending on the difficulty.
    public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
        if (hardMode) {
            makeMoveHardMode(board, playerLastRow, playerLastCol);
        } else {
            makeMoveEasyMode(board);
        }
    }
    // Easy: We select a random position.
    private void makeMoveEasyMode(GameBoard board) {
        Random random = new Random();
        int size = board.getSize();
        int row, col;
        while (true) {
            row = random.nextInt(size);
            col = random.nextInt(size);
            if (board.isPositionEmpty(row, col)) {
                board.placeToken(row, col, token);
                break;
            }
        }
    }
    // Hard: Select empty position after the player's last position.
    // If the Row is full it will occupy the topmost empty position in the same column.
    private void makeMoveHardMode(GameBoard board, int playerLastRow, int playerLastCol) {
        int size = board.getSize();

        for (int col = playerLastCol; col < size; col++) {
            if (board.isPositionEmpty(playerLastRow, col)) {
                board.placeToken(playerLastRow, col, token);
                return;
            }
        }

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (board.isPositionEmpty(row, col)) {
                    board.placeToken(row, col, token);
                    return;
                }
            }
        }
    }

    public char getToken() {
        return token;
    }
}
