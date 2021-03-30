package blocks.support.threads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadIntegerFromFile implements Runnable {
    private Path path;
    private ArrayList<Integer> elements;

    public ReadIntegerFromFile(Path path, ArrayList<Integer> elements) {
        this.path = path;
        this.elements = elements;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(new File(path.toString()))) {
            elements.clear();
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                elements.add(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
