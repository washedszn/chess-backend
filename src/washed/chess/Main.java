package washed.chess;


import washed.chess.types.*;

import java.util.Arrays;

public class Main {
    private static Piece[][] board;

    public static void main(String[] args) {
        Board boardAdmin = new Board();
        board = boardAdmin.getBoard();

        board[1][4] = new Empty(true);
        board[1][5] = new Empty(true);
        board[1][3] = new Empty(true);
        board[1][1] = new Empty(true);
        board[3][1] = new Pawn(true);
        board[2][3] = new Pawn(true);
        board[3][4] = new Pawn(true);
        board[2][5] = new Pawn(true);
        tryMove(4, 0);

    }

    public static void tryMove(int x, int y) {
        Movement piece = (Movement) board[y][x];

        Piece[][] test = piece.getMoves();



        if (piece.toString().equals("Knight")) {
            for (int i = 0; i < 8; i++) {
                for (int e = 0; e < 8; e++) {
                    if (board[i][e].toString().equals("Empty") && test[i][e] == null) {
                        board[i][e] = null;
                    }
                }
            }
        } else {
            // I'd rather not hard code those co ordinates
            int[][] checks = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
            for (int i = 0; i < 8; i++) {
                int newX = checks[i][0] + x;
                int newY = checks[i][1] + y;
                boolean valid = true;

                while (board[0][0].checkPosition(newX) && board[0][0].checkPosition(newY) && valid) {
                    if (board[newY][newX].toString().equals("Empty") && test[newY][newX] == null) {
                        board[newY][newX] = null;
                        newX = checks[i][0] == 0 ? newX : checks[i][0] < 0 ? newX - 1 : newX + 1;
                        newY = checks[i][1] == 0 ? newY : checks[i][1] < 0 ? newY - 1 : newY + 1;
                    } else {
                        valid = false;
                    }
                }
            }
        }

        for (Piece[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
