import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.\n");

        HashMap<Integer, Integer> difficultyLevel = new HashMap<>();
        difficultyLevel.put(1, 10);
        difficultyLevel.put(2, 5);
        difficultyLevel.put(3, 3);

        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)\n");

        System.out.print("Enter your choice: ");
        int difficulty = Integer.valueOf(scan.next());

        switch (difficulty) {

            case 1:
                System.out.println("\nGreat! You have selected the Easy difficulty level.\nLet's start the game!\n");
                enterGuess(difficulty, difficultyLevel);
                break;
            case 2:
                System.out.println("\nGreat! You have selected the Medium difficulty level.\nLet's start the game!\n");
                enterGuess(difficulty, difficultyLevel);
                break;
            case 3:
                System.out.println("\nGreat! You have selected the Hard difficulty level.\nLet's start the game!\n");
                enterGuess(difficulty, difficultyLevel);
                break;
        }

    }

    public static void enterGuess(int difficulty, HashMap<Integer, Integer> map) {
        int chances = 0;
        int randomNumber = new Random().nextInt(100) + 1;

        while(chances != map.get(difficulty)) {
            System.out.print("Enter your guess:");
            int guess = Integer.valueOf(scan.next());

            if(guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + chances + " attempts.\n");
                return;
            }

            if(guess > randomNumber) {
                System.out.println("Incorrect! The number is less than " + guess + ".\n");
            }

            if(guess < randomNumber) {
                System.out.println("Incorrect! The number is greater than " + guess + ".\n");
            }

            chances++;
        }
        System.out.println("GAME OVER! You have no more attempts left.");

    }
}