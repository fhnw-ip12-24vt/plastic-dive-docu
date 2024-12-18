package ch.IP12.prototype;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import ch.IP12.prototype.model.Obstacle;
import ch.IP12.prototype.model.Player;
import ch.IP12.prototype.model.animations.Spritesheets;

import java.util.ArrayList;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) {
        final int width = 800;
        final int height = 600;
        //Creates the player and an array list for all the obstacles
        Player player =  new Player(100,100,3,50,50, width, height, Spritesheets.Player);
        ArrayList<Obstacle> obstacles = new ArrayList<>();

        //Creates the area which we draw all the images on
        Canvas canvas = new Canvas(width, height);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        //Initializes the controller and starts the game
        Controller controller = new Controller(player, obstacles, width, height);

        //Starts the View and passes it the relevant things that are to be displayed
        View view = new View(graphicsContext, player, obstacles);

        //creates window and passes it the relevant objects (necessary for display)
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("IP12 Prototype");
        stage.show();

        //starts the key listeners for the main scene.
        controller.createListeners(scene);
        controller.startGameLogic();

        view.startRendering();

        //Stops the game if the window is exited
        stage.setOnCloseRequest(event -> controller.stopGameLogic());
    }

}
