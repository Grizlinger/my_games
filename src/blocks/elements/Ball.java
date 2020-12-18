package blocks.elements;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private static final int RADIUS = 10;
    private int vx;
    private int vy;

    public Ball() {
        vx = 5;
        vy = 5;
        setRadius(RADIUS);
        setCenterX(200);
        setCenterY(200);
    }

    public void move() {
        double height = this.getScene().getHeight();
        double width = this.getScene().getWidth();
        if (getCenterX() - RADIUS <= 0 || getCenterX() + RADIUS >= width)
            vx *= -1;
        if (getCenterY() - RADIUS <= 0 || getCenterY() + RADIUS >= height)
            vy *= -1;
        Stick stick;
        for (Node p :
                this.getParent().getChildrenUnmodifiable()) {
            if (p.getClass() == Stick.class)
                stick = (Stick) p;
        }
        if (getCenterX() - RADIUS <= 0 || getCenterX() + RADIUS >= stick.getX() + stick.getWidth())
            setCenterX(getCenterX() + vx);
        setCenterY(getCenterY() + vy);
    }
}
