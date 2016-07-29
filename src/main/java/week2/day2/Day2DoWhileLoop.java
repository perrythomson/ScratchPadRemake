package week2.day2;

/**
 * Created by perrythomson on 7/19/16.
 */
public class Day2DoWhileLoop {

    public static void main(String args[]) {
        whileLoop(5);   // call the whileLoop method
        doWhileLoop(5);
        System.out.println();
        //call the doWhileLoopMethod
    }

    public static void whileLoop(int start) {               // create a new method called 'whileLoop' that takes an int called 'start'

        while (start >= 0) {
            System.out.println(start);
        start--;
        }
    }

    public static void doWhileLoop(int start) {

        do {
          System.out.println(start);
            start--;// create a while loop that iterates from start to zero and prints out the result

        } while (start >= 0);

    }

    // create a new method called 'doWhileLoop' that takes an int called 'start'
    // create a do-while loop that iterates from start to zero and prints out the result

}
