import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int roundsWon = 0;

        System.out.println("🎯 Welcome to Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {

            int randomNumber = rand.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess > randomNumber) {
                    System.out.println("📉 Too high!");
                } else {
                    System.out.println("📈 Too low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + randomNumber);
            }

            System.out.println("🏆 Rounds Won: " + roundsWon);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Final Score: " + roundsWon);
        sc.close();
    }
}
