package battleShips.elements;

import javafx.scene.paint.Color;

public class ShipPart {
    boolean hit;
    Color color;
    private int x;
    private int y;
    private Ship ship;

    public ShipPart(Ship ship) {
        this.ship = ship;
        this.hit = false;
        color = Color.GRAY;
    }
}
