package game;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.ArrayList;

public class Game {
    private Board board;
    private Stack<Turn> turns;
    private Players turn;
    private State gameState;
    public Game(){
        board = new Board();
        turns = new Stack<Turn>();
        turn = Players.RED;
        gameState = State.NOWINNER;
    }
    public Board getBoard() {
        return board;
    }
    public Players getTurn() {return turn;}

    public void takeTurn(int x, int y,Quadrants q, Rotation r) {
        turns.push(new Turn(q,r,x,y));
        board.setSpot(x, y, turn);
        if (r == Rotation.CLOCKWISE) {
            board.rotateQuadrantClockwise(q);
        }
        else {
            board.rotateQuadrantCounterclockwise(q);
        }
        turn = turn.getOpponent();
    }
    public void undoTurn() {
        Turn undo = turns.pop();
        if (undo.getRotation().getOpposite() == Rotation.CLOCKWISE) {
            board.rotateQuadrantClockwise(undo.getQuadrant());
        }
        else {
            board.rotateQuadrantCounterclockwise(undo.getQuadrant());
        }
        board.setSpot(undo.getX(), undo.getY(), Players.EMPTY);
        turn = turn.getOpponent();
    }
    public boolean lastCheck() {
        return ((!turns.empty()));
    }
    public Rotation getLastRotate() {
        return turns.peek().getRotation().getOpposite();
    }
    public Quadrants getLastQuadrant() {
        return turns.peek().getQuadrant();
    }
    public void checkWinner() { //Based on tic-tac-toe lab
        ArrayList<Players[]> paths = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j + 4 < 6) {
                    paths.add(new Players[]{board.getBoard()[i][j],board.getBoard()[i][j+1], board.getBoard()[i][j+2], board.getBoard()[i][j+3], board.getBoard()[i][j+4]});
                }
                if (i + 4 < 6) {
                    paths.add(new Players[]{board.getBoard()[i][j],board.getBoard()[i+1][j], board.getBoard()[i+2][j], board.getBoard()[i+3][j], board.getBoard()[i+4][j]});
                }
                if (i + 4 < 6 && j + 4 < 6) {
                    paths.add(new Players[]{board.getBoard()[i][j],board.getBoard()[i+1][j+1], board.getBoard()[i+2][j+2], board.getBoard()[i+3][j+3], board.getBoard()[i+3][j+4]});
                    paths.add(new Players[]{board.getBoard()[i+4][j],board.getBoard()[i+3][j+1], board.getBoard()[i+2][j+2], board.getBoard()[i+1][j+3], board.getBoard()[i][j+4]});
                }
            }
        }
        boolean red = false;
        boolean black = false;
        for (Players[] path: paths) {
            if (path[0] == path[1] && path[1] == path[2] && path[2] == path[3] && path[3] == path[4]) {
                if (path[0] == Players.RED) {
                    red = true;
                } else if (path[0] == Players.BLACK) {
                    black = true;
                }
            }
        }
        if (red & black) {
            gameState = State.DRAW;
        } else if (red) {
            gameState = State.REDWIN;
        } else if (black) {
            gameState = State.BLACKWIN;
        } else if(turns.size() == 36) {
            gameState = State.DRAW;
        } else {
            gameState = State.NOWINNER;
        }
    }
    public State getGameState() {
        return gameState;
    }
}
