package chessGame;

import chessGame.exceptions.InvalidPieceColorException;
import chessGame.pieces.King;

public class TestClass {
    public static void run() throws InvalidPieceColorException {
        Board board = new Board(100, 0, 8);
        King kingB = new King(board.stringtoBoardSquare("a1"), board.getBoardMap(), board, 'b');

        System.out.println("\n\nkingB pos = \n" + kingB.getCurrentBoardSquare().boardSquareToString() + " \nIt's possible moves are:");
        for(int i = 0; i < kingB.getPossibleMoves().size(); i++) {
            
            System.out.print(kingB.getPossibleMoves().get(i).boardSquareToString() + " ");
        }

        King kingW = new King(board.stringtoBoardSquare("c1"), board.getBoardMap(), board, 'w');
        System.out.println("\n\nkingW pos = \n" + kingW.getCurrentBoardSquare().boardSquareToString() + " \nIt's possible moves are:");
        for(int i = 0; i < kingW.getPossibleMoves().size(); i++) {
            
            System.out.print(kingW.getPossibleMoves().get(i).boardSquareToString() + " ");
        }

        System.out.println("\n\nkingB pos = \n" + kingB.getCurrentBoardSquare().boardSquareToString() + " \nIt's possible moves are:");
        for(int i = 0; i < kingB.getPossibleMoves().size(); i++) {
            
            System.out.print(kingB.getPossibleMoves().get(i).boardSquareToString() + " ");
        }
    }
}
