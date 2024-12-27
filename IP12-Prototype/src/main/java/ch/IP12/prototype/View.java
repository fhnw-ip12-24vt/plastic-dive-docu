package ch.IP12.prototype;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ch.IP12.prototype.model.Obstacle;
import ch.IP12.prototype.model.Player;

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
        graphicsContext.setFill(Color.DARKBLUE);
        graphicsContext.fillRect(0, 0, App.WIDTH, App.HEIGHT);

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(player.getX(), player.getY(), player.getLength(), player.getHeight());
        player.drawAnimation(graphicsContext);

        for (Obstacle obstacle : obstacles) {
            graphicsContext.setFill(Color.SEAGREEN);
            graphicsContext.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getLength(), obstacle.getHeight());
        }
    }
}