package game.pieces;

public class King extends Piece {
    public King() {
        new King(-1);
    }

    public King(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.KING;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "k" : "K";
    }
}
