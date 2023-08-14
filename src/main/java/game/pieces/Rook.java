package game.pieces;

public class Rook extends Piece {
    public Rook() {
        new Rook(-1);
    }

    public Rook(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.ROOK;
        movesStraight = true;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "r" : "R";
    }
}
