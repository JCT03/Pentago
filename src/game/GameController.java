package game;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;


public class GameController {
    @FXML
    private Pane pane;
    @FXML
    private ChoiceBox<String> selectQuadrant;
    @FXML
    private ChoiceBox<String> selectRotate;
    private Movement clock;
    private BoardView bv;
    Game g;


    @FXML
    public void initialize() {
        pane.getChildren().clear();
        clock = new Movement();
        g = new Game();
        for (Quadrants q: Quadrants.values()) {
            selectQuadrant.getItems().add(q.getText());
        }
        for (Rotation r: Rotation.values()) {
            selectRotate.getItems().add(r.getText());
        }
        selectQuadrant.getSelectionModel().select(Quadrants.Q2.getText());
        selectRotate.getSelectionModel().select(Rotation.CLOCKWISE.getText());
        bv = new BoardView(g);
        pane.getChildren().add(bv);
        clock.setBoard(g.getBoard());
        startClock();
    }
    public void takeTurn() {
        if (bv.getSelectedX()>= 0 && bv.getSelectedY() >= 0 & clock.getIsReady()) {
            Quadrants q= Quadrants.Q2;
            Rotation r= Rotation.CLOCKWISE;
            for (Quadrants qTemp:Quadrants.values()) {
                if (selectQuadrant.getSelectionModel().getSelectedItem().equals(qTemp.getText())) {
                    q = qTemp;
                }
            }
            for (Rotation rTemp:Rotation.values()) {
                if (selectRotate.getSelectionModel().getSelectedItem().equals(rTemp.getText())) {
                    r = rTemp;
                }
            }
            bv.setFill(bv.getSelectedX(), bv.getSelectedY(),g.getTurn());
            g.takeTurn(bv.getSelectedX(), bv.getSelectedY(), q,r);
            clock.startRotate(q,r);
        }
    }

    private class Movement extends AnimationTimer {

        private long FRAMES_PER_SEC = 90L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;
        private Quadrants q = Quadrants.Q1;
        private Rotation r = Rotation.CLOCKWISE;
        private int countdown = 0;
        private Board b;

        public void setBoard(Board b) {
            this.b = b;
        }
        public void startRotate(Quadrants q, Rotation r) {
            this.q = q;
            this.r = r;
            countdown = 90;
        }
        public Boolean getIsReady() {
            if (countdown == 0) {
                return true;
            }
            return false;
        }


        @Override
        public void handle(long now) {

            if (now - last > INTERVAL && countdown >0) {
                b.move(q,r);
                countdown--;
                updateRotate();
                if (countdown == 0) {
                    updateViews();
                }
            }
            last = now;

        }

    }
    public void updateRotate() {
        bv.updateRotate();
    }
    public void updateViews() {
        bv.updateBoard();
    }
    @FXML
    private void startClock() {
        clock.start();
    }
    @FXML
    private void stopClock() {
        clock.stop();
    }

}
