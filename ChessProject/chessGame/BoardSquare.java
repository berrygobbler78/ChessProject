package chessGame;

import chessGame.exceptions.InvalidPieceColorException;
import chessGame.pieces.Piece;

public class BoardSquare {
    private int coordX;
    private int coordY;

    private String square;

    private boolean whitePieceHere;
    private boolean blackPieceHere;
    private String pieceHere = "empty"; 

    private boolean attackedByWhite;
    private boolean attackedByBlack;
    private String attackedByPiece = "empty"; 

    BoardSquare(String square, int coordX, int coordY) {
        this.square = square;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String boardSquareToString() {
        return (String) (square);
    }

    public void clearPieceHere() {
        whitePieceHere = false;
        blackPieceHere = false;

        pieceHere = "empty";
    }

    public void setPieceHere(String piece, char color) {
        switch(color) {
            case 'w' :
                whitePieceHere = true;
                pieceHere = piece;
                break;
            case 'b' :
                blackPieceHere = true;
                pieceHere = piece;
                break;
        }
    }

    public boolean isPieceHere() {
        if(whitePieceHere || blackPieceHere) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWhitePieceHere() {
        return whitePieceHere;
    }

    public boolean isBlackPieceHere() {
        return blackPieceHere;
    }

    public void clearAttackedBy() {
        attackedByPiece = "empty";
        attackedByWhite = false;
        attackedByBlack = false;

        System.out.println(this.boardSquareToString() + "attacked by black" + this.isAttackedByWhite());
    }

    public void setAttackedByPieceTrue(String piece, char color) {
        attackedByPiece = piece;
        switch(color) {
            case 'w' :
                attackedByWhite = true;
                break;
            case 'b' :
                attackedByBlack = true;
                break;
        }
    }

    public boolean isAttackedByWhite() {
        return attackedByWhite;
    }

    public boolean isAttackedByBlack() {
        return attackedByBlack;
    }
}  