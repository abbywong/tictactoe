
public class HumanPlayer implements Player {
    private final Shape shape;

    public HumanPlayer(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public int[] getMove(BoardViewer boardViewer) {
        // todo: ask player for a move to make (only allow if it's empty)
        return new int[] {0, 0};
    }
}
