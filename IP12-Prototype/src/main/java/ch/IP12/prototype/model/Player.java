package ch.IP12.prototype.model;

import ch.IP12.prototype.model.animations.SpriteAnimation;
import ch.IP12.prototype.model.animations.Spritesheets;

public class Player extends Moveable{
    protected final boolean[] tempDir = new boolean[4];

    private final double initialXValue;
    private final double initialYValue;

    public Player(int x, int y, int speed, double maxX, double maxY, Spritesheets spriteSheet) {
        super(x, y, speed, maxX, maxY, spriteSheet, 3);
        this.initialXValue = x;
        this.initialYValue = y;
    }

    public Player(int x, int y, int speed, double maxX, double maxY, SpriteAnimation spriteAnimation) {
        super(x, y, speed, maxX, maxY, spriteAnimation, 3);
        this.initialXValue = x;
        this.initialYValue = y;
    }

    /**
     * Overridden move function from super class for reason of temporary control scheme
     */
    @Override
    public void move(double strength) {
        if(tempDir[0] && !tempDir[1] && !((x+length+speed) > maxX)){
            x += speed;
        } else if(tempDir[1] && !tempDir[0] && !((x-speed) < 0)){
            x -= speed;
        }
        if (tempDir[3] && !tempDir[2]  && !((y+height+speed) > maxY)) {
            y += speed;
        } else if (tempDir[2] && !tempDir[3] && !((y-speed) < 0)) {
            y -= speed;
        }
    }

    public void resetPosition() {
        x = initialXValue;
        y = initialYValue;
    }

    public void setTempDir(boolean val, int index) {
        tempDir[index] = val;
    }
}
