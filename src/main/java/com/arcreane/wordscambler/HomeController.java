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

public class HomeController {

    @FXML
    private Button buttonPlay;
    @FXML
    protected void play(ActionEvent event) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource("select-difficulty.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("select-difficulty.fxml")));
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonPlay.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);
        stage.show();
    }
}
