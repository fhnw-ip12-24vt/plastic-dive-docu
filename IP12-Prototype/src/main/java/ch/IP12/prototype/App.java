package ch.IP12.prototype;

import ch.IP12.prototype.components.Ads1115;
import ch.IP12.prototype.components.JoystickAnalog;
import ch.IP12.prototype.scenes.Scenes;
import com.pi4j.Pi4J;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import ch.IP12.prototype.model.Obstacle;
import ch.IP12.prototype.model.Player;
import ch.IP12.prototype.model.animations.Spritesheets;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App extends Application {
    static int WIDTH = 800;
    static int HEIGHT = 600;
    static JoystickAnalog joystick;

    public static void main(String[] args) {
        var pi4j = Pi4J.newAutoContext();

        Ads1115 ads1115 = new Ads1115(pi4j);
        joystick = new JoystickAnalog(ads1115, Ads1115.Channel.A0, Ads1115.Channel.A1);

        launch(args);

        joystick.reset();
        pi4j.shutdown();
    }

    public void start(Stage stage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = screenSize.width;
        HEIGHT = screenSize.height;
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);

        //Creates the player and an array list for all the obstacles
        Player player =  new Player(100,HEIGHT/2,3, WIDTH, HEIGHT,Spritesheets.Player);
        List<Obstacle> obstacles = Collections.synchronizedList(new ArrayList<>());

        //Creates the area which we draw all the images on
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setImageSmoothing(false);

        //Initializes the controller and starts the game
        Controller controller = new Controller(player, obstacles, joystick);

        //Starts the View and passes it the relevant things that are to be displayed
        View view = new View(graphicsContext, player, obstacles);

        //creates window and passes it the relevant objects (necessary for display)
        Scene scene = Scenes.getGameScene(canvas);
        stage.setScene(scene);
        stage.setTitle("IP12 Prototype");
        stage.show();

        //starts the key listeners for the main scene.
        controller.createGameKeyListeners(scene);
        controller.startGameLogic();

        view.startRendering();

        //Stops the game if the window is exited
        stage.setOnCloseRequest(event -> controller.stopGameLogic());
    }

}
