package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import sample.utils.Direction;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    final private int MAX_BIRDS_COUNT = 8;
    final private View view;
    final private ArrayList<Bird> birds;

    public Game(View view) {
        this.view = view;
        this.birds = new ArrayList<>();
        start();
    }

    private void start() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), e -> update()));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }

    private void update() {
        spawn();
        clear();
    }


    private void spawn() {
        if (birds.size() < MAX_BIRDS_COUNT) {
            Direction direction = Math.round(Math.random()) == 0 ? Direction.LEFT : Direction.RIGHT;
            Bird bird = new Bird(direction);

            if (direction == Direction.LEFT) {
                bird.setLayoutX(view.getWidth());
            } else {
                bird.setLayoutX(0);
            }

            bird.setLayoutY(Math.random() * (view.getHeight() - 100) + 50);
            birds.add(bird);
            view.getChildren().add(bird);
        }
    }

    private void clear() {
       for (Bird bird : birds) {
           if (bird.getLayoutX() > view.getWidth() || bird.getLayoutX() < 0) {
               bird.die();
           }

           if (bird.isDead()) {
               birds.remove(bird);
               view.getChildren().remove(bird);
           }
       }
    }

}
