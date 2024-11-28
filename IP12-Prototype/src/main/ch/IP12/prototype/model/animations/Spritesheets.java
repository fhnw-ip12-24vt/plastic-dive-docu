package main.ch.IP12.prototype.model.animations;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public enum Spritesheets {
    Player(new SpriteAnimation(new ImageView(new Image("asdf")), 0,0,0,0,0, 0, Duration.millis(1000))),
    SmallCluster(new SpriteAnimation(new ImageView(new Image("asdf")), 0,0,0,0,0, 0, Duration.millis(1000))),
    MediumCluster(new SpriteAnimation(new ImageView(new Image("asdf")), 0,0,0,0,0, 0, Duration.millis(1000))),
    LargeCluster(new SpriteAnimation(new ImageView(new Image("asdf")), 0,0,0,0,0, 0, Duration.millis(1000))),;

    private final SpriteAnimation spriteAnimation;

    Spritesheets(SpriteAnimation spriteAnimation) {
        this.spriteAnimation = spriteAnimation;
    }

    public static Spritesheets getRandomSpritesheet() {
        if (values().length == 1) {
            return values()[0];
        }
        int randInt = new Random().nextInt(1, values().length);
        return values()[randInt];
    }

    public SpriteAnimation getSpriteAnimation() {
        return spriteAnimation;
    }
}
