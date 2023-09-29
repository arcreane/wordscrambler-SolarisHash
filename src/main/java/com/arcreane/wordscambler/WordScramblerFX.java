package com.arcreane.wordscambler;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


import java.io.IOException;
import javafx.util.Duration;
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
    private Label timeLabel;
    @FXML
    private TextField wordAnswer;

    private Timeline timeline;

    public int difficulty;
    long score;
    long startTime;
    long endtime;
    int timerValue;
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
        timeLabel = new Label();
        wordAnswer = new TextField();
        score = 100;
        startTime = 0;
        endtime = 0;

    }

    public void setDifficulty(int p_difficulty) {
        this.difficulty = p_difficulty;
        WordScramblerGame game = new WordScramblerGame(difficulty);
        score = game.calculScore(score, startTime, endtime);
        updateLabel(scoreShow, "score : " + score);

        updateLabel(timeLabel,startTimer());
        startTime = System.currentTimeMillis();

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

        if (WordScramblerGame.Verification(userAnswer, basicWord)) {
            updateLabel(alert, "Bravo");
            endtime = System.currentTimeMillis();

            updateLabel(scoreShow, "" + WordScramblerGame.calculScore(score, startTime, endtime));
        } else {
            updateLabel(alert, "Rater");
        }

    }


    @FXML
    public void updateLabel(Label label, String text) {
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
    protected void hard(ActionEvent event) throws IOException {
        setDifficulty(3);
    }

    private String startTimer() {
        Duration duration = Duration.seconds(1);
        KeyFrame keyFrame = new KeyFrame(duration, event -> {
            timerValue++;
            timeLabel.setText(getTimeString(timerValue));
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.play();
        return null;
    }

    private String getTimeString(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}

