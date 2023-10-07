package chessGame;

public class Coordinate {
    private int x;
    private int y;
    
    private boolean pieceHere;

    public Coordinate(int x, int y, boolean pieceHere) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setPieceHere(boolean pieceHere) {
        this.pieceHere = pieceHere;
    }

    public boolean isPieceHere() {
        return pieceHere;
    }
}
