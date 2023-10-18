package chessGame.exceptions;

public class InvalidPieceColorException extends Exception {
    public InvalidPieceColorException(String color) { 
        System.err.println(color + " is not a valid color");
    }
}