package blocks.elements;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Circle {
    private static final int RADIUS = 10;
    private double speed;
    private double vx;
    private double vy;
    private double strength;

    public Ball() {
        strength = 1;
        speed = 5;
        Random random = new Random();
        double d = random.nextDouble() * 2 - 1;
        vx = Math.sin(d);
        vy = -Math.cos(d);

        setRadius(RADIUS);
        setCenterX(400);
        setCenterY(530);

        /*this.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE) {
                    setSpeed(5);
                }
            }
        });*/
    }

    public void move() {
        double height = this.getScene().getHeight();
        double width = this.getScene().getWidth();
        if (getCenterX() - RADIUS <= 0 || getCenterX() + RADIUS >= width)
            vx *= -1;
        if (getCenterY() - RADIUS <= 0)
            vy *= -1;
        if (getCenterY() + RADIUS > height)
            vy *= -1;
        Stick stick = null;
        for (Node p : this.getParent().getChildrenUnmodifiable()) {
            if (p.getClass() == Stick.class)
                stick = (Stick) p;
        }
        if (stick != null
                && getCenterY() + RADIUS > stick.getY()
                && getCenterY() + RADIUS < stick.getY() + Math.abs(speed)
                && getCenterX() >= stick.getX()
                && getCenterX() <= stick.getX() + stick.getWidth()) {
            double hitX = (getCenterX() - stick.getX() - stick.getWidth() / 2) / (stick.getWidth() / 2);
            vx = Math.sin(hitX);
            vy = -Math.cos(hitX);
        }

        setCenterX(getCenterX() + speed * vx);
        setCenterY(getCenterY() + speed * vy);
    }


    public void handleHorizontalHit() {
        vy *= -1;
    }

    public void handleVerticalHit() {
        vx *= -1;
    }

    public double getStrength() {
        return strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
