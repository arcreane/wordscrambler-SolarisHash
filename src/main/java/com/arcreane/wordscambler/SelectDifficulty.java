package com.arcreane.wordscambler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectDifficulty {
    @FXML
    private Button buttonEasy;
    @FXML
    private Button buttonMedium;

    @FXML
    private Button buttonHard;


    @FXML
    protected void easy(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-view1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonEasy.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);
    }

    @FXML
    protected void medium(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-view2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonMedium.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);
    }

    @FXML
    protected void hard(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-view3.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 400);
        Stage stage = (Stage) buttonHard.getScene().getWindow(); // Obtenez le Stage actuel
        stage.setScene(scene);
    }
}
