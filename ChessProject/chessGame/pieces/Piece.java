package chessGame.pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import chessGame.Board;
import chessGame.BoardSquare;
import chessGame.exceptions.InvalidPieceColorException;
import chessGame.frame.BoardPanel;

public class Piece {
    protected static BufferedImage imgArray = null; {
        try {
            imgArray = ImageIO.read(new File("chessGame/images/ChessPiecesArray.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected final String NAME = "blank";

    protected BoardSquare currentBoardSquare;
    protected char pieceColor;
    protected Map<String, BoardSquare> boardMap;
    protected Board board;

    protected ArrayList<BoardSquare> possibleSquares = new ArrayList<>();
    protected ArrayList<String> tempPossibleSquares = new ArrayList<>();

    protected ArrayList<BoardSquare> squaresAttacked = new ArrayList<>();
    protected ArrayList<String> tempSquaresAttacked = new ArrayList<>();

    protected ArrayList<BoardSquare> possibleMoves = new ArrayList<>();
    protected ArrayList<String> tempPossibleMoves = new ArrayList<>();

    protected BoardPanel boardPanel;
    
    public Piece(BoardSquare startingBoardSquare, Map<String, BoardSquare> boardMap, Board board, char pieceColor, BoardPanel boardPanel) {
        this.currentBoardSquare = startingBoardSquare;
        currentBoardSquare.setPieceHere(NAME, pieceColor);
        this.boardMap = boardMap;
        this.board = board;
        this.boardPanel = boardPanel;

        switch(pieceColor) {
            case 'w' :
                this.pieceColor = 'w';
                break;
            case 'b' :
                this.pieceColor = 'b';
                break;
        }
    }

    public void setCurrentBoardSquare(BoardSquare newBoardSquare) {
        currentBoardSquare.clearPieceHere();
        currentBoardSquare = newBoardSquare;
        currentBoardSquare.setPieceHere(NAME, pieceColor);
    }

    public BoardSquare getCurrentBoardSquare() {
        return currentBoardSquare;
    }

    public String getCurrentBoardSquareString() {
        return currentBoardSquare.toString();
    }

    public char getPieceColor() {
        return pieceColor;
    }

    public void setPossibleSquares() {
        System.err.println("The setPossibleSquares method had not been implemented for this piece");
    }

    public ArrayList<BoardSquare> getSquaresAttacked() {
        System.err.println("The getSquaresAttacked method has not been implemented for this piece");
        return squaresAttacked;
    }

    public ArrayList<BoardSquare> getPossibleMoves() {
        System.err.println("The getPossibleMoves method has not been implemented for this piece");
        return possibleMoves;
    }
}
