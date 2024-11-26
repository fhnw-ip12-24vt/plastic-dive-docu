package main.ch.IP12.prototype;

import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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


    public void startGameLogic() {
        // Run the game logic at a fixed rate
        executor.scheduleAtFixedRate(() -> {
            if (running) {
                // Update the model (logic)
                double deltaTime = 0.016; // Approx. 60 FPS
                player.update(deltaTime);
                for (Obstacle obstacle : obstacles) {
                    obstacle.update(deltaTime);
                }
            }
        }, 0, 16, TimeUnit.MILLISECONDS); // 16ms ≈ 60 updates per second
    }

    public void stopGameLogic() {
        running = false;
        executor.shutdown();
    }
}
