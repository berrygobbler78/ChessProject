package chessGame.pieces;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import chessGame.Board;
import chessGame.BoardSquare;
import chessGame.frame.BoardPanel;

public class King extends Piece{
    private final String NAME = "King";
    private Image kingImage;
    private JLabel kingLabel;

    private String squareNE, squareNW, squareN, squareSE, squareS, squareSW, squareE, squareW;

    private int xOffset, yOffset;

    public King(BoardSquare startingSquare, Map<String, BoardSquare> boardMap, Board board, char pieceColor, BoardPanel boardPanel) {
        super(startingSquare, boardMap, board, pieceColor, boardPanel);

        switch(pieceColor) {
            case 'w' :
                kingImage = imgArray.getSubimage(0, 0, 320, 320).getScaledInstance(boardPanel.getBoardSquareSize() - 10, boardPanel.getBoardSquareSize() - 10, Image.SCALE_DEFAULT);
                break;
            case 'b' :
                kingImage = imgArray.getSubimage(0, 320, 320, 320).getScaledInstance(boardPanel.getBoardSquareSize() - 10, boardPanel.getBoardSquareSize() - 10, Image.SCALE_DEFAULT);
                break;
        }

        kingLabel = new JLabel(new ImageIcon(kingImage));
        kingLabel.setSize(boardPanel.getBoardSquareSize(), boardPanel.getBoardSquareSize());
        kingLabel.setLocation(currentBoardSquare.getCoordX(), currentBoardSquare.getCoordY());

        getPossibleMoves();
        getSquaresAttacked();

        kingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOffset = e.getX();
                yOffset = e.getY();
                kingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                getPossibleMoves();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                kingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                
                getPossibleMoves();

                if(possibleMoves.contains(board.getBoardSquareForCoordinate(e.getXOnScreen(), e.getYOnScreen()))) {
                    kingLabel.setLocation(board.getBoardSquareForCoordinate(e.getXOnScreen(), e.getYOnScreen()).getCoordX(), board.getBoardSquareForCoordinate(e.getXOnScreen(), e.getYOnScreen()).getCoordY());
                    for(int i = 0; i < getSquaresAttacked().size(); i++) {
                        getSquaresAttacked().get(i).clearAttackedBy();
                    }
                    currentBoardSquare = board.getBoardSquareForCoordinate(e.getXOnScreen(), e.getYOnScreen());
                    getSquaresAttacked();
                } else {
                    kingLabel.setLocation(currentBoardSquare.getCoordX(), currentBoardSquare.getCoordY());
                }
            }
        });

        kingLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                final int x = e.getXOnScreen();
                final int y = e.getYOnScreen();

                final Rectangle labelBounds = kingLabel.getBounds();
                if(labelBounds != null && labelBounds.contains(x, y)) {
                    kingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    
                } else {
                    kingLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }

            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - xOffset;
                int newY = e.getYOnScreen() - yOffset;
                
                kingLabel.setLocation(newX, newY);
            }

            
        });
    }
    
    public JLabel getKingLabel() {
        return kingLabel;
    }

    @Override
    public void setPossibleSquares() {
        char[] letterAndNum = currentBoardSquare.boardSquareToString().toCharArray();
        char letter = letterAndNum[0];
        char number = letterAndNum[1];
        
        squareNE = ("" + (char) (letter + 1) + (char) (number + 1));
        squareNW = ("" + (char) (letter - 1) + (char) (number + 1));
        squareN = ("" + (char) (letter) + (char) (number + 1));

        squareSE = ("" + (char) (letter + 1) + (char) (number - 1));
        squareS = ("" + (char) (letter) + (char) (number - 1));
        squareSW = ("" + (char) (letter - 1) + (char) (number - 1));

        squareE = ("" + (char) (letter + 1) + (char) (number));
        squareW = ("" + (char) (letter - 1) + (char) (number));
        
        switch(letter) {
            case 'a' :
                squareNW = "null";
                squareW = "null";
                squareSW = "null";
                break;
            case 'h' :
                squareNE = "null";
                squareE = "null";
                squareSE = "null";
                break;
        }

        switch(number) {
            case '1' :
                squareSE = "null";
                squareS = "null";
                squareSW = "null";
                break;
            case '8' :
                squareNE = "null";
                squareN = "null";
                squareNW = "null";
                break;
        }
    }

    @Override
    public ArrayList<BoardSquare> getPossibleMoves() {
        setPossibleSquares();
        tempPossibleMoves.clear();
        possibleMoves.clear();

        tempPossibleMoves.add(squareNW);
        tempPossibleMoves.add(squareN);
        tempPossibleMoves.add(squareNE);
        tempPossibleMoves.add(squareE);
        tempPossibleMoves.add(squareSE);
        tempPossibleMoves.add(squareS);
        tempPossibleMoves.add(squareSW);
        tempPossibleMoves.add(squareW);

        for(int i = tempPossibleMoves.size() - 1; i >= 0; i--) {
            if(tempPossibleMoves.get(i) == "null") {
                tempPossibleMoves.remove(i);
            }
        }

        for(int i = tempPossibleMoves.size() - 1; i>= 0; i--) {
            if(pieceColor == 'w') {
                if(boardMap.get(tempPossibleMoves.get(i)).isAttackedByBlack()) {
                    tempPossibleMoves.remove(i);
                }
            } else if(pieceColor == 'b') {
                if(boardMap.get(tempPossibleMoves.get(i)).isAttackedByWhite()) {
                    System.out.println(tempPossibleMoves.get(i));
                    tempPossibleMoves.remove(i);
                }
            }
            
        }

        if(tempPossibleMoves.size() == 0) {
            System.out.println(pieceColor + " was checkmated");
        }

        for(int i = 0; i < tempPossibleMoves.size(); i++) {
            possibleMoves.add(board.stringtoBoardSquare(tempPossibleMoves.get(i)));
        }

        return possibleMoves;
    }

    @Override
    public ArrayList<BoardSquare> getSquaresAttacked() {
        setPossibleSquares();
        tempSquaresAttacked.clear();
        squaresAttacked.clear();
        
        tempSquaresAttacked.add(squareNW);
        tempSquaresAttacked.add(squareN);
        tempSquaresAttacked.add(squareNE);
        tempSquaresAttacked.add(squareE);
        tempSquaresAttacked.add(squareSE);
        tempSquaresAttacked.add(squareS);
        tempSquaresAttacked.add(squareSW);
        tempSquaresAttacked.add(squareW);

        for(int i = tempSquaresAttacked.size() - 1; i >= 0; i--) {
            if(tempSquaresAttacked.get(i) == "null") {
                tempSquaresAttacked.remove(i);
            }
        }

        for(int i = tempSquaresAttacked.size() - 1; i >= 0; i--) {
            boardMap.get(tempSquaresAttacked.get(i)).setAttackedByPieceTrue(NAME, pieceColor);
        }

        for(int i = 0; i < tempSquaresAttacked.size(); i++) {
            squaresAttacked.add(board.stringtoBoardSquare(tempSquaresAttacked.get(i)));
        }

        return squaresAttacked;
    }
}
