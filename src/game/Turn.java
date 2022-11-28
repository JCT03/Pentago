package game;

public class Turn {
    Quadrants quadrant;
    Rotation rotation;
    int x;
    int y;
    public void Turn(Quadrants quadrant,Rotation rotation, int x, int y){
        quadrant = this.quadrant;
        rotation = this.rotation;
        x = this.x;
        y = this.y;
    }
}
