package game.pieces;

public class Queen extends Piece {
    public Queen() {
        new Queen(-1);
    }

    public Queen(int playerColor) {
        this.playerColor = playerColor;
        name = PieceEnum.QUEEN;
        movesDiagonally = true;
        movesStraight = true;
    }

    @Override
    public String toString() {
        return playerColor == 0 ? "q" : "Q";
    }
}
