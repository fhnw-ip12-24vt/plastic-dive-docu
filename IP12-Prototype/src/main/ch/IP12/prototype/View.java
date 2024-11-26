package main.ch.IP12.prototype;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;


public class View {
    private final GraphicsContext gc;
     private Player player;
    private ArrayList<Obstacle> obstacles;

    public View(GraphicsContext graphicsContext, Player player, ArrayList<Obstacle> obstacles) {
        this.gc = graphicsContext;
        this.player = player;
        this.obstacles = obstacles;
    }

    public void startRendering() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
            }
        };
        animationTimer.start();
    }

    private void render() {

    }
}