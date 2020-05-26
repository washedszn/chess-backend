package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;
import washed.chess.Position;

public class Pawn extends Piece implements Movement {
    private boolean firstMove = true;

    public Pawn(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {
        Position position = super.getPosition();
        int x = position.getX();
        int y = position.getY();

        Piece[][] board = super.emptyBoard();

        // Need to add handling for if an enemy piece can be taken
        if (firstMove) {
            board[y + 1][x] = null;
            board[y + 2][x] = null;
            firstMove = false;
        } else {
            board[y + 1][x] = null;
        }

        return board;
    }

    public String toString() {
        return "Pawn";
    }
}
