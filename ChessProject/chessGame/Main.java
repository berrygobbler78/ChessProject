package chessGame;

import chessGame.exceptions.InvalidPieceColorException;
public class Main {
    public static void main(String[] args) throws InterruptedException, InvalidPieceColorException {
        // TestClass.run();

        GameThread chessThread = new GameThread();
        chessThread.start();
    }
}