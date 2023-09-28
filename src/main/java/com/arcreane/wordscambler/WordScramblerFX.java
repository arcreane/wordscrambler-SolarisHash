package com.arcreane.wordscambler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WordScramblerFX {
    public int difficulty;
    @FXML
    private Label labelDifficulty;
    public WordScramblerFX() {
        labelDifficulty.setText("Difficulté actuelle : " + difficulty);
        WordScramblerGame game = new WordScramblerGame(difficulty);

        long timer = System.currentTimeMillis();
        boolean play = true;

    }

    public void setDifficulty(int p_difficulty){
        difficulty = p_difficulty;
    }
}
