package main.ch.IP12.prototype;

import javafx.application.Application;
import javafx.stage.Stage;
import main.ch.IP12.prototype.model.Obstacle;
import main.ch.IP12.prototype.model.Player;

import java.util.ArrayList;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) {
        Player player =  new Player();
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        Controller controller =  new Controller(player, obstacles);


        stage.setTitle("MVC Example");
        stage.show();


        stage.setOnCloseRequest(event -> controller.stopGameLogic());
    }

}
