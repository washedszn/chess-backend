package washed.chess;

import washed.chess.types.Empty;

public class Piece {
    public Position position;
    boolean player; // True = White | False = Black

    public Piece(boolean p) { this.player = p; }

    public Piece[][] emptyBoard() {
        Piece[][] board = new Piece[8][8];

        for (int i = 0; i < 8; i++) {
            for (int e = 0; e < 8; e++) {
                board[i][e] = new Empty(true);
            }
        }

        return board;
    }

    public boolean checkPosition(int p) {
        if (p < 0 || p > 7) {
            return false;
        }
        return true;
    }

    public Position getPosition() { return this.position; }
    public void setPosition(Position p) { this.position = p; }

}
