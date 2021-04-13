package battleShips.elements;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OceanField extends Button {
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
    Ship ship;

    public OceanField() {
        setPrefSize(30, 30);
    }
}
