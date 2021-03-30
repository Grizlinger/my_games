package blocks.elements;

import javafx.scene.shape.Rectangle;

import static java.lang.Math.min;

public class Brick extends Rectangle {
    double durability;

    public Brick(double posX, double posY, double sizeX, double sizeY, double _durability) {
        setX(posX);
        setY(posY);
        setWidth(sizeX);
        setHeight(sizeY);
        this.durability = _durability;
    }

    private Boolean isHorizontalHit(Ball ball) {
        if (ball.getCenterX() > getX() && ball.getCenterX() < getX() + getWidth()) {
            return (ball.getCenterY() - ball.getRadius() <= getY() + getHeight()      // hit from bottom
                    && ball.getCenterY() - ball.getRadius() >= getY() + getHeight() - ball.getSpeed())
                    || (ball.getCenterY() + ball.getRadius() >= getY()             // hit from top
                    && ball.getCenterY() + ball.getRadius() <= getY() + ball.getSpeed());
        }
        return false;
    }

    private Boolean isVerticalHit(Ball ball) {
        if (ball.getCenterY() >= getY() && ball.getCenterY() <= getY() + getHeight()) {
            return (ball.getCenterX() - ball.getRadius() <= getX() + getWidth()      // hit right
                    && ball.getCenterX() - ball.getRadius() >= getX() + getWidth() - ball.getSpeed())
                    || (ball.getCenterX() + ball.getRadius() >= getX()             // hit from left
                    && ball.getCenterX() + ball.getRadius() <= getX() + ball.getSpeed());
        }
        return false;
    }

    public void handle(Ball ball) {
        if (isHorizontalHit(ball)) {
            durability -= min(ball.getStrength(), durability);
            ball.handleHorizontalHit();
        } else if (isVerticalHit(ball)) {
            durability -= min(ball.getStrength(), durability);
            ball.handleVerticalHit();
        }
    }

    public double getDurability() {
        return durability;
    }

}
