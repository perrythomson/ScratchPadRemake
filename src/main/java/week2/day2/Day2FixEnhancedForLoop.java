package week2.day2;

/**
 * Created by perrythomson on 7/19/16.
 */
public class Day2FixEnhancedForLoop {
    private static int[][] twoDArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static int[][][] threeDArray =
            {  { {1,   2,  3}, { 4,  5,  6}, { 7,  8,  9} },
                    { {10, 11, 12}, {13, 14, 15}, {16, 17, 18} },
                    { {19, 20, 21}, {22, 23, 24}, {25, 26, 27} } };

    public static void main(String[] args) {
        printTwoDArray();
        EnhancedPrintTwoDArray();
        printThreeDArray();
        EnhancedPrintThreeDArray();
    }

    private static void printTwoDArray() {
        System.out.println("Printing out 2D Array with standard for-loop:");
        for(int i = 0; i < twoDArray.length; i++) {
            int[] secondDArray = twoDArray[i];
            String secondDPrint = "";
            for(int j = 0; j < secondDArray.length; j++) {
                secondDPrint += secondDArray[j]+" ";
            }
            System.out.println(secondDPrint);
        }
    }

    private static void EnhancedPrintTwoDArray() {
        System.out.println("Printing out 2D Array with standard for-loop:");
        for(int [] secondDArray : twoDArray) {
//            int[] secondDArray = twoDArray[i];  // already defined in the line
            String secondDPrint = "";
            for(int i : secondDArray) {
                secondDPrint += i +" ";             // pulling out ints

            }
            System.out.println(secondDPrint);
        }
    }
    private static void printThreeDArray() {
        System.out.println("Printing out 3D Array with standard for-loop:");
        for(int i = 0; i < threeDArray.length; i++) {
            int[][] secondDArray = threeDArray[i];
            for(int j = 0; j < secondDArray.length; j++) {
                int[] thirdDArray = secondDArray[j];
                String thirdDPrint = "";
                for(int k = 0; k < thirdDArray.length; k++) {
                    thirdDPrint += thirdDArray[k]+" ";
                }
                System.out.println(thirdDPrint);
            }
        }
    }

    private static void EnhancedPrintThreeDArray() {
        System.out.println("Printing out 3D Array with ENHANCED for-loop:");
        for(int [][] secondArray : threeDArray) {
            for(int [] thirdDArray : secondArray) {
                String thirdDPrint = "";
                for(int k : thirdDArray) {
                    thirdDPrint += k +" ";
                }
                System.out.println(thirdDPrint);
            }
        }
    }

}
