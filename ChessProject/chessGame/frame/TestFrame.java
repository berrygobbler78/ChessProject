package chessGame.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import chessGame.Board;
import chessGame.pieces.King;

public class TestFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    

    BufferedImage chessArray = null; {
        try {
            chessArray = ImageIO.read(new File("chessGame/images/ChessPiecesArray.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public TestFrame() throws InterruptedException {
        super("Game Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        BoardPanel boardPanel = new BoardPanel(screenWidth, screenHeight, screenHeight / 8);

        this.add(boardPanel);
        this.setVisible(true);
    }
}
