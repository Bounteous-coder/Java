// Numan Salahuddin - 251264939
package BridgeBuilderAdv;

public class Player { // Creating a Player Class with two private variables.
    private char token;
    private int score;

    public Player() {
        this.token = '+'; // Player's token
        this.score = 0;   // Player's Score
    }

    public void makeMove(GameBoard board, int row, int col) {
        board.placeToken(row, col, token);
    }
    // Player's token gets placed on a specified column and row on the gameboard.

    public char getToken() {
        return token;
    }
    // Returns the Player's token

    public int getScore() {
        return score;
    }
    // Returns the Player's current score.

    public void addScore(int increment) {
        score += increment;
    }
    // Increasing the Player's score by a specified increment.
}
