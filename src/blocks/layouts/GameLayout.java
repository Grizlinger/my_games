package blocks.layouts;

import blocks.elements.Stick;
import javafx.scene.Group;

public class GameLayout extends Group {
    private Stick stick = new Stick();

    public GameLayout() {
        getChildren().add(stick);
    }
}
