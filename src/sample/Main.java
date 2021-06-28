package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        View view = new View();
        new Game(view);

        stage.setResizable(false);
        stage.setTitle("Moorhuhn");
        stage.setScene(new Scene(view, view.getWidth(), view.getHeight()));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
