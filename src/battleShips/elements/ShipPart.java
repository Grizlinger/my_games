package battleShips.elements;

import javafx.scene.paint.Color;

public class ShipPart {
    boolean hit;
    Color color;
    private int x;
    private int y;

    public ShipPart() {
        this.hit = false;
        color = Color.GRAY;
    }
}
