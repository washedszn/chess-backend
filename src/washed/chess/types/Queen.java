package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class Queen extends Piece implements Movement {

    public Queen(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {

        Piece[][] board = super.emptyBoard();
        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        // For now I've simply joined Bishop and Rook algorithm
        // Could be improved as readability is poor

        for (int i = 0; i < 4; i++) {
            int changeX = i < 2 ? -1 : 1;
            int changeY = i < 1 || i > 2 ? -changeX : changeX;
            while (super.checkPosition(x + changeX) && super.checkPosition(y + changeY)) {

                board[y + changeY][x + changeX] = null;

                changeX = changeX > 0 ? changeX + 1 : changeX - 1;
                changeY = changeY > 0 ? changeY + 1 : changeY - 1;
            }
            if (i % 2 == 0) {
                int p = i == 2 ? -1 : 1;
                while (super.checkPosition(p + y)) {
                    board[p + y][x] = null;
                    p = p < 0 ? p - 1 : p + 1;
                }
            } else {
                int p = i == 1 ? -1 : 1;
                while (super.checkPosition(p + x)) {
                    board[y][p + x] = null;
                    p = p < 0 ? p - 1 : p + 1;
                }
            }
        }

        return board;
    }

    public String toString() {
        return "Queen";
    }
}
