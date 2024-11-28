package main.ch.IP12.prototype.model;

import main.ch.IP12.prototype.model.animations.SpriteAnimation;
import main.ch.IP12.prototype.model.animations.Spritesheets;
import main.ch.IP12.prototype.utils.IntUtils;

public abstract class Moveable {
    public int x;
    public int y;
    public final int speed;
    public final int length;
    public final int height;
    public int direction;
    final boolean moving = true;
    //path to animation images
    public final SpriteAnimation spriteAnimation;

    Moveable(int x, int y, int speed, int length, int height, Spritesheets spriteSheet) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
        this.height = height;
        this.spriteAnimation = spriteSheet.getSpriteAnimation();
    }

    Moveable(int x, int y, int speed, int length, int height, SpriteAnimation spriteAnimation) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
        this.height = height;
        this.spriteAnimation = spriteAnimation;
    }

    /**
     * Updates the Object instance every x...
     * @param deltaTime
     */
    public void update(double deltaTime, float strength){
        if(moving){
            move(strength);
        }
        nextFrame();
    }

    /**
     * Moves the moveable object in the specified direction.
     */
    public void move(float strength) {
        x += (int)(Math.cos(Math.toRadians(direction))*(speed*strength));
        y += (int)(Math.sin(Math.toRadians(direction))*(speed*strength));
    }

    /**
     * Checks if the current instance collides with another object.
     * @param moveable Object to be checked for overlap.
     * @return Boolean value of the check
     */
    public boolean collidesWith(Moveable moveable) {
        return IntUtils.isRangeInRange(moveable.x, moveable.x+moveable.length, this.x, this.x+this.length)
                && IntUtils.isRangeInRange(moveable.y, moveable.y+moveable.height, this.y, this.y+this.height);
    }

    protected void nextFrame(){

    }
}
