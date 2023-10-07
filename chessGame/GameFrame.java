package chessGame;

import java.awt.BorderLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chessGame.pieces.*;

public class GameFrame extends JFrame {
    public static int WIDTH;
    public static int HEIGHT; 

    private static int BOARD_SQUARE_SIZE;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public final Color BG_COLOR = new Color(49, 46, 43);
    public final Color BOARD_COLOR_WHITE = new Color(224, 224, 224);
    public final Color BOARD_COLOR_BLACK = new Color(32, 32, 32);

    // Coords
    Coordinate a1Coord;
    Coordinate a2Coord;
    Coordinate a3Coord;
    Coordinate a4Coord;
    Coordinate a5Coord;
    Coordinate a6Coord;
    Coordinate a7Coord;
    Coordinate a8Coord;

    Coordinate b1Coord;
    Coordinate b2Coord;
    Coordinate b3Coord;
    Coordinate b4Coord;
    Coordinate b5Coord;
    Coordinate b6Coord;
    Coordinate b7Coord;
    Coordinate b8Coord;

    Coordinate c1Coord;
    Coordinate c2Coord;
    Coordinate c3Coord;
    Coordinate c4Coord;
    Coordinate c5Coord;
    Coordinate c6Coord;
    Coordinate c7Coord;
    Coordinate c8Coord;

    Coordinate d1Coord;
    Coordinate d2Coord;
    Coordinate d3Coord;
    Coordinate d4Coord;
    Coordinate d5Coord;
    Coordinate d6Coord;
    Coordinate d7Coord;
    Coordinate d8Coord;

    Coordinate e1Coord;
    Coordinate e2Coord;
    Coordinate e3Coord;
    Coordinate e4Coord;
    Coordinate e5Coord;
    Coordinate e6Coord;
    Coordinate e7Coord;
    Coordinate e8Coord;

    Coordinate f1Coord;
    Coordinate f2Coord;
    Coordinate f3Coord;
    Coordinate f4Coord;
    Coordinate f5Coord;
    Coordinate f6Coord;
    Coordinate f7Coord;
    Coordinate f8Coord;

    Coordinate g1Coord;
    Coordinate g2Coord;
    Coordinate g3Coord;
    Coordinate g4Coord;
    Coordinate g5Coord;
    Coordinate g6Coord;
    Coordinate g7Coord;
    Coordinate g8Coord;

    Coordinate h1Coord;
    Coordinate h2Coord;
    Coordinate h3Coord;
    Coordinate h4Coord;
    Coordinate h5Coord;
    Coordinate h6Coord;
    Coordinate h7Coord;
    Coordinate h8Coord;

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
    
    static int pieceBoundsX;
    static int pieceBoundsY;
    
