package blocks;

import blocks.layouts.GameLayout;
import blocks.layouts.MainLayout;
import blocks.layouts.SettingsLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;
    protected Scene scene;

    protected MainLayout mainLayout = new MainLayout(this);
    protected SettingsLayout settingsLayout = new SettingsLayout(this);
    protected GameLayout gameLayout = new GameLayout();

    protected String style = this.getClass().getResource("style/style.css").toExternalForm();

    @Override
    public void start(Stage primaryStage) {
        scene = new Scene(mainLayout);
        scene.getStylesheets().add(style);

        stage = primaryStage;
        stage.setTitle("Blocks");
        stage.setScene(scene);
        stage.show();
    }
    public void handleSceneChange(String name) {
        switch (name) {
            case "Main":
                scene.setRoot(mainLayout);
                break;
            case "Start":
                System.out.println("start");
                scene.setRoot(gameLayout);
                break;
            case "Settings":
                System.out.println("settings");
                scene.setRoot(settingsLayout);
                break;
            case "game":
                scene.setRoot(gameLayout);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
