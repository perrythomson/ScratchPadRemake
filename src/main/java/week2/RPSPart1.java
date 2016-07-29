package week2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by perrythomson on 7/28/16.
 */
public class RPSPart1 {


        private String player1Choice;
        private String player2Choice;

        public static void main(String[] args) {
            RPSPart1 d3rps = new RPSPart1();
            d3rps.setPlayerChoices();
            d3rps.decideWinner();

        }


        public static String randomChoice(){
            int min = 1;
            int max = 3;
            String randomChoice = null;                                 ///check here for mistakes
            Random random = new Random();
            int randomNumber = random.nextInt((max-min)+1)+min;
            if(randomNumber == 1){
                randomChoice = "rock";
            } else if(randomNumber == 2){
                randomChoice ="paper";
            } else if (randomNumber == 3) {
                randomChoice = "scissor";
            }
            return randomChoice;
        }


        private void setPlayerChoices() {
            Scanner scanner = new Scanner(System.in);
            // The game should then randomly select the computer's (player 2) selection
            //     (hint: should be a different selection than player 1)
            player1Choice = randomChoice();
            while (player1Choice.isEmpty()) {
                System.out.println("Choose between these objects:  rock/paper/scissor");
                String inputChoice = scanner.next();
                if (inputChoice.equalsIgnoreCase("rock") || inputChoice.equalsIgnoreCase("paper") || inputChoice.equalsIgnoreCase("scissor")) {
                    player1Choice = inputChoice;
                } else {
                    System.out.println("Invalid player choice.");
                }
            }
            player2Choice = randomChoice();
            System.out.println("player 1 choice: " + player1Choice + " player 2 choice" + player2Choice);
        }
        // this is part of the main headers decidewinner...need to redefine if using different term
        // Using the rules of Rock-Paper-Scissors, decide which player wins
        //    (rule: rock beats scissors)
        //    (rule: paper beats Rock)
        //    (rule: scissors beats Paper)
        public void decideWinner() {
            String winnerAnnouncement;
            if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
                winnerAnnouncement = "Player1: ROCK vs Computer: SCISSORS ----- PLAYER WINS";
            } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("rock")) {
                winnerAnnouncement = "Player1: SCISSORS vs Computer: ROCK ----- COMPUTER WINS";
            } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
                winnerAnnouncement = "Player1: PAPER vs Computer: ROCK ----- PLAYER WINS";
            } else if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("paper")) {
                winnerAnnouncement = "Player1: ROCK vs Computer: PAPER ----- COMPUTER WINS";
            } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
                winnerAnnouncement = "Player1: SCISSORS vs Computer: PAPER ----- PLAYER WINS";
            } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("scissors")) {
                winnerAnnouncement = "Player1: PAPER vs Computer: SCISSORS ----- COMPUTER WINS";

            } else {
                winnerAnnouncement = "Its a TIE ---- EVERYONE IS A LOSER";
            }
            // Print out who won in this format: "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS"
            System.out.println(winnerAnnouncement);
        }



//     How will you make computer's selection random?
//        (hint: you have already done this in several programs

    }

