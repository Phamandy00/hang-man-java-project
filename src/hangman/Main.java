package hangman;

public class Main
{
    public static void main(String[] args)
    {
        String[] arrWords = {"candy", "mountain", "envelope"};
        RandomWordGenerator words = new RandomWordGenerator(arrWords);
        String randomWord = words.generate();
        System.out.println(randomWord);
    }
}
