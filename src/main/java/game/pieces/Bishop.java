package game.pieces;

public class Bishop extends Piece {
    public Bishop() {
        new Bishop(-1);
    }

    public Bishop(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.BISHOP;
        movesDiagonally = true;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "b" : "B";
    }
}
