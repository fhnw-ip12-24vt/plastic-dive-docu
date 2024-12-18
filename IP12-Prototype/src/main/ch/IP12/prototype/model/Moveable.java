package ch.IP12.prototype.model;

import ch.IP12.prototype.model.animations.SpriteAnimation;
import ch.IP12.prototype.model.animations.Spritesheets;
import ch.IP12.prototype.utils.IntUtils;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class Moveable {
    protected double x;
    protected double y;
    protected final int speed;
    protected final int length;
    protected final int height;
    protected int direction;

    protected final double maxX;
    protected final double maxY;

    //path to animation images
    protected final SpriteAnimation animation;

    Moveable(int x, int y, int speed, int length, int height, double maxX, double maxY, Spritesheets spritesheets){
        this(x, y, speed, length, height, maxX, maxY, spritesheets.getSpriteAnimation());
    }

    Moveable(int x, int y, int speed, int length, int height, double maxX, double maxY, SpriteAnimation spriteAnimation) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.length = length;
        this.height = height;
        this.animation = spriteAnimation;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Updates the Object instance every x...
     * @param deltaTime
     */
    public void update(double deltaTime, double strength){
        move(strength);
    }

    /**
     * Moves the moveable object in the specified direction.
     */
    public void move(double strength) {
        x += (Math.cos(Math.toRadians(direction))*(speed*strength));
        y += (Math.sin(Math.toRadians(direction))*(speed*strength));
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public void drawAnimation(GraphicsContext graphicsContext){
        animation.play();
        Rectangle2D viewRect = animation.getImageView().getViewport();
        graphicsContext.drawImage(animation.getImageView().getImage(), viewRect.getMinX(), viewRect.getMinY(),viewRect.getWidth(), viewRect.getHeight(), x, y, length, height);
    }
}
