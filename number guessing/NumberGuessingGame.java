import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;
            attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("The number is higher.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("The number is lower.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            } else {
                // Calculate score based on number of attempts
                score += (maxAttempts - attempts + 1);
                System.out.println("Your score: " + score);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("Thank you for playing! Your final score: " + score);
            }
        }

        scanner.close();
    }
}
