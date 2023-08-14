module game {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens game.board to javafx.fxml;
    exports game.board;
    exports game.gui;
    exports game.pieces;
    opens game.gui to javafx.fxml;
}