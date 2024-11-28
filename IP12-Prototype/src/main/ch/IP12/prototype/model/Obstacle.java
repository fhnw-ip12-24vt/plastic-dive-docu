package main.ch.IP12.prototype.model;

public class Obstacle extends Moveable{
    //forces the Obstacle to move to the left side of the screen.
    //private int direction;

    //randomizes whether the obstacles go up or down first
    private boolean waveUp = Math.random() > 0.5;
    public Obstacle(int x, int y, int speed, int length, int height, String spritePath) {
        super(x, y, speed, length, height, spritePath);
        direction = 180;
    }

    @Override
    public void update(double deltaTime, float strength){
        //forces the direction of the obstacle to change over time
        if (waveUp){
            direction--;
        } else {
            direction++;
        }
        while(direction > 225 || direction < 135){
            if (direction < 135){
                direction++;
                waveUp = !waveUp;
            }
            if (direction > 225){
                direction--;
                waveUp = !waveUp;
            }
        }
        move(strength);
    }
}
