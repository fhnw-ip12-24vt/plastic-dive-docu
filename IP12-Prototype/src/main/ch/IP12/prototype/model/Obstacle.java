package main.ch.IP12.prototype.model;

public class Obstacle extends Moveable{
    private boolean waveUp = false;
    public Obstacle(int x, int y, int speed, int length, int height, String spritePath) {
        super(x, y, speed, length, height, spritePath);
        //forces the Obstacle to move to the left side of the screen.
        this.direction = 180;
    }

    @Override
    public void update(double deltaTime){
        //forces the direction of the obstacle to change over time
        if (waveUp){
            direction--;
            if (direction < 135){
                waveUp = false;
            }

        } else {
            direction++;
            if (direction > 225){
                waveUp = true;
            }
        }
        move();
    }
}
