import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public static int WIDTH;
    public static int HEIGHT; 

    private static int BOARD_SQUARE_SIZE;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public final Color BG_COLOR = new Color(49, 46, 43);
    public final Color BOARD_COLOR_WHITE = new Color(224, 224, 224);
    public final Color BOARD_COLOR_BLACK = new Color(32, 32, 32);

    // Pieces
    static Image kingW;
    Image queenW;
    Image bishopW;
    Image knightW;
    Image rookW;
    Image pawnW;

    Image kingB;
    Image queenB;
    Image bishopB;
    Image knightB;
    Image rookB;
    Image pawnB;

    
    BufferedImage img = null; {
        try {
            img = ImageIO.read(new File("images/ChessPiecesArray.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    HashMap<String, Coordinate> chessCoordinatesMap = new HashMap<>();

    public GameFrame() {
        super("Game Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);

        this.HEIGHT = this.getContentPane().getHeight();
        this.WIDTH = this.getContentPane().getWidth();

        if(HEIGHT > WIDTH) {
            BOARD_SQUARE_SIZE = WIDTH / 8;
        } else {
            BOARD_SQUARE_SIZE = HEIGHT / 8;
        }

        Image kingW = img.getSubimage(0, 0, 320, 320);
        this.kingW = kingW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Bg color
        g2D.setPaint(BG_COLOR);
        g2D.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw bg of board
        g2D.setPaint(BOARD_COLOR_WHITE);
        if(HEIGHT > WIDTH) {
            // Portait mode
            g2D.fillRect(0, HEIGHT / 2 - WIDTH / 2, WIDTH, WIDTH);

            g2D.setPaint(BOARD_COLOR_BLACK);
            int boardSquareStartingPos = HEIGHT / 2 - WIDTH / 2;

            // Draw board squares
            for(int i = 0; i <= 3; i++) {
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, 0, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 8th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 7th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 2, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 6th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 3, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); //5th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 4, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 4th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 5, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 3rd row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 6, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 2nd row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 7, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 1st row
            }
        } else {
            // Landscape mode
            g2D.fillRect(WIDTH / 2 - HEIGHT / 2, 0, HEIGHT, HEIGHT);

            g2D.setPaint(BOARD_COLOR_BLACK);
            int boardSquareStartingPos = WIDTH / 2 - HEIGHT / 2;

            // Draw board
            for(int i = 0; i <= 3; i++) {
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, 0, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 8th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 7th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 2, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 6th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 3, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); //5th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 4, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 4th row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 5, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 3rd row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 6, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 2nd row
                g2D.fillRect(boardSquareStartingPos + BOARD_SQUARE_SIZE * i * 2, BOARD_SQUARE_SIZE * 7, BOARD_SQUARE_SIZE, BOARD_SQUARE_SIZE); // 1st row
            }

            // Row 1
            final Coordinate A1 = new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5);
            chessCoordinatesMap.put("a1", A1);
            final Coordinate B1 = new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5);
            chessCoordinatesMap.put("b1", B1);
            // chessCoordinatesMap.put("c1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5));
            // chessCoordinatesMap.put("d1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5));
            // chessCoordinatesMap.put("e1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5));
            // chessCoordinatesMap.put("f1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5));
            // chessCoordinatesMap.put("g1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5));
            // chessCoordinatesMap.put("h1" , new Coordinate(WIDTH / 2 - HEIGHT / 2 + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5));

            System.out.println(Coordinate.getX());

            chessCoordinatesMap.get("al");
            System.out.println(
                Coordinate.getX() + " " +
                chessCoordinatesMap.get("bl").getX() + " " 
            );

        }

        // Set image

        g2D.drawImage(kingW, (int) chessCoordinatesMap.get("al").getX(), (int) chessCoordinatesMap.get("al").getY(), null);

        
    }
}
