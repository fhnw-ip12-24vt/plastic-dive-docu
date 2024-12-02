package main.ch.IP12.prototype.model;

import main.ch.IP12.prototype.model.animations.SpriteAnimation;
import main.ch.IP12.prototype.model.animations.Spritesheets;

public class Obstacle extends Moveable{

    //randomizes whether the obstacles go up or down first
    private boolean waveUp = Math.random() > 0.5;
    public Obstacle(int x, int y, int speed, int length, int height, Spritesheets spriteSheet) {
        super(x, y, speed, length, height, spriteSheet);
        //forces the Obstacle to move to the left side of the screen.
        direction = 180;
    }

    public Obstacle(int x, int y, int speed, int length, int height, SpriteAnimation spriteAnimation) {
        super(x, y, speed, length, height, spriteAnimation);
        //forces the Obstacle to move to the left side of the screen.
        direction = 180;
    }

    @Override
    public void update(double deltaTime, double strength){
        //forces the direction of the obstacle to change over time
        if (waveUp){
            direction--;
        } else {
            direction++;
        }
        while(direction > 225 || direction < 135){
            if (direction < 135){
                direction++;
                waveUp = false;
            }
            if (direction > 225){
                direction--;
                waveUp = true;
            }
        }
        move(strength);
    }
}
