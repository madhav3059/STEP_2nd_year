import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Move cannot be null.");
        }

        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.trim().toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"rock", "paper", "scissors"};

        int totalRounds = 5;
        System.out.print("Enter number of rounds (default 5): ");
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                totalRounds = Integer.parseInt(input);
                if (totalRounds <= 0) {
                    System.out.println("Invalid round count. Defaulting to 5.");
                    totalRounds = 5;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Non-numeric input detected. Defaulting to 5 rounds.");
            totalRounds = 5;
        }

        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            System.out.println("\n--- Round " + (i + 1) + " ---");
            String playerChoice = "";

            while (true) {
                System.out.print("Enter move (Rock, Paper, Scissors): ");
                playerChoice = scanner.nextLine().trim().toLowerCase();
                if (playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors")) {
                    break;
                }
                System.out.println("Invalid choice! Choose Rock, Paper, or Scissors.");
            }

            String computerChoice = moves[random.nextInt(moves.length)];
            String outcome = playRound(playerChoice, computerChoice);

            playerMoves[i] = playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1);
            computerMoves[i] = computerChoice.substring(0, 1).toUpperCase() + computerChoice.substring(1);
            results[i] = outcome;

            if (outcome.equals("Player Wins")) wins++;
            else if (outcome.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Result: " + outcome);
        }

        // Summary Table
        System.out.println("\n" + "=".repeat(65));
        System.out.printf("%-8s | %-15s | %-15s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-".repeat(65));
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-15s | %-15s | %-15s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("=".repeat(65));

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);

        scanner.close();
    }
}