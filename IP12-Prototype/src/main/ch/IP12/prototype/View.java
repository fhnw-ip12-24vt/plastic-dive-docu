package main.ch.IP12.prototype;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;


public class View {
    private final GraphicsContext graphicsContext;
    private final Player player;
    private final ArrayList<Obstacle> obstacles;
    private long clock;

    View(GraphicsContext graphicsContext, Player player, ArrayList<Obstacle> obstacles) {
        this.graphicsContext = graphicsContext;
        this.player = player;
        this.obstacles = obstacles;
    }

    /**
     * Start rendering the relevant images for the objects on screen.
     */
    public void startRendering() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
            }
        };
        animationTimer.start();
    }

    /**
     * Draws the objects on the screen
     */
    private void render() {
        //System.out.println(1000/(System.currentTimeMillis()-clock));
        clock = System.currentTimeMillis();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, 800, 600);

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(player.x, player.y, player.length, player.height);

        for (Obstacle obstacle : obstacles) {
            graphicsContext.setFill(Color.BLUE);
            graphicsContext.fillRect(obstacle.x, obstacle.y, obstacle.length, obstacle.height);
        }
    }
}