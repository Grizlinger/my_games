package battleShips.elements;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Stock extends GridPane {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Label l1;
    Label l2;
    Label l3;
    Label l4;
    Label name;

    public Stock(String id) {
        setVgap(5);
        setButtons();
        if (id.equals("p1")) {
            name = new Label("5");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(0, b1, b2, b3, b4, b5, l1, name);
            setButtons();
            name = new Label("4");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(1, b1, b2, b3, b4, l1, l2, name);
            setButtons();
            name = new Label("3");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(2, b1, b2, b3, l1, l2, l3, name);
            setButtons();
            name = new Label("3");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(3, b1, b2, b3, l1, l2, l3, name);
            setButtons();
            name = new Label("2");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(4, b1, b2, l1, l2, l3, l4, name);
        } else {
            setButtons();
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            name = new Label("5");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(0, name, l4, b1, b2, b3, b4, b5);
            setButtons();
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            name = new Label("4");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(1, name, l4, l1, b1, b2, b3, b4);
            setButtons();
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            name = new Label("3");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(2, name, l4, l1, l2, b1, b2, b3);
            setButtons();
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            name = new Label("3");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(3, name, l4, l1, l2, b1, b2, b3);
            setButtons();
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            name = new Label("2");
            name.setPrefSize(20, 20);
            name.setId("stockLabel");
            this.addRow(4, name, l4, l1, l2, l3, b1, b2);
        }
        this.setAlignment(Pos.CENTER);
        this.setId(id);
    }

    private void setButtons() {
        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b1.setId("stockShip");
        b2.setId("stockShip");
        b3.setId("stockShip");
        b4.setId("stockShip");
        b5.setId("stockShip");
        b1.setPrefSize(20, 20);
        b2.setPrefSize(20, 20);
        b3.setPrefSize(20, 20);
        b4.setPrefSize(20, 20);
        b5.setPrefSize(20, 20);
        l1 = new Label();
        l2 = new Label();
        l3 = new Label();
        l4 = new Label();
        l1.setPrefSize(20, 20);
        l2.setPrefSize(20, 20);
        l3.setPrefSize(20, 20);
        l4.setPrefSize(20, 20);
    }
}
