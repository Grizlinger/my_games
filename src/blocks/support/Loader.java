package blocks.support;

import blocks.elements.Brick;
import blocks.layouts.GameLayout;
import blocks.support.threads.ReadIntegerFromFile;
import javafx.application.Platform;

import java.nio.file.Path;
import java.util.ArrayList;


public class Loader implements Runnable {
    private GameLayout gameLayout;
    private Path path;
    private ArrayList<Integer> map = new ArrayList<>();

    public Loader(GameLayout gameLayout) {
        this.gameLayout = gameLayout;
    }

    @Override
    public void run() {
        ReadIntegerFromFile reader = new ReadIntegerFromFile(path, map);
        Thread readerThread = new Thread(reader);
        readerThread.start();
        try {
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < map.size() / (map.size() / 5); i++) {
            for (int j = 0; j < map.size() / 5; j++) {
                if (map.get(j + i * map.size() / 5) == 1) {
                    bricks.add(new Brick(
                            j * (gameLayout.getScene().getWindow().getWidth() - 20) / (map.size() / (map.size() / 5)) + 2,
                            i * 22 + 100,
                            (gameLayout.getScene().getWindow().getWidth() - 20) / (map.size() / (map.size() / 5)) - 2,
                            20,
                            1
                    ));
                }
            }
        }
        Platform.runLater(() -> {
            gameLayout.setBricks(bricks);
            gameLayout.loadLayout();
        });


    }

    public void loadMP(int lvl) {
        this.path = Path.of("src/blocks/files/maps/lvl" + lvl + ".mp");
        new Thread(this).start();
    }
}
