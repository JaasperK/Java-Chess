package game.pieces;

import game.board.Move;

public abstract class Piece {
    Move[] legalMoves;
    int playerColor = -1;
    boolean movesDiagonally = false;
    boolean movesStraight = false;
    PieceEnum name;

    public boolean isWhite() {
        return this.playerColor == 1;
    }

    public boolean isBlack() {
        return this.playerColor == 0;
    }

    public abstract String toString();

    public PieceEnum getName() {
        return this.name;
    }

    public boolean getMovesDiagonally() {
        return movesDiagonally;
    }

    public boolean getMovesStraight() {
        return movesStraight;
    }

    // abstract Move[] calculateLegalMoves(Board board);
}
