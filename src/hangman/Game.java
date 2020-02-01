package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    int lives = 6;
    String word;
    ArrayList<Character> bank = new ArrayList<Character>();
    Game(String inputWord)
    {
        word = inputWord;
    }

    public char inputGuess()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a guess");
        char guess = scan.next().toLowerCase().charAt(0);
        if(Character.isLetter(guess))
        {
            return guess;
        }
        System.out.println("Please type a valid letter");
        return inputGuess();
    }

    private void addToBank(char letter)
    {
        bank.add(letter);
    }

    public void play()
    {
        System.out.println(hiddenWord() + "\nguesses left : " + lives);
        while(lives > 0)
        {
            System.out.println("lives: " + lives);
            char guess = inputGuess();
            if(checkBank(guess))
            {
                System.out.println("You have already guessed '" + guess + "'");
            }
            else
            {
                if(!isGuessCorrect(guess))
                {
                    if(lives == 1)
                    {
                        System.out.println("You lose");
                        break;
                    }
                    lives--;
                }
                addToBank(guess);
            }
            if(isDone(hiddenWord()))
            {
                lives = 0;
                System.out.println("You win!");
            }
            else
            {
                System.out.println(hiddenWord() + "\nguesses left: " + lives);
            }

        }
    }

    public boolean checkBank(char guess)
    {
        for(int i = 0; i < bank.size(); i++)
        {
            if(bank.get(i) == guess)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isGuessCorrect(char guess)
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == guess)
            {
                return true;
            }
        }
        return false;
    }

    private String hiddenWord()
    {
        String guessedWord = "";
        for(int i = 0; i < word.length(); i++)
        {
            for(int j = 0; j < bank.size(); j++)
            {
                if(word.charAt(i) == bank.get(j))
                {
                    guessedWord += word.charAt(i);
                    break;
                }
            }
            if(guessedWord.length() != (i+1))
            {
                guessedWord += "*";
            }
        }
        return guessedWord;
    }

    private boolean isDone(String guessedWord)
    {
        for(int i = 0; i < guessedWord.length(); i++)
        {
            if(guessedWord.charAt(i) == '*')
            {
                return false;
            }
        }
        return true;
    }
}
