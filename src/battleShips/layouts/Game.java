package battleShips.layouts;

import battleShips.elements.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends BorderPane {
    GridPane playerOneField = new GridPane();
    GridPane playerTwoField = new GridPane();
    HBox fields = new HBox();
    Stock playerOneStock = new Stock("p1");
    Stock playerTwoStock = new Stock("p2");
    Console console = new Console();
    ArrayList<Ship> p1Ships = new ArrayList<>();
    ArrayList<Ship> p2Ships = new ArrayList<>();
    Ship selected;
    private final EventHandler<MouseEvent> selectShip = new EventHandler<>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("valami van");
            Button b = (Button) mouseEvent.getSource();
            int rowIndex = GridPane.getRowIndex(b);
            selected = p1Ships.get(rowIndex);
            for (Node child : playerOneStock.getChildren()) {
                if (GridPane.getRowIndex(child) == rowIndex && child.getClass().equals(Button.class)) {
                    Button button = (Button) child;
                    button.setId("selected");
                } else if (child.getClass().equals(Button.class)) {
                    Button button = (Button) child;
                    button.setId("stockShip");
                }
            }
        }
    };
    private final EventHandler<MouseEvent> placeShip = new EventHandler<>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (selected != null) {
                EventType<? extends MouseEvent> eventType = mouseEvent.getEventType();
                if (MouseEvent.MOUSE_MOVED.equals(eventType) || MouseEvent.MOUSE_CLICKED.equals(eventType)) {
                    OceanField b = (OceanField) mouseEvent.getSource();
                    Direction direction = selected.getDirection();
                    int rowIndex = GridPane.getRowIndex(b);
                    int columnIndex = GridPane.getColumnIndex(b);
                    int shipSize = selected.getSize();
                    GridPane gridPane = (GridPane) b.getParent();
                    for (Node child : gridPane.getChildren()) {
                        OceanField o = (OceanField) child;
                        if (o.getShip() == null) {
                            o.setId("myOcean");
                        }
                    }
                    ArrayList<OceanField> oceanFields = new ArrayList<>();
                    if (direction.equals(Direction.HORIZONTAL)) {
                        if (rowIndex + shipSize <= gridPane.getColumnCount()) {
                            for (int i = 0; i < shipSize; i++) {
                                OceanField oceanField = (OceanField) getNodeByRowColumnIndex(rowIndex + i, columnIndex, gridPane);
                                oceanFields.add(oceanField);
                            }
                        } else {
                            for (int i = 0; i < shipSize; i++) {
                                OceanField oceanField = (OceanField) getNodeByRowColumnIndex(rowIndex - i, columnIndex, gridPane);
                                oceanFields.add(oceanField);
                            }
                        }
                    } else {
                        if (columnIndex + shipSize <= gridPane.getRowCount()) {
                            for (int i = 0; i < shipSize; i++) {
                                OceanField oceanField = (OceanField) getNodeByRowColumnIndex(rowIndex, columnIndex + i, gridPane);
                                oceanFields.add(oceanField);
                            }
                        } else {
                            for (int i = 0; i < shipSize; i++) {
                                OceanField oceanField = (OceanField) getNodeByRowColumnIndex(rowIndex, columnIndex - i, gridPane);
                                oceanFields.add(oceanField);
                            }
                        }
                    }
                    AtomicBoolean badPlace = new AtomicBoolean(false);
                    oceanFields.forEach(node -> {
                        if (node.getShip() != null) {
                            badPlace.set(true);
                        }
                    });
                    if (!badPlace.get()) {
                        oceanFields.forEach(node -> {
                            node.setId("fieldSelected");
                        });
                    }
                }
                if (MouseEvent.MOUSE_CLICKED.equals(eventType)) {
                    System.out.println("########-click-########");
                    System.out.println(mouseEvent.getTarget().toString());
                    System.out.println(mouseEvent.getSource().toString());
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {

                    }
                } else {

                }
            }
        }
    };
    private final EventHandler<MouseEvent> rotateShip = new EventHandler<>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (selected != null) {
                EventType<? extends MouseEvent> eventType = mouseEvent.getEventType();
                if (MouseEvent.MOUSE_CLICKED.equals(eventType)) {
                    if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                        selected.rotate();
                    }
                }
            }
        }
    };

    public Game() {
        setBottom(console);
        setCenter(fields);
        setLeft(playerOneStock);
        setRight(playerTwoStock);
        fields.getChildren().addAll(playerOneField, playerTwoField);
        fields.setAlignment(Pos.CENTER);
        fields.setId("field");
        console.setPrefRowCount(6);
        console.log("1");
        for (int i = 0; i < 8; i++) {
            playerOneField.addRow(i, new OceanField(), new OceanField(), new OceanField(), new OceanField(),
                    new OceanField(), new OceanField(), new OceanField(), new OceanField());
            playerOneField.getChildren().forEach(node -> {
                node.setId("myOcean");
            });
            playerTwoField.addRow(i, new OceanField(), new OceanField(), new OceanField(), new OceanField(),
                    new OceanField(), new OceanField(), new OceanField(), new OceanField());
            playerTwoField.getChildren().forEach(node -> {
                node.setId("myOcean");
            });
        }
        playerOneField.setHgap(3);
        playerOneField.setVgap(3);
        playerTwoField.setHgap(3);
        playerTwoField.setVgap(3);
        fields.setSpacing(100);
        playerOneField.setAlignment(Pos.CENTER);
        playerTwoField.setAlignment(Pos.CENTER);
        preparationState();
    }

    private void preparationState() {
        for (int i = 0; i < 5; i++) {
            p1Ships.add(new Ship(i));
        }
        for (Node child : playerOneStock.getChildren()) {
            if (child.getClass().equals(Button.class)) {
                Button b = (Button) child;
                b.setOnMouseClicked(selectShip);
                //b.addEventHandler(MouseEvent.MOUSE_CLICKED, selectShip);
            }
        }
        playerOneStock.setOnMouseClicked(mouseEvent -> {
            for (Node child : playerOneStock.getChildren()) {
                if (child.getClass().equals(Button.class)) {
                    Button button = (Button) child;
                    button.setId("stockShip");
                }
            }
            selected = null;
        });
        playerOneField.getChildren().forEach(node -> {
            node.addEventHandler(MouseEvent.ANY, placeShip);
            node.addEventFilter(MouseEvent.ANY, rotateShip);
        });
        //this.addEventFilter(MouseEvent.ANY,rotateShip);
        console.log("Place your ships.");
    }

    private void battleState() {
        console.log("The battle is started!");
        for (Node child : playerOneField.getChildren()) {
            child.setId("");
        }
    }

    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}
