package game;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BoardView extends Parent {
    private Board g;
    private Group Q1;
    private Rectangle r1;
    private Group Q2;
    private Rectangle r2;
    private Group Q3;
    private Rectangle r3;
    private Group Q4;
    private Rectangle r4;

    public BoardView(Board g) {
        this.g = g;
        r1 = new Rectangle();
        r1.setHeight(300);
        r1.setWidth(300);
        r1.setX(300);
        r1.setY(0);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.BURLYWOOD);
        Q1 = new Group();
        Q1.getChildren().add(r1);
        for (int x = 0; x < 3;x++) {
            for (int y = 0; y < 3; y++) {
                Circle c = new Circle();
                c.setRadius(40);
                c.setCenterX(100 * x + 350);
                c.setCenterY(100 * y + 50);
                c.setFill(Color.TAN);
                c.setOnMouseClicked(event -> {
                    if (c.getFill() == Color.TAN) {
                        c.setFill(g.takeTurn());
                    }
                });
                Q1.getChildren().add(c);
                c.toFront();
            }
        }
        r2 = new Rectangle();
        r2.setHeight(300);
        r2.setWidth(300);
        r2.setX(0);
        r2.setY(0);
        r2.setStroke(Color.BLACK);
        r2.setFill(Color.BURLYWOOD);
        Q2 = new Group();
        Q2.getChildren().add(r2);
        for (int x = 0; x < 3;x++) {
            for (int y = 0; y < 3; y++) {
                Circle c = new Circle();
                c.setRadius(40);
                c.setCenterX(100 * x + 50);
                c.setCenterY(100 * y + 50);
                c.setFill(Color.TAN);
                c.setOnMouseClicked(event -> {
                    if (c.getFill() == Color.TAN) {
                        c.setFill(g.takeTurn());
                    }
                });
                Q2.getChildren().add(c);
                c.toFront();
            }
        }
        r3 = new Rectangle();
        r3.setHeight(300);
        r3.setWidth(300);
        r3.setX(0);
        r3.setY(300);
        r3.setStroke(Color.BLACK);
        r3.setFill(Color.BURLYWOOD);
        Q3 = new Group();
        Q3.getChildren().add(r3);
        for (int x = 0; x < 3;x++) {
            for (int y = 0; y < 3; y++) {
                Circle c = new Circle();
                c.setRadius(40);
                c.setCenterX(100 * x + 50);
                c.setCenterY(100 * y + 350);
                c.setFill(Color.TAN);
                c.setOnMouseClicked(event -> {
                    if (c.getFill() == Color.TAN) {
                        c.setFill(g.takeTurn());
                    }
                });
                Q3.getChildren().add(c);
                c.toFront();
            }
        }
        r4 = new Rectangle();
        r4.setHeight(300);
        r4.setWidth(300);
        r4.setX(300);
        r4.setY(300);
        r4.setStroke(Color.BLACK);
        r4.setFill(Color.BURLYWOOD);
        Q4 = new Group();
        Q4.getChildren().add(r4);
        for (int x = 0; x < 3;x++) {
            for (int y = 0; y < 3; y++) {
                Circle c = new Circle();
                c.setRadius(45);
                c.setCenterX(100 * x + 350);
                c.setCenterY(100 * y + 350);
                c.setFill(Color.TAN);
                c.setOnMouseClicked(event -> {
                    if (c.getFill() == Color.TAN) {
                        c.setFill(g.takeTurn());
                    }
                });
                Q4.getChildren().add(c);
                c.toFront();
            }
        }

        getChildren().add(Q1);
        getChildren().add(Q2);
        getChildren().add(Q3);
        getChildren().add(Q4);
    }
    public void Update() {
        Q1.setRotate(g.getQ1Rotation());
        Q2.setRotate(g.getQ2Rotation());
        Q3.setRotate(g.getQ3Rotation());
        Q4.setRotate(g.getQ4Rotation());
    }
}
