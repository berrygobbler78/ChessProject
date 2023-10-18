package chessGame;

import chessGame.frame.TestFrame;

public class GameThread extends Thread{
    
    @Override
    public void run() {
        // GameFrame frame = new GameFrame();
        try {
            TestFrame frame = new TestFrame();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
