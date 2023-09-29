package com.arcreane.wordscambler;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class WordScramberConsole {
    public void startGameConsole(){
        int difficulty = choseDifficulty();
        WordScramblerGame game = new WordScramblerGame(difficulty);
        long timer = System.currentTimeMillis();
        boolean play = true;


        while(play){
            boolean manche = true;
            int tentative = 1;
            Random rand = new Random();

            int randomLine = rand.nextInt(game.wordTri.size());
            String wordSelected = game.wordTri.get(randomLine).trim().toLowerCase();
            String wordMixed = game.mixWords(wordSelected);


            while(manche){
                System.out.println("Mots a trouver : " + wordMixed);
                System.out.println("Quel est le mot : ");
                Scanner scan = new Scanner(System.in);
                String answer = scan.nextLine();

                if(Objects.equals(answer, wordSelected)){
                    System.out.println("Bravo!");
                    System.out.println("Voulez-vous continuez ? 1.Oui   2.Non");
                    Scanner continu = new Scanner(System.in);
                    if(continu.nextInt() == 2){
                        System.out.println("Le mot original est : " + wordSelected);
                        manche = false;
                        play = false;
                    }
                    else
                        manche = false;
                }
                else{
                    System.out.println("Incorrect ! Veuillez réessayez");
                    tentative++;
                    if (tentative == 5){
                        System.out.println("Voulez-vous abandonné ?");
                        System.out.println("1.Oui \t 2.Non");
                        scan = new Scanner(System.in);
                        int choice = scan.nextInt();
                        if(choice == 1) {
                            manche = false;
                            play = false;
                        }
                    }
                    //System.out.println("Mots a trouver " + wordMixed);
                }
            }
        }
    }

    public static int choseDifficulty(){
        int difficultySelected;

        do{
            System.out.println("Choisissez une difficulté : ");
            System.out.println("1.Easy \t 2.Medium \t 3.Hard");

            Scanner scan = new Scanner(System.in);
            difficultySelected = scan.nextInt();

        } while (difficultySelected < 1 || difficultySelected > 3);

        System.out.println("Vous avez choisis la difficulté " + difficultySelected);

        return difficultySelected;
    }
}
