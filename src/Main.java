import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player firstPlayer = new RandomPlayer(Shape.CIRCLE);
        Player secondPlayer = new RandomPlayer(Shape.CROSS);
        // todo: complete the human player
        // todo: add a smart computer player
        Player activePlayer;
        // Choose a random starting player
        if ((new Random()).nextInt(2) == 0) {
            System.out.println("Player one can start!");
            activePlayer = firstPlayer;
        } else {
            System.out.println("Player two can start!");
            activePlayer = secondPlayer;
        }
        int round = 0;
        while (true) {
            // %d means integer, \n means newline (enter)
            System.out.printf("round %d\n", round);
            board.showPlayingField();
            // Check if the game is still going

            if (board.hasWon(Shape.CIRCLE)) {
                System.out.println("Circle has won, congratulations!");
                return;
            }
            if (board.hasWon(Shape.CROSS)) {
                System.out.println("Cross has won, congratulations!");
                return;
            }
            else if ( ! board.hasEmptySquares()) {
                System.out.println("Game over! No winner...");
                return;
            }
            // Now to let the player make a move
            int[] pos = activePlayer.getMove(new BoardViewer(board));
            boolean isSuccessful = board.setSquare(pos[0], pos[1], activePlayer.getShape());
            if (! isSuccessful) {
                System.err.printf("This is not a valid position!");
                return;
            }
            // Switch to the other player's turn
            if (activePlayer == firstPlayer) {
                activePlayer = secondPlayer;
            }
            //else if (activePlayer == secondPlayer) {
            else { activePlayer = firstPlayer;
                // } else {
                //   throw new NotImplementedException();
            }
            round++;
        }
    }
}
