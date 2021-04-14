package battleShips;

import battleShips.layouts.Game;
import battleShips.layouts.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleShips extends Application {
    private final MainMenu mainMenu = new MainMenu(this);
    private final String mainMenuStyle = this.getClass().getResource("style/MainMenuStyle.css").toExternalForm();
    private final String gameStyle = this.getClass().getResource("style/GameStyle.css").toExternalForm();
    private Scene scene;
    private Game game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setUpGame();
        primaryStage.setScene(scene);
        primaryStage.setTitle("BattleShips");
        primaryStage.show();
    }

    private void setUpGame() {
        scene = new Scene(mainMenu, 1280, 600);
        mainMenu.getStylesheets().add(mainMenuStyle);
    }

    public void newGame() {
        game = new Game();
        scene.setRoot(game);
        game.getStylesheets().add(gameStyle);
    }

    public void endGame() {

    }

    public void settings() {
        System.out.println("####################### settings() is called");
    }
}
