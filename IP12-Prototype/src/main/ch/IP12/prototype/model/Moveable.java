package main.ch.IP12.prototype.model;

import main.ch.IP12.prototype.utils.IntUtils;

public abstract class Moveable {
    public int x;
    public int y;
    public final int speed;
    public int length;
    public int height;
    //path to animation images
    public String spritePath;

    Moveable(int x, int y, int speed, int length, int height, String spritePath) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
        this.height = height;
        this.spritePath = spritePath;
    }

    /**
     * Updates the Object instance every x...
     * @param deltaTime
     */
    public void update(double deltaTime){
        move(0);
    }

    /**
     * Moves the moveable object in the specified direction.
     * @param direction
     */
    public void move(int direction) {

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
}
