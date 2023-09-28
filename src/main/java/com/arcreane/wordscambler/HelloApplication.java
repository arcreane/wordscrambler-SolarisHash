package com.arcreane.wordscambler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        WordScramblerUI gameUI;
        int choix;

        System.out.println("Voulez vous jouer en version console ou version graphique ?");
        System.out.println("1.Version Console \t\t\t 2.Version Graphique");

        Scanner scan = new Scanner(System.in);
        choix = scan.nextInt();
        while(choix != 1 || choix != 2){

            if(choix == 1){
                gameUI = new WordScramblerUI();
                gameUI.startGameUI();
                break;
            }
            else if(choix == 2){
                launch();
                break;
            }
            else{
                System.out.println("Choisissez une option valable");
                scan = new Scanner(System.in);
                choix = scan.nextInt();
            }
        }

    }
}