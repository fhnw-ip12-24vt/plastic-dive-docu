package ch.IP12.prototype.model;

import ch.IP12.prototype.model.animations.SpriteAnimation;
import ch.IP12.prototype.model.animations.Spritesheets;

public class Player extends Moveable{
    protected final boolean[] tempDir = new boolean[4];

    public Player(int x, int y, int speed, int length, int height, Spritesheets spriteSheet) {
        super(x, y, speed, length, height, spriteSheet);
    }

    public Player(int x, int y, int speed, int length, int height, SpriteAnimation spriteAnimation) {
        super(x, y, speed, length, height, spriteAnimation);
    }

    /**
     * Overridden move function from super class for reason of temporary control scheme
     */
    @Override
    public void move(double strength) {
        if(tempDir[0] && !tempDir[1]){
            x += speed;
        } else if(tempDir[1] && !tempDir[0]){
            x -= speed;
        }
        if (tempDir[3] && !tempDir[2]) {
            y += speed;
        } else if (tempDir[2] && !tempDir[3]) {
            y -= speed;
        }
    }

    public void setTempDir(boolean val, int index) {
        tempDir[index] = val;
    }
}
