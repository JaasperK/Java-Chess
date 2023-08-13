package game.gui;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RunApp extends Application {

    private final Color BL = new Color(164.0/255.0, 131.0/255.0, 98.0/255.0, 1.0);
    private final Color WH = new Color(225.0/255.0, 210.0/255.0, 172.0/255.0, 1.0);

    @Override
    public void start(Stage stage) throws IOException {
        if (stage == null) {
            throw new IOException("Stage cannot be null!");
        }

        // Create Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));

        // Add labels
        for (int ind = 0; ind < 8; ind++) {
            char label = (char) ('A' + ind);
            Label text = new Label(String.valueOf(label));
            text.setPrefWidth(40);
            text.setPrefHeight(20);
            text.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");
            grid.add(text, ind, 8);
            GridPane.setHalignment(text, HPos.CENTER);
        }

        for (int ind = 0; ind < 8; ind++) {
            Label num = new Label(String.valueOf(8 - ind));
            num.setPrefWidth(20);
            num.setPrefHeight(40);
            num.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");
            grid.add(num, 8, ind);
            GridPane.setValignment(num, VPos.CENTER);
        }

        // Create 64 rectangles and add to grid
        int count = 0;
        double tileSize = 75;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(tileSize, tileSize, tileSize, tileSize);
                if (count % 2 == 1) {
                    rect.setFill(WH);
                }
                else {
                    rect.setFill(BL);
                }
                grid.add(new DragableImageView(), j, i);
                grid.add(rect, j, i);
                count++;
            }
        }

        // Load Images
        ArrayList<DragableImageView> views = new ArrayList<>();
        ArrayList<Image> images = new ArrayList<>();

        String path = "C:\\Users\\Jasper Koehn\\Desktop\\Coding\\Java\\Chess\\src\\main\\resources\\";
        DragableImageView wKing = new DragableImageView();
        Image wK = new Image(path + "WKing.png");
        views.add(wKing);
        images.add(wK);

        DragableImageView bKing = new DragableImageView();
        Image bK = new Image(path + "BKing.png");
        views.add(bKing);
        images.add(bK);

        for (int i = 0; i < views.size(); i++) {
            DragableImageView v = views.get(i);
            Image im = images.get(i);
            v.setImage(im);
            v.setFitHeight(tileSize);
            v.setFitWidth(tileSize);
            grid.add(v,i,0);  // TODO indexing of each piece - connect to board
        }

        Scene scene = new Scene(grid);
        stage.setTitle("Java Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}