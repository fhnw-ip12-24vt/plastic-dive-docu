package main.ch.IP12.prototype.model;

public class Obstacle extends Moveable{
    public Obstacle(int x, int y, int speed, int length, int height, String spritePath) {
        super(x, y, speed, length, height, spritePath);
        //forces the Obstacle to move to the left side of the screen.
        this.direction = 180;
    }
}
