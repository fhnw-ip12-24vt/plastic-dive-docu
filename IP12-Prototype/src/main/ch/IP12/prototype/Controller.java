package main.ch.IP12.prototype;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    private final List<KeyCode> pressedKeys = Collections.synchronizedList(new ArrayList<KeyCode>());
    private Player player;
    private ArrayList<Obstacle> obstacles;
    private final ScheduledExecutorService executor;
    private volatile boolean running = true;
    AtomicInteger gameTicks = new AtomicInteger();

    Controller(Player player, ArrayList<Obstacle> obstacles) {
        this.player = player;
        this.obstacles = obstacles;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * Creates Key listeners for movement logic.
     * @param scene The Scene object which will receive the listeners
     */
    void createListeners(Scene scene){
        scene.setOnKeyReleased(e -> {
            if(!running){
                //If the game is over and the player releases a button the key listeners are cleared
                clearKeyListeners(scene);
                return;
            }

            if (e.getCode() == KeyCode.A && pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.LEFT && pressedKeys.contains(e.getCode())) {
                player.tempDir[1] = false;
                pressedKeys.remove(e.getCode());
            }
            if (e.getCode() == KeyCode.D && pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.RIGHT && pressedKeys.contains(e.getCode())) {
                player.tempDir[0] = false;
                pressedKeys.remove(e.getCode());
            }
            if (e.getCode() == KeyCode.S && pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.DOWN && pressedKeys.contains(e.getCode())) {
                player.tempDir[3] = false;
                pressedKeys.remove(e.getCode());
            }
            if(e.getCode() == KeyCode.W && pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.UP && pressedKeys.contains(e.getCode())){
                player.tempDir[2] = false;
                pressedKeys.remove(e.getCode());
            }
        });
        scene.setOnKeyPressed(e -> {
            if(!running){
                //If the game is over and the player presses a button the key listeners are cleared
                clearKeyListeners(scene);
                return;
            }

            //moves player using temporary variables whilst there is no joystick present.
            if (e.getCode() == KeyCode.A && !pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.LEFT && !pressedKeys.contains(e.getCode())) {
                player.tempDir[1] = true;
                pressedKeys.add(e.getCode());
            }
            if (e.getCode() == KeyCode.D && !pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.RIGHT && !pressedKeys.contains(e.getCode())) {
                player.tempDir[0] = true;
                pressedKeys.add(e.getCode());
            }
            if (e.getCode() == KeyCode.S && !pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.DOWN && !pressedKeys.contains(e.getCode())) {
                player.tempDir[3] = true;
                pressedKeys.add(e.getCode());
            }
            if(e.getCode() == KeyCode.W && !pressedKeys.contains(e.getCode()) || e.getCode() == KeyCode.UP && !pressedKeys.contains(e.getCode())){
                player.tempDir[2] = true;
                pressedKeys.add(e.getCode());
            }
        });
    }

    /**
     * Clears Key listeners from provided Scene Object
     * @param scene Scene Object
     */
    void clearKeyListeners(Scene scene){
        scene.setOnKeyPressed(e -> {});
        scene.setOnKeyReleased(e -> {});
    }

    /**
     * Starts the game logic, such as Obstacle movement and tick incrementation.
     */
    public void startGameLogic() {
        // Run the game logic at a fixed rate
        executor.scheduleAtFixedRate(this::gameStep, 0, 16, TimeUnit.MILLISECONDS); // 16ms ≈ 60 updates per second
    }

    /**
     * Stops the game logic from running and kills all other threads related to it.
     */
    public void stopGameLogic() {
        running = false;
        executor.shutdown();
    }

    private void gameStep() {
        {
            if (running) {
                List<Obstacle> deletionList = Collections.synchronizedList(new ArrayList<>());
                // Update the model (logic)
                gameTicks.getAndIncrement();

                if (gameTicks.get() % 100 == 0) {
                    obstacles.add(new Obstacle(900, (int) (Math.random() * 500 + 50), 2, (int) (Math.random() * 50 + 10), (int) (Math.random() * 50 + 10), "asdf"));
                }

                double deltaTime = 0.016; // Approx. 60 FPS
                player.moving = !pressedKeys.isEmpty();
                player.update(deltaTime, 1);
                obstacles.parallelStream().forEach(obstacle -> {
                    //Obstacle updates
                    obstacle.update(deltaTime, 1);

                    //adds obstacle to deletion list if it is entirely out of frame for the player
                    if (obstacle.x + obstacle.length < 0) deletionList.add(obstacle);

                    //collision stops prototype
                    if (player.collidesWith(obstacle)) {
                        stopGameLogic();
                    }
                });

                //removes obstacles from main obstacle array
                //and clears the deletion list.
                for (Obstacle obstacle : deletionList) {
                    obstacles.remove(obstacle);
                }
                deletionList.clear();
            }
        }
    }
}
