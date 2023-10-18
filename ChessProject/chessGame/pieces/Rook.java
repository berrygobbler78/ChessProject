package chessGame.pieces;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chessGame.Board;
import chessGame.BoardSquare;
import chessGame.frame.BoardPanel;

public class Rook extends Piece{
    private final String NAME = "Rook";

    private Image rookImage;
    private JLabel rookLabel;

    private int xOffset, yOffset;

    private ArrayList<String> possibleCol, possibleRow, possibleSquares;

    public Rook(BoardSquare startingSquare, Map<String, BoardSquare> boardMap, Board board, char pieceColor, BoardPanel boardPanel) {
        super(startingSquare, boardMap, board, pieceColor, boardPanel);

        switch(pieceColor) {
            case 'w' :
                rookImage = imgArray.getSubimage(320 * 4, 0, 320, 320).getScaledInstance(boardPanel.getBoardSquareSize() - 10, boardPanel.getBoardSquareSize() - 10, Image.SCALE_DEFAULT);
                break;
            case 'b' :
                rookImage = imgArray.getSubimage(320 * 4, 320, 320, 320).getScaledInstance(boardPanel.getBoardSquareSize() - 10, boardPanel.getBoardSquareSize() - 10, Image.SCALE_DEFAULT);
                break;
        }

        rookLabel = new JLabel(new ImageIcon(rookImage));
        rookLabel.setSize(boardPanel.getBoardSquareSize(), boardPanel.getBoardSquareSize());
        rookLabel.setLocation(currentBoardSquare.getCoordX(), currentBoardSquare.getCoordY());

        getPossibleMoves();
    }

    public JLabel getRookLabel() {
        return rookLabel;
    }
    
    @Override
    public void setPossibleSquares() {
        char[] letterAndNum = currentBoardSquare.boardSquareToString().toCharArray();
        char letter = letterAndNum[0];
        char number = letterAndNum[1];

        // possibleSquares.clear();
        possibleCol.clear();
        possibleRow.clear();

        for(int i = 0; i < 8; i++) {
            possibleCol.add("" + (char) ('a' + i));
            possibleRow.add("" + (char) ('1' + i));
        }

        possibleCol.remove(letter);
        possibleRow.remove(number);

        for(int i = 0; i < possibleCol.size(); i++) {
            possibleSquares.add(possibleCol.get(i) + "" + possibleRow.get(i));
        }

        System.out.println(possibleSquares);
    }

    @Override
    public ArrayList<BoardSquare> getPossibleMoves() {
        setPossibleSquares();
        possibleMoves.clear();
        
        for(int i = 0; i < possibleSquares.size(); i++) {
            switch(pieceColor) {
                case 'w' :
                    if(board.stringtoBoardSquare(possibleSquares.get(i)).isWhitePieceHere()) {
                        possibleSquares.remove(i);
                    }
                    break;
                case 'b' :
                    if(board.stringtoBoardSquare(possibleSquares.get(i)).isBlackPieceHere()) {
                        possibleSquares.remove(i);
                    }
                    break;
            }
        }

        for(int i = 0; i < possibleMoves.size(); i++) {
            System.out.println(possibleMoves.get(i).boardSquareToString());
        }

        return possibleMoves;
    }
}
