import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Constants for maximum number of attempts and number range
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static int roundsWon = 0; // Keeps track of rounds won by the user
    private static int totalRounds = 0; // Keeps track of total rounds played

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain; // Flag to determine if the user wants to play another round

        do {
            // Generate a random number for the current round
            int randomNumber = generateRandomNumber();
            boolean isGuessedCorrectly = false; // Flag to check if the user guessed the number correctly
            int attemptsLeft = MAX_ATTEMPTS; // Number of attempts left for the user

            // Welcome message and game instructions
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            // Loop for the user to guess the number
            while (attemptsLeft > 0 && !isGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); // Read user's guess

                // Check if the guess is within the valid range
                if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                    System.out.println("Please guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                    attemptsLeft--; // Decrease attempts left
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                    attemptsLeft--; // Decrease attempts left
                } else {
                    System.out.println("Congratulations! You guessed the correct number!");
                    isGuessedCorrectly = true; // User guessed correctly
                }

                // Display attempts left if the user hasn't guessed correctly yet
                if (!isGuessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            // If the user didn't guess correctly within the allowed attempts
            if (!isGuessedCorrectly) {
                System.out.println("Sorry, you're out of attempts. The correct number was " + randomNumber + ".");
            } else {
                // Increment the count of rounds won
                roundsWon++;
            }

            // Increment the total number of rounds played
            totalRounds++;

            // Ask the user if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain); // Continue the game if the user wants to play again

        // Display game summary and score
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Score: " + roundsWon + "/" + totalRounds);

        // Close the scanner
        scanner.close();
    }

    // Method to generate a random number between MIN_NUMBER and MAX_NUMBER
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}