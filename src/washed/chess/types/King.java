package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class King extends Piece implements Movement {

    public King(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {

        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        Piece[][] board = super.emptyBoard();

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                int p = i == 2 ? -1 : 1;
                if (super.checkPosition(p + y)) {
                    board[p + y][x] = null;
                }
            } else {
                int p = i == 1 ? -1 : 1;
                if (super.checkPosition(p + x)) {
                    board[y][p + x] = null;
                }
            }
        }

        return board;
    }

    public String toString() {
        return "King";
    }
}
