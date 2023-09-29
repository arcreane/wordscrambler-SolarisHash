package com.arcreane.wordscambler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Random;
public class WordScramblerFX {

    @FXML
    private StackPane gameStackPane;
    @FXML
    private VBox difficultyLayer;
    @FXML
    private VBox gameLayer;
    @FXML
    private Button buttonEasy;
    @FXML
    private Button buttonMedium;

    @FXML
    private Button buttonHard;
    @FXML
    private Button goBackButton;
    @FXML
    public Button validateButton;

    @FXML
    private Label wordToFind;
    @FXML
    private TextField wordAnswer;

    public int difficulty;


    @FXMLController
    public WordScramblerFX() {

        WordScramblerGame game = new WordScramblerGame(difficulty);

        int tentative = 1;
        Random rand = new Random();

        int randomLine = rand.nextInt(game.wordTri.size());
        String wordSelected = game.wordTri.get(randomLine).trim().toLowerCase();
        String wordMixed = game.mixWords(wordSelected);

        wordToFind.setText("");
        wordToFind.setText(wordMixed);
        validateAnswer(wordSelected, wordMixed);

    }

    public void setDifficulty(int p_difficulty) {
        this.difficulty = p_difficulty;

    }
    @FXML
    public void updateLabel(Label label, String text){
        label.setText(text);
    }
    @FXML
    public void validateAnswer(String wordSelected, String wordMixed) {
        String userAnswer = wordAnswer.getText().trim().toLowerCase();

        if (userAnswer.equals(wordMixed)) {
            updateLabel(wordToFind, "Bravo !");
            // Affichez un message de réussite, mettez à jour le score, etc.
        } else {
            updateLabel(wordToFind,"Incorrect ! Veuillez réésayez");
            // La réponse de l'utilisateur est incorrecte
            // Affichez un message d'échec, décrémentez le score, etc.
        }
    }
    @FXML
    protected void easy(ActionEvent event) throws IOException {
        setDifficulty(1);
    }

    @FXML
    protected void medium(ActionEvent event) throws IOException {
        setDifficulty(2);
    }

    @FXML
    protected void hard(ActionEvent event) throws IOException{
        setDifficulty(3);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        showDifficultyLayer();
        hideGameLayer();
    }

    private void showDifficultyLayer() {
        difficultyLayer.setVisible(true);
    }
    private void hideDifficultyLayer() {
        difficultyLayer.setVisible(false);
    }

    private void showGameLayer() {
        gameLayer.setVisible(true);
    }
    private void hideGameLayer() {
        gameLayer.setVisible(false);
    }

    public void validate(ActionEvent event,String wordSelected, String wordMixed) {
        String userAnswer = wordAnswer.getText().trim().toLowerCase();

        if (userAnswer.equals(wordMixed)) {
            updateLabel(wordToFind, "Bravo !");
            // Affichez un message de réussite, mettez à jour le score, etc.
        } else {
            updateLabel(wordToFind,"Incorrect ! Veuillez réésayez");
            // La réponse de l'utilisateur est incorrecte
            // Affichez un message d'échec, décrémentez le score, etc.
        }
    }
}



