package blocks.layouts;

import blocks.Main;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SettingsLayout extends StackPane {
    private final Main root;
    private final Path path = Path.of("src/blocks/files/Settings.txt");
    private final Text text = new Text();
    private final VBox vBox = new VBox();
    private final Button back = new Button("Back");
    private String content;

    public SettingsLayout(Main main) {
        root = main;
        new Thread(() -> {
            try {
                content = Files.readString(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                text.setText(content);
            });
        }).start();
        text.setTextAlignment(TextAlignment.CENTER);
        text.setId("settingsText");
        back.setAlignment(Pos.CENTER);
        vBox.getChildren().add(text);
        vBox.getChildren().add(back);
        vBox.setSpacing(50);
        vBox.setAlignment(Pos.CENTER);
        getChildren().add(vBox);

        back.setOnMouseClicked(this::handleButtonBack);
    }

    protected void handleButtonBack(MouseEvent mouseEvent) {
        root.handleSceneChange("Main");
    }
}
