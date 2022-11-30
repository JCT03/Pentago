package game;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Game {
    private Board board;
    private Stack<Turn> turns;
    private Players turn;
    public Game(){
        board = new Board();
        turns = new Stack<Turn>();
        turn = Players.RED;
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


}
