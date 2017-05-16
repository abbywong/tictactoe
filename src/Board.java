import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int SIZE = 3;
    private List<List<Shape>> data = null;
    private int movesMade = 0;

    public Board() {
        // Create an empty list to contain the board data
        data = new ArrayList<>(3);
        for (int k = 0; k < SIZE; k++) {
            // For each row (SIZE times)...
            List<Shape> row = new ArrayList<>(3);
            // Fill the row with SIZE empty squares
            for (int n = 0; n < SIZE; n++) {
                row.add(n, Shape.EMPTY);
            }
            // Now add the row to the board
            data.add(k, row);
        }
        // Now `data` is a list of 3 lists, each with 3 Empty values
        // so in total a 3x3 game board!
    }

    public boolean setSquare(int row, int col, Shape shape) {
        if (this.getSquare(row, col) != Shape.EMPTY) {
            return false;
        }
        // todo: difficult: why use get and set here?
        this.data.get(row).set(col, shape);
        movesMade++;
        return true;
    }

    public Shape getSquare(int row, int col) {
        return this.data.get(row).get(col);
    }

    public int getSize() {
        return this.SIZE;
    }

    public boolean hasEmptySquares() {
        if (movesMade == SIZE*SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasCircleWon() {
        return false; // todo
    }

    public boolean hasSquareWon() {
        return false; // todo
    }

    public void showPlayingField() {
        // todo: make it more pretty
        for (int k = 0; k < SIZE; k++) {
            for (int n = 0; n < SIZE; n++) {
                System.out.print(this.data.get(k).get(n).shape + " ");
            }
            System.out.println("");
        }
    }
}
