package battleShips.layouts;

import battleShips.BattleShips;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends VBox {
    private final Button start = new Button("Start");
    private final Button settings = new Button("Settings");
    private final Button exit = new Button("Exit");
    BattleShips root;
    private final EventHandler<MouseEvent> buttonClick = new EventHandler<>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            Button button = (Button) mouseEvent.getSource();
            switch (button.getText()) {
                case "Exit" -> ((Stage) exit.getScene().getWindow()).close();
                case "Settings" -> root.settings();
                case "Start" -> root.newGame();
            }
        }
    };

    public MainMenu(BattleShips root) {
        this.root = root;
        this.getChildren().addAll(start, settings, exit);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        setEventHandlers();
    }

    private void setEventHandlers() {
        exit.setOnMouseClicked(buttonClick);
        settings.setOnMouseClicked(buttonClick);
        start.setOnMouseClicked(buttonClick);
    }

}
