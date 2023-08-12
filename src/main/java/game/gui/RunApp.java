package game.gui;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

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

        Scene scene = new Scene(grid);

        // Create 64 rectangles and add to grid
        int count = 0;
        double s = 75;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(s, s, s, s);
                if (count % 2 == 1) {
                    rect.setFill(WH);
                }
                else {
                    rect.setFill(BL);
                }
                grid.add(rect, j, i);
                count++;
            }
        }

        stage.setTitle("Java Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}