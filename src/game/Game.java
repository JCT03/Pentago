package game;
import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    private Board board;
    private Deque<Turn> turns;
    private Players turn;
    public Game(){
        board = new Board();
        turns = new ArrayDeque<Turn>();
        turn = Players.RED;
    }
    public Board getBoard() {
        return board;
    }
    public Players getTurn() {return turn;}

    public void takeTurn(int x, int y,Quadrants q, Rotation r) {
        board.setSpot(x, y, turn);
        if (r == Rotation.CLOCKWISE) {
            board.rotateQuadrantClockwise(q);
        }
        else {
            board.rotateQuadrantCounterclockwise(q);
        }
        turn = turn.getOpponent();
    }


}
