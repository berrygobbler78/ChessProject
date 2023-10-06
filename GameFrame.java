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
import java.util.Map;

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
    static Image queenW;
    static Image bishopW;
    static Image knightW;
    static Image rookW;
    static Image pawnW;

    static Image kingB;
    static Image queenB;
    static Image bishopB;
    static Image knightB;
    static Image rookB;
    static Image pawnB;

    
    BufferedImage img = null; {
        try {
            img = ImageIO.read(new File("images/ChessPiecesArray.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Map<String, Coordinate> chessCoordinatesMap = new HashMap<>();


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

        // Images for white pieces 
        Image kingW = img.getSubimage(0, 0, 320, 320);
        this.kingW = kingW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image queenW = img.getSubimage(320, 0, 320, 320);
        this.queenW = queenW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image bishopW = img.getSubimage(640, 0, 320, 320);
        this.bishopW = bishopW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image knightW = img.getSubimage(960, 0, 320, 320);
        this.knightW = knightW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image rookW = img.getSubimage(1280, 0, 320, 320);
        this.rookW = rookW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image pawnW = img.getSubimage(1600, 0, 320, 320);
        this.pawnW = pawnW.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);

        // Images for black pieces
        Image kingB = img.getSubimage(0, 320, 320, 320);
        this.kingB = kingB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image queenB = img.getSubimage(320, 320, 320, 320);
        this.queenB = queenB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image bishopB = img.getSubimage(640, 320, 320, 320);
        this.bishopB = bishopB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image knightB = img.getSubimage(960, 320, 320, 320);
        this.knightB = knightB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image rookB = img.getSubimage(1280, 320, 320, 320);
        this.rookB = rookB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
        Image pawnB = img.getSubimage(1600, 320, 320, 320);
        this.pawnB = pawnB.getScaledInstance(BOARD_SQUARE_SIZE - 10, BOARD_SQUARE_SIZE - 10, Image.SCALE_DEFAULT);
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
            chessCoordinatesMap.put("a1", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5, false));
            Coordinate a1Coord = chessCoordinatesMap.get("a1");
            chessCoordinatesMap.put("b1", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5, false));
            Coordinate b1Coord = chessCoordinatesMap.get("b1");
            chessCoordinatesMap.put("c1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5, false));
            Coordinate c1Coord = chessCoordinatesMap.get("c1");
            chessCoordinatesMap.put("d1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5, false));
            Coordinate d1Coord = chessCoordinatesMap.get("d1");
            chessCoordinatesMap.put("e1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5, false));
            Coordinate e1Coord = chessCoordinatesMap.get("e1");
            chessCoordinatesMap.put("f1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5, false));
            Coordinate f1Coord = chessCoordinatesMap.get("f1");
            chessCoordinatesMap.put("g1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5, false));
            Coordinate g1Coord = chessCoordinatesMap.get("g1");
            chessCoordinatesMap.put("h1" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5, false));
            Coordinate h1Coord = chessCoordinatesMap.get("h1");

            // Row 2
            chessCoordinatesMap.put("a2", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate a2Coord = chessCoordinatesMap.get("a2");
            chessCoordinatesMap.put("b2", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate b2Coord = chessCoordinatesMap.get("b2");
            chessCoordinatesMap.put("c2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate c2Coord = chessCoordinatesMap.get("c2");
            chessCoordinatesMap.put("d2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate d2Coord = chessCoordinatesMap.get("d2");
            chessCoordinatesMap.put("e2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate e2Coord = chessCoordinatesMap.get("e2");
            chessCoordinatesMap.put("f2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate f2Coord = chessCoordinatesMap.get("f2");
            chessCoordinatesMap.put("g2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate g2Coord = chessCoordinatesMap.get("g2");
            chessCoordinatesMap.put("h2" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE, false));
            Coordinate h2Coord = chessCoordinatesMap.get("h2");

            // Row 3
            chessCoordinatesMap.put("a3", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate a3Coord = chessCoordinatesMap.get("a3");
            chessCoordinatesMap.put("b3", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate b3Coord = chessCoordinatesMap.get("b3");
            chessCoordinatesMap.put("c3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate c3Coord = chessCoordinatesMap.get("c3");
            chessCoordinatesMap.put("d3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate d3Coord = chessCoordinatesMap.get("d3");
            chessCoordinatesMap.put("e3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate e3Coord = chessCoordinatesMap.get("e3");
            chessCoordinatesMap.put("f3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate f3Coord = chessCoordinatesMap.get("f3");
            chessCoordinatesMap.put("g3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate g3Coord = chessCoordinatesMap.get("g3");
            chessCoordinatesMap.put("h3" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 2, false));
            Coordinate h3Coord = chessCoordinatesMap.get("h3");

            // Row 4
            chessCoordinatesMap.put("a4", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate a4Coord = chessCoordinatesMap.get("a4");
            chessCoordinatesMap.put("b4", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate b4Coord = chessCoordinatesMap.get("b4");
            chessCoordinatesMap.put("c4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate c4Coord = chessCoordinatesMap.get("c4");
            chessCoordinatesMap.put("d4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate d4Coord = chessCoordinatesMap.get("d4");
            chessCoordinatesMap.put("e4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate e4Coord = chessCoordinatesMap.get("e4");
            chessCoordinatesMap.put("f4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate f4Coord = chessCoordinatesMap.get("f4");
            chessCoordinatesMap.put("g4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate g4Coord = chessCoordinatesMap.get("g4");
            chessCoordinatesMap.put("h4" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 3, false));
            Coordinate h4Coord = chessCoordinatesMap.get("h4");

            // Row 5
            chessCoordinatesMap.put("a5", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate a5Coord = chessCoordinatesMap.get("a5");
            chessCoordinatesMap.put("b5", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate b5Coord = chessCoordinatesMap.get("b5");
            chessCoordinatesMap.put("c5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate c5Coord = chessCoordinatesMap.get("c5");
            chessCoordinatesMap.put("d5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate d5Coord = chessCoordinatesMap.get("d5");
            chessCoordinatesMap.put("e5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate e5Coord = chessCoordinatesMap.get("e5");
            chessCoordinatesMap.put("f5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate f5Coord = chessCoordinatesMap.get("f5");
            chessCoordinatesMap.put("g5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate g5Coord = chessCoordinatesMap.get("g5");
            chessCoordinatesMap.put("h5" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 4, false));
            Coordinate h5Coord = chessCoordinatesMap.get("h5");

            // Row 6
            chessCoordinatesMap.put("a6", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate a6Coord = chessCoordinatesMap.get("a6");
            chessCoordinatesMap.put("b6", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate b6Coord = chessCoordinatesMap.get("b6");
            chessCoordinatesMap.put("c6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate c6Coord = chessCoordinatesMap.get("c6");
            chessCoordinatesMap.put("d6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate d6Coord = chessCoordinatesMap.get("d6");
            chessCoordinatesMap.put("e6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate e6Coord = chessCoordinatesMap.get("e6");
            chessCoordinatesMap.put("f6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate f6Coord = chessCoordinatesMap.get("f6");
            chessCoordinatesMap.put("g6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate g6Coord = chessCoordinatesMap.get("g6");
            chessCoordinatesMap.put("h6" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 5, false));
            Coordinate h6Coord = chessCoordinatesMap.get("h6");

            // Row 7
            chessCoordinatesMap.put("a7", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate a7Coord = chessCoordinatesMap.get("a7");
            chessCoordinatesMap.put("b7", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate b7Coord = chessCoordinatesMap.get("b7");
            chessCoordinatesMap.put("c7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate c7Coord = chessCoordinatesMap.get("c7");
            chessCoordinatesMap.put("d7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate d7Coord = chessCoordinatesMap.get("d7");
            chessCoordinatesMap.put("e7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate e7Coord = chessCoordinatesMap.get("e7");
            chessCoordinatesMap.put("f7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate f7Coord = chessCoordinatesMap.get("f7");
            chessCoordinatesMap.put("g7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate g7Coord = chessCoordinatesMap.get("g7");
            chessCoordinatesMap.put("h7" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 6, false));
            Coordinate h7Coord = chessCoordinatesMap.get("h7");

            // Row 8
            chessCoordinatesMap.put("a8", new Coordinate(((WIDTH - HEIGHT) / 2) + 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate a8Coord = chessCoordinatesMap.get("a8");
            chessCoordinatesMap.put("b8", new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate b8Coord = chessCoordinatesMap.get("b8");
            chessCoordinatesMap.put("c8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate c8Coord = chessCoordinatesMap.get("c8");
            chessCoordinatesMap.put("d8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate d8Coord = chessCoordinatesMap.get("d8");
            chessCoordinatesMap.put("e8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate e8Coord = chessCoordinatesMap.get("e8");
            chessCoordinatesMap.put("f8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate f8Coord = chessCoordinatesMap.get("f8");
            chessCoordinatesMap.put("g8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate g8Coord = chessCoordinatesMap.get("g8");
            chessCoordinatesMap.put("h8" , new Coordinate(((WIDTH - HEIGHT) / 2) + 5 + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 + 5 - BOARD_SQUARE_SIZE * 7, false));
            Coordinate h8Coord = chessCoordinatesMap.get("h8");
            
            // Set inital piece placement
            g2D.drawImage(rookW, a1Coord.getX(), a1Coord.getY(), null);
            g2D.drawImage(knightW, b1Coord.getX(), b1Coord.getY(), null);
            g2D.drawImage(bishopW, c1Coord.getX(), c1Coord.getY(), null);
            g2D.drawImage(queenW, d1Coord.getX(), d1Coord.getY(), null);
            g2D.drawImage(kingW, e1Coord.getX(), e1Coord.getY(), null);
            g2D.drawImage(bishopW, f1Coord.getX(), f1Coord.getY(), null);
            g2D.drawImage(knightW, g1Coord.getX(), g1Coord.getY(), null);
            g2D.drawImage(rookW, h1Coord.getX(), h1Coord.getY(), null);
            
            g2D.drawImage(pawnW, a2Coord.getX(), a2Coord.getY(), null);
            g2D.drawImage(pawnW, b2Coord.getX(), b2Coord.getY(), null);
            g2D.drawImage(pawnW, c2Coord.getX(), c2Coord.getY(), null);
            g2D.drawImage(pawnW, d2Coord.getX(), d2Coord.getY(), null);
            g2D.drawImage(pawnW, e2Coord.getX(), e2Coord.getY(), null);
            g2D.drawImage(pawnW, f2Coord.getX(), f2Coord.getY(), null);
            g2D.drawImage(pawnW, g2Coord.getX(), g2Coord.getY(), null);
            g2D.drawImage(pawnW, h2Coord.getX(), h2Coord.getY(), null);

            g2D.drawImage(rookB, a8Coord.getX(), a8Coord.getY(), null);
            g2D.drawImage(knightB, b8Coord.getX(), b8Coord.getY(), null);
            g2D.drawImage(bishopB, c8Coord.getX(), c8Coord.getY(), null);
            g2D.drawImage(queenB, d8Coord.getX(), d8Coord.getY(), null);
            g2D.drawImage(kingB, e8Coord.getX(), e8Coord.getY(), null);
            g2D.drawImage(bishopB, f8Coord.getX(), f8Coord.getY(), null);
            g2D.drawImage(knightB, g8Coord.getX(), g8Coord.getY(), null);
            g2D.drawImage(rookB, h8Coord.getX(), h8Coord.getY(), null);
            
            g2D.drawImage(pawnB, a7Coord.getX(), a7Coord.getY(), null);
            g2D.drawImage(pawnB, b7Coord.getX(), b7Coord.getY(), null);
            g2D.drawImage(pawnB, c7Coord.getX(), c7Coord.getY(), null);
            g2D.drawImage(pawnB, d7Coord.getX(), d7Coord.getY(), null);
            g2D.drawImage(pawnB, e7Coord.getX(), e7Coord.getY(), null);
            g2D.drawImage(pawnB, f7Coord.getX(), f7Coord.getY(), null);
            g2D.drawImage(pawnB, g7Coord.getX(), g7Coord.getY(), null);
            g2D.drawImage(pawnB, h7Coord.getX(), h7Coord.getY(), null);


        }
    }

    public void generateBoardCoordAndSquares() {

    }
}