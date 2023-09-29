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
    private Label response;
    @FXML
    private TextField wordAnswer;

    public int difficulty;
    String wordMixed;
    boolean result;


    @FXMLController
    public WordScramblerFX() {
        wordToFind = new Label();
        response = new Label();
        wordAnswer = new TextField();
        WordScramblerGame game = new WordScramblerGame(difficulty);

        int tentative = 1;
        Random rand = new Random();

        int randomLine = rand.nextInt(game.wordTri.size());
        String wordSelected = game.wordTri.get(randomLine).trim().toLowerCase();
        wordMixed = game.mixWords(wordSelected);

        wordToFind.setText("Mots a trouver :");
        wordToFind.setText(wordMixed);

        if (result)
            response.setText("bravo");
        else
            response.setText("Rate");


    }

    public void setDifficulty(int p_difficulty) {
        this.difficulty = p_difficulty;

        WordScramblerGame game = new WordScramblerGame(difficulty);
        int tentative = 1;
        Random rand = new Random();
        int randomLine = rand.nextInt(game.wordTri.size());
        game.setGoodWord(game.wordTri.get(randomLine).trim().toLowerCase());
        String wordMixed = game.mixWords(game.goodWord);

        updateLabel(wordToFind, wordMixed);


    }

    @FXML
    public void updateLabel(Label label, String text){
        label.setText(text);
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

    public void validate(ActionEvent event) {

        String userAnswer = wordAnswer.getText().trim().toLowerCase();
        result = WordScramblerGame.Verification(userAnswer, wordMixed);
    }
}

