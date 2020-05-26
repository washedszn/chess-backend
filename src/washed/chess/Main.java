package washed.chess;


import washed.chess.types.*;

import java.util.Arrays;

public class Main {
    private static Piece[][] board;

    public static void main(String[] args) {
        Board boardAdmin = new Board();
        board = boardAdmin.getBoard();
        tryMove();
//        Knight k = new Knight(true);
//
//        k.setPosition(new Position(0, 1));
//
//        Piece[][] p = k.getMoves();
//
//        for (Piece[] row: p) {
//            System.out.println(Arrays.toString(row));
//        }
    }

    public static void tryMove() {
        Movement piece = (Movement) board[0][1];

        Piece[][] test = piece.getMoves();

        if (piece.toString().equals("Knight")) {
            for (int i = 0; i < 8; i++) {
                for (int e = 0; e < 8; e++) {
                    if (board[i][e].toString().equals("Empty") && test[i][e] == null) {
                        board[i][e] = null;
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                int diagX = i < 2 ? -1 : 1;
                int diagY = i < 1 || i == 3 ? -diagX : diagX;
                int horX = i == 6 ? -1 : 1;
                int verY = i == 5 ? -1 : 1;

                System.out.println(diagX + " " + diagY + " - " + horX + " " + verY);
            }
        }

        for (Piece[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
