package ch.IP12.prototype.model;

import ch.IP12.prototype.model.animations.SpriteAnimation;
import ch.IP12.prototype.model.animations.Spritesheets;

import java.util.Random;

public class Obstacle extends Moveable{
    //randomizes whether the obstacles go up or down first
    private final int maxAnglechange = 55;
    private boolean waveUp = Math.random() > 0.5;

    public Obstacle(int x, int y, int speed, double maxX, double maxY, Spritesheets spriteSheet) {
        super(x, y, speed, maxX, maxY, spriteSheet,(int)((Math.random()+0.5)*2));
        //forces the Obstacle to move to the left side of the screen.
        direction = 180;
    }

    public Obstacle(int x, int y, int speed, double maxX, double maxY, SpriteAnimation spriteAnimation) {
        super(x, y, speed, maxX, maxY, spriteAnimation,(int)((Math.random()+3)*0.5));
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
        while(direction > (180+maxAnglechange) || direction < (180-maxAnglechange)){
            if (direction < (180-maxAnglechange)){
                direction++;
                waveUp = false;
            }
            if (direction > (180+maxAnglechange)){
                direction--;
                waveUp = true;
            }
        }
        move(strength);
    }
}
