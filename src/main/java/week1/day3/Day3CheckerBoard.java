package week1.day3;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Day3CheckerBoard {

    public static void main (String[] args) {
        int size = 9;    // size of the board

        for (int row = 1; row <= size; row++) {
            boolean isRowEven = false;
            String printRow = "";
            // Use modulus 2 to find alternate lines
            if ((row % 2) == 0) {   // row 2, 4, 6, 8
                isRowEven = true;
            }
            for (int col = 1; col <= size; col++) {

                if(isRowEven) {
                    printRow = printRow+" * ";
                    isRowEven = false;
                } else {
                    isRowEven = true;
                    printRow = printRow+"   ";
                }
            }
            System.out.println(printRow);
        }
    }
}