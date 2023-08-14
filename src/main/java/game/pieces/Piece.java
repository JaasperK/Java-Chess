package game.pieces;

import game.board.Move;

public abstract class Piece {
    Move[] legalMoves;
    int playerColor = -1;
    boolean movesDiagonally = false;
    boolean movesStraight = false;
    PieceEnum name;

    boolean isWhite() {
        return this.playerColor == 1;
    }

    boolean isBlack() {
        return this.playerColor == 0;
    }

    public abstract String toString();

    public PieceEnum getName() {
        return this.name;
    }

    // abstract Move[] calculateLegalMoves(Board board);
}
