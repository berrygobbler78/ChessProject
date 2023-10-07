package chessGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chessGame.pieces.PawnW;

public class TestFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    TestFrame() {
        super("Game Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);

        PawnW a2PawnW = new PawnW(135);

        JPanel bgPanel = new JPanel(null);
        bgPanel.setBounds(0, 0, screenWidth, screenHeight);
        bgPanel.setBackground(Color.black);

        bgPanel.add(a2PawnW);

        this.add(bgPanel);
        this.setVisible(true);
    }
}
