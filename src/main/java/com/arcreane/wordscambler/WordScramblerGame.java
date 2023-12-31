package com.arcreane.wordscambler;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordScramblerGame {
    String goodWord;
    int difficulty;
    String myFile;
    ArrayList<String> wordTri;

    @FXMLController
    public WordScramblerGame(int p_difficulty) {
        difficulty = p_difficulty;

        myFile = "src/main/resources/com/arcreane/wordscambler/words.txt";

        List<String> loadedWords = loadWordsFromFile(myFile);

        wordTri = wordKept((ArrayList<String>) loadedWords, difficulty);

    }

    public List<String> loadWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String word;
            while ((word = bufferedReader.readLine()) != null) {
                words.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static ArrayList<String> wordKept(ArrayList<String> inputList, int difficulty) {

        int limit;
        Set<String> arrayUsed = new HashSet<>();

        if (difficulty == 1)
            limit = 4;
        else if (difficulty == 2)
            limit = 6;
        else
            limit = 8;

        for (String word : inputList) {
            if (word.length() <= limit && word.length() >= limit - 1)
                arrayUsed.add(word);
        }

        return new ArrayList<>(arrayUsed);
    }

    public static String mixWords(String word) {
        char[] letters = word.toCharArray();
        Random rand = new Random();

        for (int i = letters.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

    public void setGoodWord(String p_goodWord) {
        goodWord = p_goodWord;
    }

    public static boolean Verification(String p_userAnswer, String p_basicWord) {
        return p_userAnswer.equals(p_basicWord);
    }

    public static long calculScore(long p_score, long p_startTime, long p_endTime){
        p_score = p_score - (p_endTime - p_startTime) / 1000;
        return p_score;
    }
}
