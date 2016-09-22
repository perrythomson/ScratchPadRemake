package week2.day2;

/**
 * Created by perrythomson on 7/19/16.
 */
public class Day2EnhancedForLoop {
    // build a private static char array with the values a,b,c,d,e,f,g, and h

    private static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public static void main(String[] args) {
        forLoop(letters);       //letters is the character array which it calls for // call forLoop
        enhancedForLoop(letters);

        System.out.println(" ");
        System.out.println("---");
        // call enhancedForLoop
    }

    public static void forLoop(char[] letters) {            // create a method named 'forLoop' that prints out all the values of the char array using a standard for-loop
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
            System.out.print("----");
        }
    }

    public static void enhancedForLoop(char[] letters) {
        for(char letter : letters ){
            System.out.println(letter);
        }
    }

}







    // create a method named 'enhancedForLoop' that prints out all the values of the char array using an enhanced for-loop


