package game;

import javafx.scene.paint.Color;

public class Board {
    int Q1Rotation;
    int Q2Rotation;
    int Q3Rotation;
    int Q4Rotation;
    Color turn;

    public Board() {

        Q1Rotation = 0;
        Q2Rotation = 0;
        Q3Rotation = 0;
        Q4Rotation = 0;
        turn = Color.RED;
    }


    public Color takeTurn() {
        Color ret = turn;
        if (turn.equals(Color.RED)) {
            turn = Color.BLACK;
        } else {
            turn = Color.RED;
        }
        return ret;
    }

    public void setQ1Rotation(int r) {
        Q1Rotation =r;
    }
    public void setQ2Rotation(int r) {
        Q2Rotation =r;
    }
    public void setQ3Rotation(int r) {
        Q3Rotation =r;
    }
    public void setQ4Rotation(int r) {
        Q4Rotation =r;
    }
    public int getQ1Rotation() {
        return Q1Rotation;
    }
    public int getQ2Rotation() {
        return Q2Rotation;
    }
    public int getQ3Rotation() {
        return Q3Rotation;
    }
    public int getQ4Rotation() {
        return Q4Rotation;
    }
    public void move (int q,int r) {
        if (q==1) {
            setQ1Rotation(getQ1Rotation()+r);
        } else if (q==2) {
            setQ2Rotation(getQ2Rotation()+r);
        } else if (q==3) {
            setQ3Rotation(getQ3Rotation()+r);
        }else if (q==4) {
            setQ4Rotation(getQ4Rotation()+r);
        }
    }


}
