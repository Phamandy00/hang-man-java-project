package hangman;

import java.util.Random;

public class RandomWordGenerator
{
    String[] words;
    public RandomWordGenerator(String[] wordsArr)
    {
        words = wordsArr;
    }
    private int randomIndex()
    {
        Random rand = new Random();
        int randomIndex = rand.nextInt(words.length);
        return randomIndex;
    }
    public String generate()
    {
        return words[randomIndex()];
    }
}
