package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;
import sample.utils.Images;
import sample.utils.Direction;

public class Bird extends Canvas {
    final private GraphicsContext gc;
    final private Image[] frames = new Image[]{
            Images.BIRD_1,
            Images.BIRD_2,
            Images.BIRD_3,
            Images.BIRD_4,
            Images.BIRD_5,
            Images.BIRD_6,
            Images.BIRD_7,
            Images.BIRD_8,
            Images.BIRD_9,
            Images.BIRD_10,
            Images.BIRD_11,
    };

    private int frameIndex = 0;
    private Timeline moveTimer;
    private Timeline animTimer;
    private Direction direction;
    private boolean dead;


    public Bird(Direction direction) {
        super(86, 72);
        gc = this.getGraphicsContext2D();
        this.direction = direction;
        this.dead = false;
        startAnim();
        startMove();
        this.setOnMouseClicked(e -> dead = true);
    }

    private void startAnim() {
        animTimer = new Timeline(new KeyFrame(Duration.millis(40), e -> anim()));
        animTimer.setCycleCount(Animation.INDEFINITE);
        animTimer.play();
    }

    private void startMove() {
        moveTimer = new Timeline(new KeyFrame(Duration.millis(3), e -> move()));
        moveTimer.setCycleCount(Animation.INDEFINITE);
        moveTimer.play();
    }

    private void move() {
        if (dead) return;
        double speed = direction == Direction.LEFT ? -0.5 : 0.5;
        setLayoutX(getLayoutX() + speed);
    }

    private void anim() {
        if (dead) {
            gc.clearRect(0, 0, getWidth(), getHeight());
        } else {
            gc.clearRect(0, 0, getWidth(), getHeight());
            gc.drawImage(frames[frameIndex], 0, 0, getWidth(), getHeight());
            frameIndex++;
            if (frameIndex > frames.length - 1) {
                frameIndex = 0;
            }
        }
    }

    // Setters

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void die() {
        this.dead = true;
    }

    // Getters

    public boolean isDead() {
        return dead;
    }

}
