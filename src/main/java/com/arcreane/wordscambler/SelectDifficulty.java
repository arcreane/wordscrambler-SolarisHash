package com.arcreane.wordscambler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class SelectDifficulty {
    //private WordScramblerFX game;

    @FXML
    private Button buttonEasy;
    @FXML
    private Button buttonMedium;

    @FXML
    private Button buttonHard;


    @FXML
    protected void easy(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("game.fxml")));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 400);
            //game = loader.getController();
            //game.setDifficulty(1);
            WordScramblerFX game = new WordScramblerFX();
            Stage stage = (Stage) buttonEasy.getScene().getWindow(); // Obtenez le Stage actuel
            stage.setScene(scene);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void medium(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("game.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 400);
        //game = loader.getController();
        //game.setDifficulty(2);
        Stage stage = (Stage) buttonMedium.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);

    }

    @FXML
    protected void hard(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("game.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 400);
        //game = loader.getController();
        //game.setDifficulty(3);
        Stage stage = (Stage) buttonHard.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);

    }
}
