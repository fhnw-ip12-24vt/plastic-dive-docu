package ch.IP12.prototype.difficultySelector;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BarcodeScanner {
    private final Scene scene;
    private String Difficulty = "\n";

    BarcodeScanner(Scene scene) {
        this.scene = scene;
    }

    public void startListening(){
        scene.setOnKeyPressed(event -> {
            if (Difficulty.replace("\n", "-").substring(Difficulty.length()-1).equals("-")){
                Difficulty = "";
            }
            if (event.getCode() == KeyCode.ENTER) {
                Difficulty += "\n";
                return;
            }
            Difficulty += event.getCharacter();
        });
    }

    public void stopListening(){
        scene.setOnKeyReleased(event -> {});
    }

    public boolean checkValidity(String barcode) {
        return barcode != null && !barcode.isEmpty();
    }

    public String getDifficulty() {
        return Difficulty;
    }
}
