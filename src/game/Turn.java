package game;

public class Turn {
    private Quadrants quadrant;
    private Rotation rotation;
    private int x;
    private int y;
    public Turn(Quadrants quadrant,Rotation rotation, int x, int y){
        this.quadrant = quadrant;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
    }
    public Quadrants getQuadrant() {
        return quadrant;
    }
    public Rotation getRotation() {
        return rotation;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
}
