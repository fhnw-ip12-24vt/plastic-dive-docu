package main.ch.IP12.prototype.model;

public abstract class Moveable {
    public int x;
    public int y;
    private final int speed;
    public int length;
    public int height;
    public String spritePath;

    Moveable(int x, int y, int speed, int length, int height, String spritePath) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
        this.height = height;
        this.spritePath = spritePath;
           };
    public void update(double deltaTime){
        move(0);
    }
    public void move(int direction){

    }

    public boolean cloidesWith(Moveable moveable) {
        return true;
    }
}
