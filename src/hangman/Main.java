package hangman;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String[] arrWords = {"candy", "mountain", "envelope"};
        RandomWordGenerator words = new RandomWordGenerator(arrWords);
        String randomWord = words.generate();
        boolean isPlaying = true;
        Scanner scan = new Scanner(System.in);
        while(isPlaying)
        {
            new Game(words.generate()).play();
            System.out.println("Do you want to play again?");
            System.out.println("[Y]es or [N]o");
            if(scan.nextLine().toLowerCase().charAt(0) == 'n')
            {
                System.out.println("Thanks for playing!");
                isPlaying = false;
            }
        }
    }
}

