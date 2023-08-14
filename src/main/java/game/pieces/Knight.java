package game.pieces;

public class Knight extends Piece {
    public Knight() {
        new Knight(-1);
    }

    public Knight(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.KNIGHT;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "n" : "N";
    }
}
