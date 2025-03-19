package ch.IP12.prototype.difficultySelector;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BarcodeScanner {
    private final Scene scene;
    private String Difficulty = "\n";

    public BarcodeScanner(Scene scene) {
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
            Difficulty += event.getCode().getChar();
        });
    }

    public void stopListening(){
        scene.setOnKeyReleased(event -> {});
    }

    public String getDifficulty() {
        long difficulty;

        System.out.println(Difficulty);
        try{
            difficulty = Long.parseLong(Difficulty.replace("\n", ""));
        } catch (NumberFormatException e){
            return "Invalid code";
        }

        if (difficulty == 7624841656535L) {
            return "Easy";
        } else if (difficulty == 4016032473633L) {
            return "Medium";
        } else if (difficulty == 3046920045315L) {
            return "Hard";
        }

        return "Invalid code";
    }
}
