public class Coordinate {
    private int x;
    private int y;
    
    private boolean pieceHere;

    Coordinate(int x, int y, boolean pieceHere) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean isPieceHere() {
        return pieceHere;
    }
}
