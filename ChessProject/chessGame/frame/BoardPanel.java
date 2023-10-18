package chessGame.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JPanel;

import chessGame.Board;
import chessGame.pieces.King;
import chessGame.pieces.Rook;

public class BoardPanel extends JPanel {
    Board board;

    King kingW, kingB;
    Rook aRookW, aRookB, hRookW, hRookB; 

    public final Color BG_COLOR = new Color(49, 46, 43);
    public final Color BOARD_COLOR_WHITE = new Color(224, 224, 224);
    public final Color BOARD_COLOR_BLACK = new Color(32, 32, 32);

    private int boardSquareSize;

    private int panelWidth;
    private int panelHeight;

    private int boardStartingX;
    private int boardStartingY;

    BoardPanel(int sizeX, int sizeY, int boardSquareSize) {
        this.setSize(sizeX, sizeY);
        this.boardSquareSize = boardSquareSize;
        this.setBackground(BG_COLOR);
        this.setLayout(null);
        this.panelWidth = sizeX;
        this.panelHeight = sizeY;

        boardStartingX = panelWidth / 2 - panelHeight / 2;
        boardStartingY = 0;

        board = new Board(boardStartingX, boardStartingY, this.getHeight());

        kingW = new King(board.stringtoBoardSquare("a1"), board.getBoardMap(), board, 'w', this);
        this.add(kingW.getKingLabel());

        // aRookW = new Rook(board.stringtoBoardSquare("b2"), board.getBoardMap(), board, 'w', this);
        // this.add(aRookW.getRookLabel());

        kingB = new King(board.stringtoBoardSquare("c1"), board.getBoardMap(), board, 'b', this);
        this.add(kingB.getKingLabel());
    }

    public int getBoardSquareSize() {
        return boardSquareSize;
    }



    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Bg color
        g2D.setPaint(BG_COLOR);
        g2D.fillRect(0, 0, panelWidth, panelHeight);

        g2D.setPaint(BOARD_COLOR_WHITE);
        g2D.fillRect(panelWidth / 2 - panelHeight / 2, 0, panelHeight, panelHeight);

        g2D.setPaint(BOARD_COLOR_BLACK);

        for(int j = 0; j < 4; j++) {
            for(int k = 0; k < 4; k++) {
                g2D.fillRect(boardStartingX + boardSquareSize + boardSquareSize * 2 * k, boardSquareSize * 2 * j, boardSquareSize, boardSquareSize);
                g2D.fillRect(boardStartingX + boardSquareSize * 2 * k, boardSquareSize + boardSquareSize * 2 * j, boardSquareSize, boardSquareSize);
            }
        }

        g2D.setColor(Color.GRAY);
        for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++) {
                g2D.drawString( "" + (char) ('a' + col) + (char) ('8' - row), boardStartingX + boardSquareSize * col, boardStartingY + boardSquareSize +  boardSquareSize * row);
            }
        }
    }
}
