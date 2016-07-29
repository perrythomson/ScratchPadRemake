package week2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by perrythomson on 7/22/16.
 */
public class RPSPart2 {


    private String player1Choice;
    private String player2Choice;
    private ArrayList<String> wins = new ArrayList<>();
    private ArrayList<String> gestures = new ArrayList<>();

    public static void main(String[] args) {

        RPSPart2 d3rps = new RPSPart2();
        for (int i = 0; i < 1000; i++) {
            d3rps.setPlayers();
            d3rps.decideWinner();
        }
        d3rps.printGameStats();
    }

    private void setPlayers() {
        player1Choice = randomNumberSelection(); // these should be different from eachother...using the millisec
        player2Choice = randomNumberSelection(); //clock as a reference is to fast because of the comp processing speed
    }

    public String randomNumberSelection() {
        int min = 1;
        int max = 3;
        String randomNumberSelection;                               //deleted millisec clock
        Random random = new Random();                               // instantiated a new random to receive int
        int randomNumber = random.nextInt((max - min) + 1) + min;
        if (randomNumber == 1) {
            randomNumberSelection = "rock";
        } else if (randomNumber == 2) {
            randomNumberSelection = "paper";
        } else {
            randomNumberSelection = "scissors";
        }
        gestures.add(randomNumberSelection);
        return randomNumberSelection;
    }

    private void decideWinner() {
        String winnerAnnouncement;
        String winner;
        String tool = new String();

        if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS";
            winner = "player1";
            tool = "p1Rock";
        } else if (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: ROCK ----- COMPUTER WINS";
            winner = "player2";
            tool = "p2Rock";
        } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: PAPER vs Computer: ROCK ----- PLAYER WINS";
            winner = "player1";
            tool = "p1Paper";
        } else if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: ROCK vs Computer: PAPER ----- COMPUTER WINS";
            winner = "player2";
            tool = "p2Paper";
        } else if (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: PAPER ----- PLAYER WINS";
            winner = "player1";
            tool = "p1Scissors";
        } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: PAPER vs Computer: SCISSORS ----- COMPUTER WINS";
            winner = "player2";
            tool = "p2Scissors";
        } else {
            winnerAnnouncement = "Its a TIE ---- EVERYONE IS A LOSER";
            winner = "tie";
        }
        wins.add(winner);
        gestures.add(tool);
        // Print out who won in this format: "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS"
        System.out.println(winnerAnnouncement);
    }

    private void printGameStats() {
        int ties = 0;

        int player1WinsCount = 0;
        int p1Rock = 0;
        int p1Scissors = 0;
        int p1Paper = 0;

        int player2WinsCount = 0;
        int p2Rock = 0;
        int p2Scissors = 0;
        int p2Paper = 0;

        for (String tool : gestures) {
            switch (tool) {
                case "p1Rock":
                    p1Rock++;
                    break;
                case "p1Scissors":
                    p1Scissors++;
                    break;
                case "p1Paper":
                    p1Paper++;
                    break;
                case "p2Rock":
                    p2Rock++;
                    break;
                case "p2Scissors":
                    p2Scissors++;
                    break;
                case "p2Paper":
                    p2Paper++;
                    break;
            }
        }
        for (String winner : wins) {
            switch (winner) {
                case "player1":
                    player1WinsCount++;
                    break;
                case "player2":
                    player2WinsCount++;
                    break;
                default:
                    ties++;
                    break;
            }

        }

        System.out.println("Player 1 total wins: " + player1WinsCount);
        System.out.println("Player 1 total rock wins: " + p1Rock);
        System.out.println("Player 1 total paper wins: " + p1Paper);
        System.out.println("Player 1 total scissor wins: " + p1Scissors);

        System.out.println("Player 2 total wins: " + player2WinsCount);
        System.out.println("Player 2 total rock wins: " + p2Rock);
        System.out.println("Player 2 total paper wins: " + p2Paper);
        System.out.println("Player 2 total scissor wins: " + p2Scissors);

        System.out.println("Total number of ties: " + ties);

    }
}

//        public int getPlayer1Wins() {
////            int player1Wins = 0;
//            for(String winner : win) {
//                if(winner.equalsIgnoreCase("player one"))
//                    player1Wins++;
//            }
//            return player1Wins;
//        }
//
//        public int getPlayer2Wins() {
////            int player2Wins = 0;
//            for(String winner : win) {
//                if(winner.endsWith("player two"))
//                    player2Wins++;
//            }
//            return player2Wins++;
//        }
//
//        public int getTies() {
////            int ties = 0;
//            for(String winner : win) {
//                if(winner.endsWith("tie"))
//                    ties++;
//            }
//            return ties;
//        }








//    public void recordTurn(int player1Choice, int player2Choice) {
//        // Using the rules of Rock-Paper-Scissors, decide which player wins
//        //    (rule: rock beats scissors)
//        //    (rule: paper beats Rock)
//        //    (rule: scissors beats Paper)
//
//        // Print out who won in this format: "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS"
//
//        player1.add(player1Choice);
//        player2.add(player2Choice);
//        if (player1Choice > player2Choice) {
//            player1Wins("player 1");
//        } else if (player2Choice > player1Choice) {
//            player2Wins("player 1");
//        } else {
//            win.add("tie");
//        }
//    }
//
//    private void player1Wins(String s) {
//    }
//
//    private void player2Wins(String s) {
//    }

//    private void decideWinner(player1Wins, player2Wins) {
//        // Using the rules of Rock-Paper-Scissors, decide which player wins
//        //    (rule: rock beats scissors)
//        //    (rule: paper beats Rock)
//        //    (rule: scissors beats Paper)
//
//        // Print out who won in this format: "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS"
//
//        ninja.add(ninjaDeals);
//        alien.add(alienDeals);
//        if (ninjaDeals > alienDeals) {
//            win.add("ninja");
//        } else if (alienDeals > ninjaDeals) {
//            win.add("alien");
//        } else {
//            win.add("tie");
//        }
//    }¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶





//     How will you make computer's selection random?
//        (hint: you have already done this in several programs











