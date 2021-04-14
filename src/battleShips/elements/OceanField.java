package battleShips.elements;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OceanField extends Button {
    private Ship ship = null;


    private final EventHandler<MouseEvent> placeShip = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };
    private final EventHandler<MouseEvent> fire = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };

    public OceanField() {
        setPrefSize(30, 30);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
