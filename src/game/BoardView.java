package game;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BoardView extends Parent {
    private Game g;
    private Board b;
    private Group Q1;
    private Rectangle r1;
    private Group Q2;
    private Rectangle r2;
    private Group Q3;
    private Rectangle r3;
    private Group Q4;
    private Rectangle r4;
    private Circle[][] spots;
    private int selectedX;
    private int selectedY;
    public BoardView(Game g) {
        selectedX = -1;
        selectedY = -1;
        spots = new Circle[6][6];
        this.g = g;
        b = g.getBoard();
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
                        Select((((int)c.getCenterX()-50)/100),(((int)c.getCenterY()-50)/100));
                    }
                });
                spots[x+3][y] = c;
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
                        Select((((int)c.getCenterX()-50)/100),(((int)c.getCenterY()-50)/100));
                    }
                });
                spots[x][y] = c;
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
                        Select((((int)c.getCenterX()-50)/100),(((int)c.getCenterY()-50)/100));
                    }
                });
                spots[x][y+3] = c;
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
                        Select((((int)c.getCenterX()-50)/100),(((int)c.getCenterY()-50)/100));
                    }
                });
                spots[x+3][y+3] = c;
                Q4.getChildren().add(c);
                c.toFront();
            }
        }

        getChildren().add(Q1);
        getChildren().add(Q2);
        getChildren().add(Q3);
        getChildren().add(Q4);
    }
    public void Select(int x1, int y1) {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6 ;y++ ) {
                spots[x][y].setStroke(Color.TAN);
                if (x == x1 & y == y1) {
                    spots[x][y].setStroke(Color.YELLOW);
                }
            }
        }
        selectedX = x1;
        selectedY = y1;
    }
    public int getSelectedX() {
        return selectedX;
    }
    public int getSelectedY() {
        return selectedY;
    }
    public void updateRotate() {
       Q1.setRotate(b.getQ1Rotation());
       Q2.setRotate(b.getQ2Rotation());
       Q3.setRotate(b.getQ3Rotation());
       Q4.setRotate(b.getQ4Rotation());
    }
    public void setFill(int x, int y,Players p) {
        spots[x][y].setFill(p.getFill());
    }
    public void updateBoard() {
        b.setQ1Rotation(0);
        b.setQ2Rotation(0);
        b.setQ3Rotation(0);
        b.setQ4Rotation(0);
        updateRotate();
        for (int x = 0; x<6;x++) {
            for (int y=0;y<6;y++) {
                spots[x][y].setStroke(Color.TAN);
                spots[x][y].setFill(b.getBoard()[x][y].getFill());
            }
        }
        selectedX = -1;
        selectedY = -1;
    }
}
