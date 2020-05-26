package washed.chess;

import java.util.ArrayList;
import java.util.List;

public interface Movement {

    Piece[][] getMoves();
    String toString();
    /**
     *
     * Methods:
     * - Available positions on board
     * - Possible moves for corresponding piece
     * - Merge possible moves with available positions
     * - Handling for if a piece is taken
     */

}
