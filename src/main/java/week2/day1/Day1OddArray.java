package week2.day1;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by perrythomson on 7/18/16.
 */
public class Day1OddArray {
    private List<int[]> arrayHolder = new ArrayList<int[]>();                           // ArrayList holds all the different arrays below...it is a collection of arrays

    public static void main(String[] args) {
        Day1OddArray oddArray = new Day1OddArray();                                         //create its own instance so that you can call it and reference to that class..instantiation
        oddArray.initializeNumberHolder();
        oddArray.checkOddArrays();
    }

    private void initializeNumberHolder() {
        System.out.println("populating arrays");
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,16,18,19});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11,12});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        arrayHolder.add(new int[]{1,2,3,4,5,6,7,8,9,10});
        arrayHolder.add(new int[]{2,3,4,5,6,7,8,9,10});
        arrayHolder.add(new int[]{3,4,5,6,7,8,9,10});
        arrayHolder.add(new int[]{4,5,6,7,8,9,10});
        arrayHolder.add(new int[]{6,7,8,9,10});
        arrayHolder.add(new int[]{7,8,9,10});
        arrayHolder.add(new int[]{8,9,10});
        System.out.println("arrays populated");
    }

    private void checkOddArrays() {
        //loop through the ArrayList and pull out the int[]s
        //As you pull out each int[], check the count for odd
        // and the sum for odd
        for (int[] intHolder: arrayHolder) {
            //if both are odd, print "ODD MATCH", else print "REJECTED"
            if(isOddCount(intHolder) && isSummedOdd(intHolder)) { //these are provided from the booleans isOddCount and isSummedOdd - can do isEvenCount and isSummedEven
                System.out.println("Odd match!");
            } else {
                    System.out.println("Rejected as even");             //if both are odd, print "ODD MATCH", else print "REJECTED"
            }
        }
    }

    private boolean isOddCount(int[] intHolder) {
        // count the number of ints in the int[]
        // if odd, return true, else return false
        boolean isOdd = false;
//        int arraySize = intHolder.length;
//        if(!(arraySize % 2 == 0)) {
        if(!(intHolder.length % 2 == 0)) {
            isOdd = true;
        }
        return isOdd;
    }


    private boolean isSummedOdd(int[] intHolder) {
        // sum the ints in the int[]
        // if they equal an odd number, return true, else return false
        boolean isOdd = false;
        int sum = 0;
        for(int i : intHolder) {
            sum += i;
        }
        if(!(sum % 2 == 0)) {
            isOdd = true;
        }
        return isOdd;
    }
}


