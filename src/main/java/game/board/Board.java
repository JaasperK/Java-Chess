package game.board;

import game.pieces.*;

public class Board {
    Piece[] board = new Piece[64];
    static String startPosition = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public void setupPosition(String fen) {
        setupPosition(fen, false);
    }

    public void setupPosition(String fen, boolean debug) {
        int idx = 64;
        for (Character c : fen.toCharArray()) {
            char match = Character.toLowerCase(c);
            switch (match) {
                case 'r' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new Rook(0) : new Rook(1);
                }
                case 'n' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new Knight(0) : new Knight(1);
                }
                case 'b' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new Bishop(0) : new Bishop(1);
                }
                case 'q' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new Queen(0) : new Queen(1);
                }
                case 'k' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new King(0) : new King(1);
                }
                case 'p' -> {
                    idx -= 1;
                    if (debug) System.out.print(c);
                    board[idx] = Character.isLowerCase(c) ? new Pawn(0) : new Pawn(1);
                }
                case '/' -> {
                    if (debug) System.out.println();
                }
                default -> {
                    int num = Character.getNumericValue(c);
                    idx -= num;
                    if (debug) {
                        for (int i = 0; i < num; i++) {
                            System.out.print("|");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.setupPosition(startPosition);
    }
}
