package week2.day4;

/**
 * Created by perrythomson on 7/21/16.
 */
public class Day4InfiniteLoop {

    public static void main(String[] args) {
        boolean shouldLoopEnd = false; //shouldLoopEnd is global...
        int targetNumber = (int) (Math.random() * 100);
        System.out.println ("The target number is: " + targetNumber);
        while (!shouldLoopEnd) {                                        //its not "true"...shoudl be not///could have used !guessnumber == target number if guessnumber was global
            int guessNumber = (int) (Math.random() * 100);
            System.out.println ("The loop guesses: " + guessNumber);
            if (guessNumber == targetNumber) {
                shouldLoopEnd = true;
            }
            if (shouldLoopEnd) {
                System.out.println ("Woo hoo! We have a match!");
            } else {
                System.out.println ("Let's try again..");
            }
        }
    }


}
