// Numan Salahuddin - 251264939
package BridgeBuilderAdv;

public class GameBoard { // Creating GameBoard Class with Two private variables.
    private char[][] board;
    private int size;

    public GameBoard(int size) {
        this.size = size; // Size of the GameBoard
        this.board = new char[size][size]; // Number of characters depending on the size of GameBoard.
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '.';  // 2D char array '.' representing empty positions on the GameBoard.
            }
        }
    }

    public void placeToken(int row, int col, char token) {
        board[row][col] = token;
    } // Places token on the specified column and row on the gameboard.


    public boolean isPositionEmpty(int row, int col) {
        return board[row][col] == '.';
    } // Checks if position is empty '.' or not.

    public int getSize() {
        return size;
    } // Returns the size of the GameBoard.
    // DisplayBoard prints the GameBoard rows and columns including the numbers and string characters.
    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    // CheckForWinDirection checks if the player has won in any direction or not via
    // left-to-right, diagonally, bottom-to-top.
    public int checkForWinDirection(Player player) {
        // Check left-to-right
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < size; col++) {
                if (board[row][col] == player.getToken()) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == size) {
                    return 1; // Left-to-right win
                }
            }
        }

        // Check bottom-to-top
        for (int col = 0; col < size; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
                if (board[row][col] == player.getToken()) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == size) {
                    return 2; // Bottom-to-top win
                }
            }
        }

        // Check diagonal
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == player.getToken()) {
                count++;
            } else {
                count = 0;
            }
            if (count == size) {
                return 3; // Diagonal win
            }
        }

        return 0; // No win
    }

    public boolean checkForTie() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '.') {
                    return false; // There is an empty position, so it is not a tie
                }
            }
        }
        return true; // The board is notEmpty therefore, it's a tie
    }
}
/**
 * The GameBoard class is designed to represent the Game Board for the Bridge Building Game.
 * It consists of a 2D character array '.' that represents the positions on the board.
 * Each position can be empty ('.') or is occupied by a token ('+') and ('0').
 * To initialize the board, the initializeBoard() method is called, which sets all positions to empty.
 * The placeToken() method allows tokens to be placed on the board at specific positions.
 * The displayBoard() method prints the board with row and column numbers.
 * The checkForWinDirection() method checks if the player has won in any direction: left-to-right, bottom-to-top, or diagonally.
 * It returns an interrelated value (1, 2, or 3) if there is a win, or 0 if there is no win.
 * The checkForTie() method checks if the game has ended in a tie.
 * This process is done by checking whether the board is empty or not. If it is not empty then it is a tie.
 * The code is basically a tic-tac-toe game which has been tested to give results of different and same scenarios.
 * This would include wins, losses, and ties.
 */
