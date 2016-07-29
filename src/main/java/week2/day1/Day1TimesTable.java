package week2.day1;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Day1TimesTable {
    public static void main(String[] args) {
        int tableSize = 12;
        printTimesTable(tableSize);
    }

    public static void printTimesTable(int tableSize) {             //local variable tableSize
        // first print the top header row using a for-loop
        System.out.format("      ");
        for (int i = 1; i <= tableSize; i++) {
            System.out.format("%4d", i);                             //format for variables

        }
        System.out.println();
        System.out.println("--------------------------------------------------------");

        for (int x = 1; x <= tableSize; x++) {                                   // create another for-loop to start building the rows
            System.out.format("%4d  |", x);                                     // print left most column first
            for (int y = 1; y <= tableSize; y++) {
                System.out.format("%4d", x*y);                                  // create another loop to fill in the multiplied columns

            }

            System.out.println();// system print ln OUT of the for loop into the other 'for loop' once it has gone through the 12 steps of multiplication
        }
    }
}

