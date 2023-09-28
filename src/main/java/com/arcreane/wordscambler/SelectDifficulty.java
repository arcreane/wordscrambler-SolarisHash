package com.arcreane.wordscambler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.arcreane.wordscambler.WordScramblerUI.choseDifficulty;

public class SelectDifficulty {
    //WordScramblerFX game;

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
            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
            Parent root = loader.load();
            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
            Scene scene = new Scene(root, 800, 400);
            Stage stage = (Stage) buttonEasy.getScene().getWindow(); // Obtenez le Stage actuel
            stage.setScene(scene);
            WordScramblerFX game = loader.getController();
            game.setDifficulty(1);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void medium(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonMedium.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);

    }

    @FXML
    protected void hard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonHard.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);

    }
}
