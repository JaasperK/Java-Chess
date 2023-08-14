package game.pieces;

public class Pawn extends Piece {

    public Pawn() {
        new Pawn(-1);
    }

    public Pawn(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.PAWN;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "p" : "P";
    }
}
