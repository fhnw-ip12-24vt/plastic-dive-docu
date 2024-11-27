package main.ch.IP12.prototype;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;
import java.util.Stack;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) {
        Player player =  new Player(100,100,10,50,50,"asdf");
        ArrayList<Obstacle> obstacles = new ArrayList<>();

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Controller controller = new Controller(player, obstacles);
        controller.startGameLogic();


        View view = new View(graphicsContext, player, obstacles);
        view.startRendering();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        controller.createListeners(scene);
        stage.setScene(scene);
        stage.setTitle("MVC Example");
        stage.show();


        stage.setOnCloseRequest(event -> controller.stopGameLogic());
    }

}
