package washed.chess;

import washed.chess.types.*;

public class Board {
    public Piece[][] board;

    public Board() {
        this.board = initBoard();
    }

    public Piece[][] getBoard() { return this.board; }

    public void test() {
        for (Piece[] row: this.board) {
            String tit = "";
            for (Piece p: row) {
                tit += " " + p.toString();
            }
            System.out.println(tit);
        }
    }

    private Piece[] initPieceArray(boolean pawn, boolean player) {
        Piece[] row = new Piece[8];
        if (pawn) {
            for (int i = 0; i < 8; i++) {
                row[i] = new Pawn(player);
            }
        } else {
            row[0] = new Rook(player);
            row[1] = new Knight(player);
            row[2] = new Bishop(player);
            row[3] = new King(player);
            row[4] = new Queen(player);
            row[5] = new Bishop(player);
            row[6] = new Knight(player);
            row[7] = new Rook(player);
        }
        return row;
    }

    private Piece[][] initBoard() {
        Piece[][] board = new Piece[8][8];

        for (int i = 0; i < 8; i++) {
            if (i > 1 && i < 6) {
                for (int e = 0; e < 8; e++) {
                    board[i][e] = new Empty(false);
                }
            } else {
                boolean player = i > 4;
                if (i == 1 || i == 6) {
                    board[i] = initPieceArray(true, player);
                } else {
                    board[i] = initPieceArray(false, player);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int e = 0; e < 8; e++) {
                board[i][e].setPosition(new Position(e, i));
            }
        }

        return board;
    }
}
