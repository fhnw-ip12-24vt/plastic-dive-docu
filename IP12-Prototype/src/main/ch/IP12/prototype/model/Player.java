package main.ch.IP12.prototype.model;

public class Player extends Moveable{
    public boolean moving = false;
    public boolean[] tempDir = new boolean[4];

    public Player(int x, int y, int speed, int length, int height, String spritePath) {
        super(x, y, speed, length, height, spritePath);
    }

    /**
     * Overridden move function from super class for reason of temporary control scheme
     */
    @Override
    public void move() {
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
}
