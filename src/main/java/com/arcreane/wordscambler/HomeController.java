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
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
            //Scene scene = new Scene(root, 800, 400);
            Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 400);
            Stage stage = (Stage) buttonPlay.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
