package com.arcreane.wordscambler;

import com.arcreane.wordscambler.FXMLController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WordScramblerFX {
    public int difficulty;

    @FXML
    public Label labelDifficulty = new Label();

    public WordScramblerFX() {
        // Initialisez les valeurs par défaut ici si nécessaire
    }

    @FXMLController
    public WordScramblerFX(int initialDifficulty) {
        difficulty = initialDifficulty;

        System.out.println("Difficulty updated to " + difficulty);
        updateLabel("Difficulté actuelle : " + difficulty);

        WordScramblerGame game = new WordScramblerGame(difficulty);

        long timer = System.currentTimeMillis();
        boolean play = true;

    }

    public void setDifficulty(int p_difficulty) {
        difficulty = p_difficulty;
    }
    @FXML
    public void updateLabel(String text){
        Platform.runLater(() -> {
            labelDifficulty.setText(text);
        });
    }
}
