package washed.chess.types;

import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class Knight extends Piece implements Movement {

    public Knight(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {

        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        Piece[][] board = super.emptyBoard();

        for (int i = 0; i < 4; i++) {
            int changeX = i < 2 ? -2 : 2;
            int changeY = i < 1 || i > 2 ? -changeX : changeX;

            int cX = changeX < 0 ? changeX + 1 : changeX - 1;
            int cY = changeY < 0 ? changeY + 1 : changeY - 1;

            if (super.checkPosition(x + cX) && super.checkPosition(y + changeY)) {
                board[x + cX][y + changeY] = null;
            }
            if (super.checkPosition(y + cY) && super.checkPosition(x + changeX)) {
                board[x + changeX][y + cY] = null;
            }
        }

        return board;
    }

    public String toString() {
        return "Knight";
    }
}
