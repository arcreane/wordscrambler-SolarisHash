package com.arcreane.wordscambler;

public class WordScramblerFX {
    public WordScramblerFX() {
        int difficulty = choseDifficulty();
        WordScramblerGame game = new WordScramblerGame(difficulty);
        long timer = System.currentTimeMillis();
        boolean play = true;
    }
}
