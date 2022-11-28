package game;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameController {
    @FXML
    private Pane pane;
    private Movement clock;
    private BoardView bv;

    @FXML
    public void initialize() {
        pane.getChildren().clear();
        Board g = new Board();
        clock = new Movement();
        bv = new BoardView(g);
        pane.getChildren().add(bv);
        clock.setBoard(g);
        startClock();
    }

    @FXML
    public void Q1CW() {
        if (clock.getIsReady()) {
            clock.startRotate(1, 1);
        }
    }
    @FXML
    public void Q1CCW() {
        if (clock.getIsReady()) {
            clock.startRotate(1, -1);
        }
    }
    @FXML
    public void Q2CW() {
        if (clock.getIsReady()) {
            clock.startRotate(2, 1);
        };
    }
    @FXML
    public void Q2CCW() {
        if (clock.getIsReady()) {
            clock.startRotate(2, -1);
        }
    }
    @FXML
    public void Q3CW() {
        if (clock.getIsReady()) {
            clock.startRotate(3, 1);
        }
    }
    @FXML
    public void Q3CCW() {
        if (clock.getIsReady()) {
            clock.startRotate(3, -1);
        }
    }
    @FXML
    public void Q4CW() {
        if (clock.getIsReady()) {
            clock.startRotate(4, 1);
        }
    }
    @FXML
    public void Q4CCW() {
        if (clock.getIsReady()) {
            clock.startRotate(4, -1);
        }
    }
    private class Movement extends AnimationTimer {

        private long FRAMES_PER_SEC = 90L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;
        private int RQ = 0;
        private int DR = 0;
        private int countdown = 0;
        private Board b;

        public void setBoard(Board b) {
            this.b = b;
        }
        public void startRotate(int RQ, int DR) {
            this.RQ = RQ;
            this.DR = DR;
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
                b.move(RQ,DR);
                countdown--;
                updateViews();
            }
            last = now;

        }

    }
    public void updateViews() {
        bv.Update();
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
