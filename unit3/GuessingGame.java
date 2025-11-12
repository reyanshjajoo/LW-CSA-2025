import java.util.Scanner;
import java.util.Random;

/**
 * A guessing game where the user tries to guess a randomly generated number
 * 
 * @author Reyansh Jajoo
 * @date: 11-12-2025
 * @period: 3
 */
public class GuessingGame {
    // Maximum number for the guessing range
    public static final int MAX_NUMBER = 100;

    /**
     * Main method to start the guessing game
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        haiku();
        Scanner console = new Scanner(System.in);
        playGame(console);
        console.close();
    }

    /**
     * Play multiple rounds of the guessing game
     * 
     * @param console Scanner object for user input
     */
    public static void playGame(Scanner console) {
        // init vars
        String playAgain;
        int totalAttempts = 0;
        int totalGames = 0;
        int currentAttempts = 0;
        int bestScore = Integer.MAX_VALUE;

        // game loop
        while (true) {
            currentAttempts = playRound(console);
            totalAttempts += currentAttempts;
            bestScore = Math.min(bestScore, currentAttempts);
            totalGames++;

            // ask to play again
            System.out.print("Do you want to play again? ");
            playAgain = console.next();
            if (!(playAgain.substring(0, 1).equalsIgnoreCase("y"))) {
                break;
            }
        }

        displayStats(totalGames, totalAttempts, bestScore);
    }

    /**
     * Play a single round of the guessing game
     * 
     * @param console Scanner object for user input
     * @return number of attempts taken to guess the number
     */
    public static int playRound(Scanner console) {
        // init vars
        Random rand = new Random();
        int numberToGuess = rand.nextInt(MAX_NUMBER) + 1;
        int userGuess = 0;
        int attempts = 0;

        // game loop
        System.out.println("I'm thinking of a number between 1 and 100... ");
        while (userGuess != numberToGuess) {
            System.out.print("Your guess? ");
            userGuess = console.nextInt();
            attempts++;

            // give feedback
            if (userGuess < numberToGuess) {
                System.out.println("It's higher.");
            } else if (userGuess > numberToGuess) {
                System.out.println("It's lower.");
            } else {
                System.out.println("You got it right in " + attempts + " guesses!");
            }
        }
        return attempts;
    }

    /**
     * Display overall game statistics
     * 
     * @param totalGames    Total number of games played
     * @param totalAttempts Total number of attempts across all games
     * @param bestScore     Best score in fewer games
     */
    public static void displayStats(int totalGames, int totalAttempts, int bestScore) {
        // Calculate average attempts per game
        double averageAttempts = (double) totalAttempts / totalGames;

        // Display statistics
        System.out.println("Overall results:");
        System.out.println("Total games: " + totalGames);
        System.out.println("Guesses/game: " + averageAttempts);
        System.out.println("Best game: " + bestScore);
    }

    /**
     * Prints a haiku about autumn
     */
    public static void haiku(){
        System.out.println("It is now autumn");
        System.out.println("The trees are red and orange");
        System.out.println("I love autumn time");
    }
}
