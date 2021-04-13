package battleShips.layouts;

import battleShips.elements.OceanField;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Game extends BorderPane {
    GridPane playerOneField = new GridPane();
    GridPane playerTwoField = new GridPane();
    HBox fields = new HBox();
    TextArea console = new TextArea();


    public Game() {
        setBottom(console);
        setCenter(fields);
        fields.getChildren().addAll(playerOneField, playerTwoField);
        fields.setAlignment(Pos.CENTER);
        fields.setPrefWidth(this.getPrefWidth());
        console.setText("valami");
        console.setDisable(true);
        console.setPrefRowCount(6);
        for (int i = 0; i < 8; i++) {
            playerOneField.addRow(i, new OceanField(), new OceanField(), new OceanField(), new OceanField(),
                    new OceanField(), new OceanField(), new OceanField(), new OceanField());
            playerTwoField.addRow(i, new OceanField(), new OceanField(), new OceanField(), new OceanField(),
                    new OceanField(), new OceanField(), new OceanField(), new OceanField());
        }
        playerOneField.setHgap(5);
        playerOneField.setVgap(5);
        playerTwoField.setHgap(5);
        playerTwoField.setVgap(5);
        fields.setSpacing(100);
        playerOneField.setAlignment(Pos.CENTER);
        playerTwoField.setAlignment(Pos.CENTER);
    }
}
