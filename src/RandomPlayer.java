import java.util.Random;

public class RandomPlayer implements Player {
    private final Shape shape;
    private Random rand = new Random();

    public RandomPlayer(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public int[] getMove(BoardViewer boardViewer) {
        int max = boardViewer.getSize();
        int[] pos = new int[2];
        pos[0] = this.rand.nextInt(max);
        pos[1] = this.rand.nextInt(max);
        while (boardViewer.getSquare(pos[0], pos[1]) != Shape.EMPTY) {
            pos[0] = this.rand.nextInt(max);
            pos[1] = this.rand.nextInt(max);
        }
        return pos;
    }
}
