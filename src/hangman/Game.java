package hangman;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int lives = 6;
    String word;
    ArrayList<Character> bank = new ArrayList<Character>();

    Game(String randomWord) {
        word = randomWord;
    }

    public char inputGuess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a guess");
        char guess = scan.next().toLowerCase().charAt(0);
        if (Character.isLetter(guess)) {
            return guess;
        }
        System.out.println("Please type a valid guess");
        return inputGuess();
    }

    public void play() {
        System.out.println(hiddenWord() + " Guesses Left: " + lives);
        while (lives > 0) {
            char guess = inputGuess();
            if (checkBank(guess)) {
                System.out.println("You already guessed '" + guess + "'.");
            } else {
                if (!isGuessCorrect(guess)) {
                    if (lives == 1) {
                        System.out.println("You Lose!");
                        break;
                    }
                    lives--;
                }
                addToBank(guess);
            }

            if (isDone(hiddenWord())) {
                lives = 0;
                System.out.println("You Win!");
            } else {
                System.out.println(hiddenWord() + " Guesses Left: " + lives);
            }
        }
    }

    private boolean isGuessCorrect(char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBank(char guess) {
        for (int i = 0; i < bank.size(); i++) {
            if (bank.get(i) == guess) {
                return true;
            }
        }
        return false;
    }

    private boolean isDone(String guessedWord) {
        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == "*".charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private String hiddenWord() {
        String guessedWord = "";
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < bank.size(); j++) {
                if (word.charAt(i) == bank.get(j)) {
                    guessedWord += word.charAt(i);
                }
            }
            if (guessedWord.length() != (i + 1)) {
                guessedWord += "*";
            }
        }

        return guessedWord;
    }

    private void addToBank(char letter) {
        bank.add(letter);
    }
}