package game.gui;

import game.board.Board;
import game.pieces.Piece;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RunApp extends Application {

    private final double tileSize = 75;
    private final Color BL = new Color(164.0/255.0, 131.0/255.0, 98.0/255.0, 1.0);
    private final Color WH = new Color(225.0/255.0, 210.0/255.0, 172.0/255.0, 1.0);

    @Override
    public void start(Stage stage) throws Exception {
        if (stage == null) {
            throw new IOException("Stage cannot be null!");
        }

        // Create Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));

        // Create 64 rectangles and add to grid
        int count = 0;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(tileSize, tileSize, tileSize, tileSize);

                if (count % 2 == 1)
                    rect.setFill(WH);
                else
                    rect.setFill(BL);

                grid.add(new DragableImageView(), j, i);
                grid.add(rect, j, i);
                count++;
            }
        }

        // [WKing, BKing, WQueen, BQueen, WBishop, BBishop, WKnight, BKnight, WRook, BRook, WPawn, BPawn]
        ArrayList<DragableImageView> pieces = loadImageViews();

        Board field = new Board();
        field.setupStartPosition();
        Piece[][] board = field.getBoard();

        // ___________________________
        // |
        // |
        // |
        // |
        // |
        // |
        // |
        // |
        // ---------------------------

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                Piece p = board[file][rank];
                if (p == null) continue;
                boolean isWhite = p.isWhite();
                switch (p.getName()) {
                    case KING -> grid.add(isWhite ? pieces.get(0).copy() : pieces.get(1).copy(), rank, file);

                    case QUEEN -> grid.add(isWhite ? pieces.get(2).copy() : pieces.get(3).copy(), rank, file);

                    case BISHOP -> grid.add(isWhite ? pieces.get(4).copy() : pieces.get(5).copy(), rank, file);

                    case KNIGHT -> grid.add(isWhite ? pieces.get(6).copy() : pieces.get(7).copy(), rank, file);

                    case ROOK -> grid.add(isWhite ? pieces.get(8).copy() : pieces.get(9).copy(), rank, file);

                    case PAWN -> grid.add(isWhite ? pieces.get(10).copy() : pieces.get(11).copy(), rank, file);

                    default -> throw new Exception("wtf");
                }
            }
        }

        Scene scene = new Scene(grid);
        stage.setTitle("Java Chess");
        stage.setScene(scene);
        stage.show();
    }

    public ArrayList<DragableImageView> loadImageViews() {
        String path = "C:\\Users\\Jasper Koehn\\Desktop\\Coding\\Java\\Chess\\src\\main\\resources\\";

        String[] pieceNames = {"King", "Queen", "Bishop", "Knight", "Rook", "Pawn"};
        ArrayList<DragableImageView> out = new ArrayList<>();
        for (String s : pieceNames) {
            DragableImageView wv = new DragableImageView();
            DragableImageView bv = new DragableImageView();

            Image wIm = new Image(path + "W" + s + ".png");
            Image bIm = new Image(path + "B" + s + ".png");

            wv.setImage(wIm);
            wv.setFitHeight(tileSize);
            wv.setFitWidth(tileSize);

            bv.setImage(bIm);
            bv.setFitHeight(tileSize);
            bv.setFitWidth(tileSize);

            out.add(wv);
            out.add(bv);
        }

        return out;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
