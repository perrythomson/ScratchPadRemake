package week2;

/**
 * Created by perrythomson on 7/28/16.
 */
import java.util.Random;
import java.util.Scanner;

public class Day3RockPaperScissors {

    private String player1Choice;
    private String player2Choice;

    public static void main(String[] args) {

        Day3RockPaperScissors d3rps = new Day3RockPaperScissors();
        d3rps.setPlayerChoices();
        d3rps.decideWinner();
    }

    private void setPlayerChoices() {
        Scanner scanner = new Scanner(System.in);
        // The game should ask player 1 for their choice of "rock", "paper", or "scissors".
        player1Choice = "";
        while(player1Choice.isEmpty()) {
            System.out.println("Choose rock, paper, or scissors");
            String inputChoice = scanner.next();
            if(inputChoice.equalsIgnoreCase("rock") || inputChoice.equalsIgnoreCase("paper") || inputChoice.equalsIgnoreCase("paper")) {
                player1Choice = inputChoice;
            } else {
                System.out.println("Invalid Choice!");
            }
        }

        // The game should then randomly select the computer's (player 2) selection
        //     (hint: should be a different selection than player 1)
        player2Choice = randomSelection();

    }

    private void decideWinner() {
        // Using the rules of Rock-Paper-Scissors, decide which player wins
        //    (rule: rock beats scissors)
        //    (rule: paper beats Rock)
        //    (rule: scissors beats Paper)
        String winnerAnnouncement;
        if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS";
        } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: ROCK ----- COMPUTER WINS";
        } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: PAPER vs Computer: ROCK ----- PLAYER WINS";
        } else if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: ROCK vs Computer: PAPER ----- COMPUTER WINS";
        } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: PAPER ----- PLAYER WINS";
        } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: PAPER vs Computer: SCISSORS ----- COMPUTER WINS";
        } else {
            winnerAnnouncement = "Its a TIE ---- EVERYONE IS A LOSER";
        }
        // Print out who won in this format: "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS"
        System.out.println(winnerAnnouncement);
    }


    // How will you make computer's selection random?
    //    (hint: you have already done this in several programs
    public static String randomSelection() {
        int min = 1;
        int max = 3;
        String randomSelection;
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt((max - min) +1) +min;
        if(randomNumber == 1) {
            randomSelection = "rock";
        } else if (randomNumber == 2) {
            randomSelection = "paper";
        } else {
            randomSelection = "scissors";
        }
        return randomSelection;
    }
}
