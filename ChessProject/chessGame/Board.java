package chessGame;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.DynAnyPackage.Invalid;

import chessGame.exceptions.InvalidMoveException;
import chessGame.exceptions.InvalidPieceColorException;

public class Board {
    private int boardStartingX;
    private int boardStartingY;
    private int boardSize;
    private int boardSquareSize;

    private int rowY;
    private int colX;

    private Map<String, BoardSquare> boardMap = new HashMap<>();
    private ArrayList<BoardSquare> squaresAttackedWhite = new ArrayList<>();
    private ArrayList<BoardSquare> squaresAttackedBlack = new ArrayList<>();

    public Board(int boardStartingX, int boardStartingY, int boardSize) {
        this.boardStartingX = boardStartingX;
        this.boardStartingY = boardStartingY;
        this.boardSize = boardSize;

        boardSquareSize = boardSize / 8;

        for(int col = 0; col < 8; col++) {
            char letter = (char) ('a' + col);
            for(int row = 0; row < 8; row++) {
                char number = (char) ('1' + row);
                boardMap.put(letter + "" + number, new BoardSquare(letter + "" + number, boardStartingX + boardSquareSize * col, boardStartingY + boardSize - boardSquareSize * (row + 1)));
                boardMap.get(letter + "" + number).clearPieceHere();
            }
        }
        
    }

    public Map<String, BoardSquare> getBoardMap() {
        return boardMap;
    }

    public void movePiece(String move, char color) throws InvalidMoveException {
        char[] moveCharArray = move.toCharArray();
        char pieceToMove;
        String moveSquare;

        if(moveCharArray.length == 3) {
            // Moving piece w/o taking
            pieceToMove = moveCharArray[0];
            moveSquare = ("" + moveCharArray[1] + moveCharArray[2]);

            if(pieceToMove == 'a' || pieceToMove == 'b' || pieceToMove == 'c' || pieceToMove == 'd' || pieceToMove == 'e' || pieceToMove == 'f' || pieceToMove == 'g' || pieceToMove == 'h') {
                // Pawn
            } else if(pieceToMove == 'N') {
                // Knight
            } else if(pieceToMove == 'B') {
                // Bishop
            } else if(pieceToMove == 'R') {
                // Rook
            } else if(pieceToMove == 'Q') {
                // Queen
            } else if(pieceToMove == 'K') {
                // King
            } else {
                throw new InvalidMoveException(move);
            }

        } else if(moveCharArray.length == 4) {
            // Moving piece and taking
            if(moveCharArray[1] != 'x') {
                throw new InvalidMoveException(move);
            }

            pieceToMove = moveCharArray[0];
            moveSquare = ("" + moveCharArray[2] + moveCharArray[3]);

            

        } else {
            throw new InvalidMoveException(move);
        }

    }

    public BoardSquare stringtoBoardSquare(String square) {
        return boardMap.get(square);
    } 

    public void addSquaresAttacked(String color, ArrayList<BoardSquare> squaresAttacked) throws InvalidPieceColorException {
        if(color.toUpperCase() == "W") {
            for(int i = 0; i < squaresAttacked.size(); i++) {
                squaresAttackedWhite.add(squaresAttacked.get(i));
            }
        } else if(color.toUpperCase() == "B") {
            for(int i = 0; i < squaresAttacked.size(); i++) {
                squaresAttackedBlack.add(squaresAttacked.get(i));
            }
        } else {
            throw new InvalidPieceColorException(color);
        }
    }

    public ArrayList<BoardSquare> getSquaresAttacked(String color) throws InvalidPieceColorException {
        if(color.toUpperCase() == "W") {
            return squaresAttackedWhite;
        } else if(color.toUpperCase() == "B") {
            return squaresAttackedBlack;
        } else {
            throw new InvalidPieceColorException(color);
        }
    }

    public BoardSquare getBoardSquareForCoordinate(int x, int y) {
        char letter = 'a';
        char number = '1';

        for(int i = 0; boardStartingX + i * boardSquareSize < x; i++ ) {
            letter = (char) ('a' + i);
        }

        for(int i = 0; boardStartingY + i * boardSquareSize < y; i++ ) {
            number = (char) ('8' - i);
        }

        return boardMap.get(letter + "" + number);
    }
}