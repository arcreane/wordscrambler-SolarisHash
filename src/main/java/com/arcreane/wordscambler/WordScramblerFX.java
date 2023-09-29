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
    public Button validateButton;
    @FXML
    private Label test;

    @FXML
    private Label wordToFind;
    @FXML
    private Label response;
    @FXML
    private Label alert;
    @FXML
    private Label scoreShow;
    @FXML
    private TextField wordAnswer;

    public int difficulty;
    long score;
    long startTime;
    long endtime;
    int timer;
    String basicWord;
    String wordMixed;
    boolean result;


    @FXMLController
    public WordScramblerFX() {
        wordToFind = new Label();
        response = new Label();
        test = new Label();
        alert = new Label();
        scoreShow = new Label();
        wordAnswer = new TextField();
        score = 100;
        startTime = 0;
        endtime = 0;

    }

    public void setDifficulty(int p_difficulty) {
        this.difficulty = p_difficulty;
        WordScramblerGame game = new WordScramblerGame(difficulty);
        score = game.calculScore(score, startTime,endtime);
        updateLabel(scoreShow, "score : " + score);

        int tentative = 1;
        Random rand = new Random();
        int randomLine = rand.nextInt(game.wordTri.size());
        game.setGoodWord(game.wordTri.get(randomLine).trim().toLowerCase());
        basicWord = game.goodWord;
        wordMixed = game.mixWords(game.goodWord);
        System.out.println(wordMixed);

        updateLabel(test, game.goodWord);

        updateLabel(wordToFind, wordMixed);
    }

    public void validate(ActionEvent event) {

        String userAnswer = wordAnswer.getText().trim().toLowerCase();
        System.out.println("userAnswer: " + userAnswer);
        System.out.println("wordMixed: " + wordMixed);
        if(WordScramblerGame.Verification(userAnswer, basicWord)){
            updateLabel(alert,"Bravo");
        }
        else
        {
            updateLabel(alert,"Rater");
        }
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

}

