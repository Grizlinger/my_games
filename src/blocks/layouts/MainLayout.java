package blocks.layouts;

import blocks.Blocks;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLayout extends BorderPane {
    Blocks root;

    Button start = new Button("Start");
    Button settings = new Button("Settings");
    Button exit = new Button("Exit");
    VBox vBox = new VBox();

    public MainLayout(Blocks blocks) {
        root = blocks;
        start.setOnMouseClicked(this::handleButtons);
        settings.setOnMouseClicked(this::handleButtons);
        exit.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        });
        vBox.getChildren().add(start);
        vBox.getChildren().add(settings);
        vBox.getChildren().add(exit);
        setCenter(vBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        setId("mainBorderPain");
        //setPrefSize(800,600);
    }

    protected void handleButtons(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        root.handleSceneChange(button.getText());
    }
}
