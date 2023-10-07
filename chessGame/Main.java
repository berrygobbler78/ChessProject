package chessGame;

public class Main {
    public static void main(String[] args) {
        GameThread chessThread = new GameThread();

        chessThread.start();
        
    }
}