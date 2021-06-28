package sample;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import sample.utils.Images;

public class View extends Group {
    final private int width = 1280, height = 720;

    public View() {
        initializeBackground();
    }

    private void initializeBackground() {
        ImageView background = new ImageView(Images.BACKGROUND);
        background.setFitHeight(height);
        background.setFitWidth(width);
        this.getChildren().add(background);
    }

    // Getters

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
