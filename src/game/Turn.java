package game;

public class Turn {
    private Quadrants quadrant;
    private Rotation rotation;
    private int x;
    private int y;
    public void Turn(Quadrants quadrant,Rotation rotation, int x, int y){
        quadrant = this.quadrant;
        rotation = this.rotation;
        x = this.x;
        y = this.y;
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
