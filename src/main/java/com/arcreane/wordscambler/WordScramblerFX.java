package com.arcreane.wordscambler;

import com.arcreane.wordscambler.FXMLController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WordScramblerFX {
    public int difficulty;

    @FXML
    public Label labelDifficulty = new Label();

    @FXMLController
    public WordScramblerFX() {

    }

    public void setDifficulty(int p_difficulty) {
        this.difficulty = p_difficulty;
        System.out.println("Difficulty updated to " + difficulty);
        updateLabel("Difficulté actuelle : " + difficulty);
        WordScramblerGame game = new WordScramblerGame(difficulty);
    }
    @FXML
    public void updateLabel(String text){
        Platform.runLater(() -> {
            labelDifficulty.setText(text);
        });
    }
}