    BufferedImage img = null; {
        try {
            img = ImageIO.read(new File("chessGame/images/ChessPiecesArray.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Map<String, Coordinate> chessCoordinatesMap = new HashMap<>();

    public GameFrame() {
        super("Game Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);

        this.HEIGHT = screenHeight;
        this.WIDTH = screenWidth;

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

        setSquareCoords();

        PawnW b2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW c2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW d2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW e2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW f2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW g2PawnW = new PawnW(BOARD_SQUARE_SIZE);
        PawnW h2PawnW = new PawnW(BOARD_SQUARE_SIZE);

        System.out.println(BOARD_SQUARE_SIZE);

        
    }

    public void setSquareCoords() {
        // Row 1
            chessCoordinatesMap.put("a1", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7, false));
            a1Coord = chessCoordinatesMap.get("a1");
            chessCoordinatesMap.put("b1", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7, false));
            b1Coord = chessCoordinatesMap.get("b1");
            chessCoordinatesMap.put("c1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7, false));
            c1Coord = chessCoordinatesMap.get("c1");
            chessCoordinatesMap.put("d1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7, false));
            d1Coord = chessCoordinatesMap.get("d1");
            chessCoordinatesMap.put("e1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7, false));
            e1Coord = chessCoordinatesMap.get("e1");
            chessCoordinatesMap.put("f1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7, false));
            f1Coord = chessCoordinatesMap.get("f1");
            chessCoordinatesMap.put("g1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7, false));
            g1Coord = chessCoordinatesMap.get("g1");
            chessCoordinatesMap.put("h1" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7, false));
            h1Coord = chessCoordinatesMap.get("h1");

            // Row 2
            chessCoordinatesMap.put("a2", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            a2Coord = chessCoordinatesMap.get("a2");
            chessCoordinatesMap.put("b2", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            b2Coord = chessCoordinatesMap.get("b2");
            chessCoordinatesMap.put("c2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            c2Coord = chessCoordinatesMap.get("c2");
            chessCoordinatesMap.put("d2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            d2Coord = chessCoordinatesMap.get("d2");
            chessCoordinatesMap.put("e2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            e2Coord = chessCoordinatesMap.get("e2");
            chessCoordinatesMap.put("f2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            f2Coord = chessCoordinatesMap.get("f2");
            chessCoordinatesMap.put("g2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            g2Coord = chessCoordinatesMap.get("g2");
            chessCoordinatesMap.put("h2" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE, false));
            h2Coord = chessCoordinatesMap.get("h2");

            // Row 3
            chessCoordinatesMap.put("a3", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            a3Coord = chessCoordinatesMap.get("a3");
            chessCoordinatesMap.put("b3", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            b3Coord = chessCoordinatesMap.get("b3");
            chessCoordinatesMap.put("c3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            c3Coord = chessCoordinatesMap.get("c3");
            chessCoordinatesMap.put("d3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            d3Coord = chessCoordinatesMap.get("d3");
            chessCoordinatesMap.put("e3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            e3Coord = chessCoordinatesMap.get("e3");
            chessCoordinatesMap.put("f3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            f3Coord = chessCoordinatesMap.get("f3");
            chessCoordinatesMap.put("g3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            g3Coord = chessCoordinatesMap.get("g3");
            chessCoordinatesMap.put("h3" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 2, false));
            h3Coord = chessCoordinatesMap.get("h3");

            // Row 4
            chessCoordinatesMap.put("a4", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            a4Coord = chessCoordinatesMap.get("a4");
            chessCoordinatesMap.put("b4", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            b4Coord = chessCoordinatesMap.get("b4");
            chessCoordinatesMap.put("c4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            c4Coord = chessCoordinatesMap.get("c4");
            chessCoordinatesMap.put("d4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            d4Coord = chessCoordinatesMap.get("d4");
            chessCoordinatesMap.put("e4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            e4Coord = chessCoordinatesMap.get("e4");
            chessCoordinatesMap.put("f4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            f4Coord = chessCoordinatesMap.get("f4");
            chessCoordinatesMap.put("g4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            g4Coord = chessCoordinatesMap.get("g4");
            chessCoordinatesMap.put("h4" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 3, false));
            h4Coord = chessCoordinatesMap.get("h4");

            // Row 5
            chessCoordinatesMap.put("a5", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            a5Coord = chessCoordinatesMap.get("a5");
            chessCoordinatesMap.put("b5", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            b5Coord = chessCoordinatesMap.get("b5");
            chessCoordinatesMap.put("c5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            c5Coord = chessCoordinatesMap.get("c5");
            chessCoordinatesMap.put("d5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            d5Coord = chessCoordinatesMap.get("d5");
            chessCoordinatesMap.put("e5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            e5Coord = chessCoordinatesMap.get("e5");
            chessCoordinatesMap.put("f5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            f5Coord = chessCoordinatesMap.get("f5");
            chessCoordinatesMap.put("g5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            g5Coord = chessCoordinatesMap.get("g5");
            chessCoordinatesMap.put("h5" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 4, false));
            h5Coord = chessCoordinatesMap.get("h5");

            // Row 6
            chessCoordinatesMap.put("a6", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            a6Coord = chessCoordinatesMap.get("a6");
            chessCoordinatesMap.put("b6", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            b6Coord = chessCoordinatesMap.get("b6");
            chessCoordinatesMap.put("c6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            c6Coord = chessCoordinatesMap.get("c6");
            chessCoordinatesMap.put("d6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            d6Coord = chessCoordinatesMap.get("d6");
            chessCoordinatesMap.put("e6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            e6Coord = chessCoordinatesMap.get("e6");
            chessCoordinatesMap.put("f6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            f6Coord = chessCoordinatesMap.get("f6");
            chessCoordinatesMap.put("g6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            g6Coord = chessCoordinatesMap.get("g6");
            chessCoordinatesMap.put("h6" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 5, false));
            h6Coord = chessCoordinatesMap.get("h6");

            // Row 7
            chessCoordinatesMap.put("a7", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            a7Coord = chessCoordinatesMap.get("a7");
            chessCoordinatesMap.put("b7", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            b7Coord = chessCoordinatesMap.get("b7");
            chessCoordinatesMap.put("c7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            c7Coord = chessCoordinatesMap.get("c7");
            chessCoordinatesMap.put("d7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            d7Coord = chessCoordinatesMap.get("d7");
            chessCoordinatesMap.put("e7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            e7Coord = chessCoordinatesMap.get("e7");
            chessCoordinatesMap.put("f7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            f7Coord = chessCoordinatesMap.get("f7");
            chessCoordinatesMap.put("g7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            g7Coord = chessCoordinatesMap.get("g7");
            chessCoordinatesMap.put("h7" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 6, false));
            h7Coord = chessCoordinatesMap.get("h7");

            // Row 8
            chessCoordinatesMap.put("a8", new Coordinate(((WIDTH - HEIGHT) / 2), HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            a8Coord = chessCoordinatesMap.get("a8");
            chessCoordinatesMap.put("b8", new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            b8Coord = chessCoordinatesMap.get("b8");
            chessCoordinatesMap.put("c8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 2, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            c8Coord = chessCoordinatesMap.get("c8");
            chessCoordinatesMap.put("d8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 3, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            d8Coord = chessCoordinatesMap.get("d8");
            chessCoordinatesMap.put("e8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 4, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            e8Coord = chessCoordinatesMap.get("e8");
            chessCoordinatesMap.put("f8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 5, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            f8Coord = chessCoordinatesMap.get("f8");
            chessCoordinatesMap.put("g8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 6, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            g8Coord = chessCoordinatesMap.get("g8");
            chessCoordinatesMap.put("h8" , new Coordinate(((WIDTH - HEIGHT) / 2) + BOARD_SQUARE_SIZE * 7, HEIGHT / 8 * 7 - BOARD_SQUARE_SIZE * 7, false));
            h8Coord = chessCoordinatesMap.get("h8");
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
            
            
            // Set inital piece placement
            g2D.drawImage(rookW, a1Coord.getX(), a1Coord.getY(), null);
            a1Coord.setPieceHere(true);
            g2D.drawImage(knightW, b1Coord.getX(), b1Coord.getY(), null);
            b1Coord.setPieceHere(true);
            g2D.drawImage(bishopW, c1Coord.getX(), c1Coord.getY(), null);
            c1Coord.setPieceHere(true);
            g2D.drawImage(queenW, d1Coord.getX(), d1Coord.getY(), null);
            d1Coord.setPieceHere(true);
            g2D.drawImage(kingW, e1Coord.getX(), e1Coord.getY(), null);
            e1Coord.setPieceHere(true);
            g2D.drawImage(bishopW, f1Coord.getX(), f1Coord.getY(), null);
            f1Coord.setPieceHere(true);
            g2D.drawImage(knightW, g1Coord.getX(), g1Coord.getY(), null);
            g1Coord.setPieceHere(true);
            g2D.drawImage(rookW, h1Coord.getX(), h1Coord.getY(), null);
            h1Coord.setPieceHere(true);

            
            
            // g2D.drawImage(a2PawnW.getPawnWImg(), a2Coord.getX(), a2Coord.getY(), null);
            // a2Coord.setPieceHere(true);
            // g2D.drawImage(b2PawnW.getPawnWImg(), b2Coord.getX(), b2Coord.getY(), null);
            // b2Coord.setPieceHere(true);
            // g2D.drawImage(c2PawnW.getPawnWImg(), c2Coord.getX(), c2Coord.getY(), null);
            // c2Coord.setPieceHere(true);
            // g2D.drawImage(d2PawnW.getPawnWImg(), d2Coord.getX(), d2Coord.getY(), null);
            // d2Coord.setPieceHere(true);
            // g2D.drawImage(e2PawnW.getPawnWImg(), e2Coord.getX(), e2Coord.getY(), null);
            // e2Coord.setPieceHere(true);
            // g2D.drawImage(f2PawnW.getPawnWImg(), f2Coord.getX(), f2Coord.getY(), null);
            // f2Coord.setPieceHere(true);
            // g2D.drawImage(g2PawnW.getPawnWImg(), g2Coord.getX(), g2Coord.getY(), null);
            // g2Coord.setPieceHere(true);
            // g2D.drawImage(h2PawnW.getPawnWImg(), h2Coord.getX(), h2Coord.getY(), null);
            // h2Coord.setPieceHere(true);

            g2D.drawImage(rookB, a8Coord.getX(), a8Coord.getY(), null);
            a8Coord.setPieceHere(true);
            g2D.drawImage(knightB, b8Coord.getX(), b8Coord.getY(), null);
            a8Coord.setPieceHere(true);
            g2D.drawImage(bishopB, c8Coord.getX(), c8Coord.getY(), null);
            c8Coord.setPieceHere(true);
            g2D.drawImage(queenB, d8Coord.getX(), d8Coord.getY(), null);
            d8Coord.setPieceHere(true);
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

        PawnW a2PawnW = new PawnW(BOARD_SQUARE_SIZE);

        JPanel bgPanel = new JPanel(null);
        bgPanel.setBounds(0, 0, screenWidth, screenHeight);
        a2PawnW.setLocation(100, 100);
        bgPanel.add(a2PawnW);
        this.add(bgPanel);
        this.setVisible(true);
    }
}