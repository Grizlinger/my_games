package blocks.layouts;

import blocks.elements.Brick;
import blocks.elements.Stick;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class GameLayout extends Group {
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private int lvl = 1;
    private Stick stick = new Stick();
    private ArrayList<Brick> bricks = new ArrayList<>();

    public GameLayout() {
        BorderPane pane = new BorderPane();
        pane.setId("gamePane");
        pane.setPrefSize(800, 600);
        getChildren().add(pane);
        getChildren().add(stick);
    }

    public void setEventHandlers() {
        getScene().setOnKeyPressed(this::keyEventHandler);
        getScene().setOnKeyReleased(this::keyEventHandler);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.0 / 60), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (moveLeft)
                    stick.setX(max(stick.getX() - 5, 5));
                if (moveRight)
                    stick.setX(min(stick.getX() + 5, stick.getScene().getWidth() - stick.getWidth() - 5));
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }

    private void keyEventHandler(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            switch (keyEvent.getCode()) {
                case LEFT:
                    moveLeft = true;
                    break;
                case RIGHT:
                    moveRight = true;
                    break;
                default:
                    break;
            }
        } else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            switch (keyEvent.getCode()) {
                case LEFT:
                    moveLeft = false;
                    break;
                case RIGHT:
                    moveRight = false;
                    break;
            }
        }
    }

    public void loadLayout() {
        /* TODO: read map from file,
         *   and make progress bar for loading.
         *   At last, platform run later -> show everything. */
        getChildren().add(stick);
    }

}
