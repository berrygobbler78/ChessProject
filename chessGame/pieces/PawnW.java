package chessGame.pieces;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class PawnW extends JLabel implements MouseListener{
    private ImageIcon pawnWImgStandard;
    private ImageIcon pawnWImgBig;

    private int BOARD_SQUARE_SIZE;

    public PawnW(int BOARD_SQUARE_SIZE) {
        this.BOARD_SQUARE_SIZE = BOARD_SQUARE_SIZE;

        BufferedImage img = null; {
            try {
                img = ImageIO.read(new File("chessGame/images/ChessPiecesArray.png"));
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        this.pawnWImgStandard = new ImageIcon(img.getSubimage(1600, 0, 320, 320).getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT));
        this.pawnWImgBig = new ImageIcon(img.getSubimage(1600, 0, 320, 320));

        this.setSize(BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE);

        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);

        this.setIcon(pawnWImgStandard);
    }
    
    public ImageIcon getPawnWImg() {
        return pawnWImgStandard;
    }

    public void setLocation(int x, int y) {
        this.setBounds(x, y, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setIcon(pawnWImgBig);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setIcon(pawnWImgStandard);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}