import java.util.Scanner;
import java.util.Random;

/**
 * This program will play Rock, Paper, Scissors with the user
 * 
 * @author Reyansh Jajoo
 * @date: 11-10-2025
 * @period: 3
 */
public class RockPaperScissors {
    /**
     * Main method to run the Rock, Paper, Scissors game
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // init variables
        Scanner console = new Scanner(System.in);
        int userWins = 0;
        int userTies = 0;
        int userLosses = 0;

        // game loop
        while (true) {
            // get and validate user input
            System.out.print("Enter your move (rock, paper, scissors) or 'quit' to exit: ");
            String userMove = console.nextLine().toLowerCase();
            if (userMove.equals("quit")) {
                break;
            }
            if (!isValidMove(userMove)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // get computer and display computer move
            String computerMove = getComputerMove();
            System.out.println("Computer chose: " + computerMove);

            // determine winner and update scores
            String result = determineWinner(userMove, computerMove);
            if (result.equals("user")) {
                System.out.println("You win!");
                userWins++;
            } else if (result.equals("computer")) {
                System.out.println("You lose!");
                userLosses++;
            } else {
                System.out.println("It's a tie!");
                userTies++;
            }
        }

        // display final results
        System.out.println("Final Results: Wins: " + userWins + ", Ties: " + userTies + ", Losses: " + userLosses);
        console.close();
    }

    /**
     * Generates a random move for the computer
     * 
     * @return The computer's move as a String ("rock", "paper", or "scissors")
     */
    public static String getComputerMove() {
        Random rand = new Random();
        String[] options = { "rock", "paper", "scissors" };
        return options[rand.nextInt(3)];
    }

    /**
     * Determines the winner of the game
     * 
     * @param userMove     The move of the user
     * @param computerMove The move of the computer
     * @return "tie" if it's a tie, "user" if the user wins, "computer" if the
     *         computer wins
     */
    public static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "tie";
        } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                (userMove.equals("paper") && computerMove.equals("rock")) ||
                (userMove.equals("scissors") && computerMove.equals("paper"))) {
            return "user";
        } else {
            return "computer";
        }
    }

    /**
     * Checks if the user's move is valid
     * 
     * @param move The user's move
     * @return true if the move is valid, false otherwise
     */
    public static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }
}
