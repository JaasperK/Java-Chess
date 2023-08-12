package game.pieces;

public class Knight extends Piece {
    public Knight() {
        new Knight(-1);
    }

    public Knight(int playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "n" : "N";
    }
}
