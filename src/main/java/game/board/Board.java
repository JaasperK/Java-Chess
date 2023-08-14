package game.board;

import game.pieces.*;

public class Board {
    Piece[][] board = new Piece[8][8];
    static String startPosition = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public void setupPosition(String fen) {
        setupPosition(fen, false);
    }

    private void setupPosition(String fen, boolean debug) {
        int rank = 8;
        int file = 8;
        for (Character c : fen.toCharArray()) {
            char match = Character.toLowerCase(c);
            switch (match) {
                case 'r' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new Rook(0) : new Rook(1);
                }
                case 'n' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new Knight(0) : new Knight(1);
                }
                case 'b' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new Bishop(0) : new Bishop(1);
                }
                case 'q' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new Queen(0) : new Queen(1);
                }
                case 'k' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new King(0) : new King(1);
                }
                case 'p' -> {
                    file -= 1;
                    if (debug) {
                        System.out.print(c);
                    }
                    board[rank-1][file] = Character.isLowerCase(c) ? new Pawn(0) : new Pawn(1);
                }
                case '/' -> {
                    if (debug) {
                        System.out.println();
                    }
                    rank -= 1;
                    file = 8;
                }
                default -> {
                    int num = Character.getNumericValue(c);
                    file -= num;
                    if (debug) {
                        for (int i = 0; i < num; i++) {
                            System.out.print("|");
                        }
                    }
                }
            }
        }
    }

    public void setupStartPosition() {
        this.setupPosition(startPosition);
    }

    public Piece[][] getBoard() {
        return this.board;
    }

    public static void main(String[] args) {
        Board testBoard = new Board();
        testBoard.setupPosition(startPosition, true);
    }
}
