package game.gui;

import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DragableImageView extends ImageView {
    public DragableImageView() {
        setOnDragDetected(e -> {
            Dragboard dragboard = startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(this.getImage());
            dragboard.setContent(content);
            setImage(null);
            e.consume();
        });

        setOnDragEntered(e -> {

        });

        // when something is dropped over
        setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.MOVE);
            e.consume();
        });

        // when mouse is released over drag target
        setOnDragDropped(e -> {
            setImage(e.getDragboard().getImage());
            e.setDropCompleted(true);
            e.consume();
        });
    }

    public String toString() {
        return getImage().getUrl().replace("C:\\Users\\Jasper Koehn\\Desktop\\Coding\\Java\\Chess\\src\\main\\resources\\", "");
    }

    public DragableImageView copy() {
        DragableImageView copiedImageView = new DragableImageView();
        copiedImageView.setImage(this.getImage());
        copiedImageView.setFitWidth(this.getFitWidth());
        copiedImageView.setFitHeight(this.getFitHeight());
        copiedImageView.setPreserveRatio(this.isPreserveRatio());
        return copiedImageView;
    }
}
