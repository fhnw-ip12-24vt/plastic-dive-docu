package main.ch.IP12.prototype;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class View extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) {
        stage.setTitle("MVC Example");
        stage.show();
    }

}