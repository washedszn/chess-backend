package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class Rook extends Piece implements Movement {

    public Rook(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {

        Piece[][] board = super.emptyBoard();
        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                int p = i == 2 ? -1 : 1;
                while (super.checkPosition(p + y)) {
                    board[p + y][x] = null;
                    p = p < 0 ? p - 1 : p + 1;
                }
            } else {
                int p = i == 1 ? -1 : 1;
                while (super.checkPosition(p + y)) {
                    board[y][p + x] = null;
                    p = p < 0 ? p - 1 : p + 1;
                }
            }
        }

        return board;
    }

    public String toString() {
        return "Rook";
    }
}
