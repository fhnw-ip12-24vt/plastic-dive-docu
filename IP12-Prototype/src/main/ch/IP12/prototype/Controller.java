package main.ch.IP12.prototype;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    private Player player;
    private ArrayList<Obstacle> obstacles;
    private final ScheduledExecutorService executor;
    private volatile boolean running = true;

    Controller(Player player, ArrayList<Obstacle> obstacles) {
        this.player = player;
        this.obstacles = obstacles;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    void createListeners(Scene scene){
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                player.x -= player.speed;
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                player.x += player.speed;
            }
            if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                player.y += player.speed;
            }
            if(e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP){
                player.y -= player.speed;
            }
        });
    }

    void clearKeyListeners(Scene scene){
        scene.setOnKeyPressed(e -> {});
    }

    public void startGameLogic() {
        // Run the game logic at a fixed rate
        AtomicInteger gameTicks = new AtomicInteger();
        executor.scheduleAtFixedRate(() -> {
            if (running) {
                // Update the model (logic)
                gameTicks.getAndIncrement();
                System.out.println(gameTicks.get());

                if (gameTicks.get() % 100 == 0) {
                    obstacles.add(new Obstacle(900, (int) (Math.random() * 500 + 50), 2, (int) (Math.random() * 50 + 10), (int) (Math.random() * 50 + 10), "asdf"));
                }

                double deltaTime = 0.016; // Approx. 60 FPS
                player.update(deltaTime);
                for (Obstacle obstacle : obstacles) {
                    obstacle.x -= obstacle.speed;
                    obstacle.update(deltaTime);
                    if (player.collidesWith(obstacle)) {
                        stopGameLogic();
                    }
                }
            }
        }, 0, 16, TimeUnit.MILLISECONDS); // 16ms ≈ 60 updates per second
    }

    public void stopGameLogic() {
        running = false;
        executor.shutdown();
    }
}
