package com.arcreane.wordscambler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameConsole {
    long score;
    int tentative;
    long timer;
    boolean play = true;
    int difficulty;
    String myFile;


    public GameConsole() {
        difficulty = choseDifficulty();
        score = 100;
        timer = System.currentTimeMillis();
        myFile = "src/main/resources/com/arcreane/wordscambler/words.txt";
        ArrayList<String> words = new ArrayList<>();

        try( FileReader fileReader = new FileReader(myFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String word;
            while ((word = bufferedReader.readLine()) != null) {
                words.add(word);
            }

            ArrayList<String> wordTri = wordKept(words, difficulty);

            //System.out.println("Quel est le mot :");

            while(play){
                boolean manche = true;
                tentative = 1;

                Random rand = new Random();
                long randomLine = rand.nextLong(wordTri.size());

                String wordSelected = wordTri.get((int)randomLine).trim().toLowerCase();
                String wordMixed = melangerMot(wordSelected);

                System.out.println("Le mot original est : " + wordSelected);
                System.out.println("Mots a trouver " + wordMixed);

                while(manche){
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
                            int choix = scan.nextInt();
                            if(choix == 1)
                                break;

                        }
                        System.out.println("Mots a trouver " + wordMixed);
                    }
                }
            }
            System.out.println("La durée prise est de " + (System.currentTimeMillis() - timer)/ 1000 + " secondes");
            long duration = (System.currentTimeMillis() - timer) / 1000;
            System.out.println("Vous avez trouvez le mot en "+tentative);
            System.out.println("Votre score est de "+ (score - duration) + " points");



        }catch (IOException e){
            e.printStackTrace();
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

    public static String melangerMot(String word){
        char[] letters = word.toCharArray();
        Random rand = new Random();

        for(int i = letters.length - 1; i > 0; i--){
            int j = rand.nextInt(i + 1);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

    public static ArrayList<String> wordKept(ArrayList<String> inputList, int difficulty){

        int limit;
        Set<String> arrayUsed = new HashSet<>();

        if(difficulty == 1)
            limit = 4;
        else if (difficulty == 2)
            limit = 6;
        else
            limit = 8;

        for (String word : inputList){
            if(word.length() <= limit && word.length()>=limit - 1)
                arrayUsed.add(word);
        }

        return new ArrayList<>(arrayUsed);
    }

    /*public static int calculScore(int score, int difficulty, long duration){
        return 1;
    }*/
}
