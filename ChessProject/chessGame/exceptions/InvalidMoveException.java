package chessGame.exceptions;

public class InvalidMoveException extends Exception{
    public InvalidMoveException(String move) {
        super(move + " is an invalid move");
    }
}
