package game;

import javafx.scene.paint.Color;

public class Board {
    int Q1Rotation;
    int Q2Rotation;
    int Q3Rotation;
    int Q4Rotation;
    Players[][] Q1;
    Players[][] Q2;
    Players[][] Q3;
    Players[][] Q4;

    public Board() {
        Players[][] Q1 = new Players[3][3];
        Players[][] Q2 = new Players[3][3];
        Players[][] Q3 = new Players[3][3];
        Players[][] Q4 = new Players[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Q1[x][y] = Players.EMPTY;
                Q2[x][y] = Players.EMPTY;
                Q3[x][y] = Players.EMPTY;
                Q4[x][y] = Players.EMPTY;
            }
        }
        Q1Rotation = 0;
        Q2Rotation = 0;
        Q3Rotation = 0;
        Q4Rotation = 0;
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
    public void rotateQuadrantClockwise(Quadrants q){
        if (q == Quadrants.Q1) {
            Q1 = clockwiseRotateHelper(Q1);
        } else if (q == Quadrants.Q2) {
            Q2 = clockwiseRotateHelper(Q2);
        } else if (q == Quadrants.Q3) {
            Q3 = clockwiseRotateHelper(Q3);
        } else if (q == Quadrants.Q4) {
            Q4 = clockwiseRotateHelper(Q4);
        }
    }
    public Players[][] clockwiseRotateHelper(Players[][] q) {
        Players[][] temp = q;
        q[0][0] = temp[2][0];
        q[0][1] = temp[1][0];
        q[0][2] = temp[0][0];
        q[1][0] = temp[2][1];
        q[1][2] = temp[0][1];
        q[2][0] = temp[2][2];
        q[2][1] = temp[1][2];
        q[2][2] = temp[0][2];
        return q;
    }
    public void rotateQuadrantCounterclockwise(Quadrants q){
        if (q == Quadrants.Q1) {
            Q1 = counterclockwiseRotateHelper(Q1);
        } else if (q == Quadrants.Q2) {
            Q2 = counterclockwiseRotateHelper(Q2);
        } else if (q == Quadrants.Q3) {
            Q3 = counterclockwiseRotateHelper(Q3);
        } else if (q == Quadrants.Q4) {
            Q4 = counterclockwiseRotateHelper(Q4);
        }
    }
    public Players[][] counterclockwiseRotateHelper(Players[][] q) {
        Players[][] temp = q;
        q[0][0] = temp[0][2];
        q[0][1] = temp[1][2];
        q[0][2] = temp[2][2];
        q[1][0] = temp[0][1];
        q[1][2] = temp[2][1];
        q[2][0] = temp[0][0];
        q[2][1] = temp[1][0];
        q[2][2] = temp[2][0];
        return q;
    }
    public void setSpot(int x, int y,Players p) {
        if (x<3 && y <3) {
            Q2[x][y]= p;
        } else if (x<3) {
            Q1[x][y%3] = p;
        } else if (y<3) {
            Q3[x%3][y] = p;
        } else {
            Q4[x%3][y%3] = p;
        }
    }
    public Players getSpot(int x, int y) {
        if (x < 3 && y < 3) {
            return Q2[x][y];
        } else if (x < 3) {
            return Q1[x][y % 3];
        } else if (y < 3) {
            return Q3[x % 3][y];
        } else {
            return Q4[x % 3][y % 3];
        }
    }
    public Players[][] getBoard() {
        Players[][] board = new Players[6][6];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y <3; y++) {
                board[x][y] = Q2[x][y];
                board[x][y+3]= Q1[x][y];
                board[x+3][y] = Q3[x][y];
                board[x+3][y+3] = Q4[x][y];
            }
        }

        return board;
    }


}
