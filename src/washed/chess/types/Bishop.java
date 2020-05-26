package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class Bishop extends Piece implements Movement {

    public Bishop(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {

        Piece[][] board = super.emptyBoard();
        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        for (int i = 0; i < 4; i++) {
            int changeX = i < 2 ? -1 : 1;
            int changeY = i < 1 || i > 2 ? -changeX : changeX;
            while (super.checkPosition(x + changeX) && super.checkPosition(y + changeY)) {

                board[y + changeY][x + changeX] = null;

                changeX = changeX > 0 ? changeX + 1 : changeX - 1;
                changeY = changeY > 0 ? changeY + 1 : changeY - 1;
            }
        }

        return board;
    }

    public String toString() {
        return "Bishop";
    }
}
