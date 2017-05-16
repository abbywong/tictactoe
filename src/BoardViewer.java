
/*
The aim of this class is to let players view the board, but not allow them
to make any changes, or they could cheat...
 */
// todo: do you think this is a safe way? smart?
public class BoardViewer {
    private final Board board;

    public BoardViewer(Board board) {
        this.board = board;
    }

    public Shape getSquare(int row, int col) {
        return this.board.getSquare(row, col);
    }

    public int getSize() {
        return this.board.getSize();
    }
}
