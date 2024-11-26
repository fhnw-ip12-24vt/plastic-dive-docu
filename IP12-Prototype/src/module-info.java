module com.example.hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.hellofx to javafx.fxml;
    exports com.example.hellofx;
}