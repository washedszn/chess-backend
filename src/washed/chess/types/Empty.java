package washed.chess.types;


import washed.chess.Movement;
import washed.chess.Piece;

public class Empty extends Piece implements Movement {

    public Empty(boolean p) {
        super(p);
    }

    public Piece[][] getMoves() {
        return super.emptyBoard();
    }

    public String toString() {
        return "Empty";
    }
}
