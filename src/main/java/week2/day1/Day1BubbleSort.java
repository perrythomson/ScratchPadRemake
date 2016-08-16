package week2.day1;

/**
 * Created by perrythomson on 7/18/16.
 */
public class Day1BubbleSort {
    public static void main(String[] args) {

                                //create an int array we want to sort using bubble sort algorithm
        int intArray[] = new int[]{5,90,35,45,150,3};

                                //print array before sorting using bubble sort algorithm
        System.out.println("Array Before Bubble Sort");
                                // TODO: loop through the array and print the values
        for(int num : intArray) {
            System.out.println(num);
        }
        System.out.println(" "); // just adding a space for readability

                                //sort an array using bubble sort algorithm
        intArray = bubbleSort(intArray);

                                //print array after sorting using bubble sort algorithm
        System.out.println("Array After Bubble Sort");
        for (int num : intArray) {                                  // TODO: loop through the array and print the values
            System.out.println(num);
        }
    }

    private static int[] bubbleSort(int[]  intArray) {              //we chose this name for the method

                                /*
                                 * In bubble sort, we basically traverse the array from first
                                 * to array_length - 1 position and compare the element with the next one.
                                 * Element is swapped with the next element if the next element is greater.
                                 *
                                 * Bubble sort steps are as follows.
                                 *
                                 * 1. Compare array[0] & array[1]
                                 * 2. If array[0] > array [1] swap it.
                                 * 3. Compare array[1] & array[2]
                                 * 4. If array[1] > array[2] swap it.
                                 * ...
                                 * 5. Compare array[n-1] & array[n]
                                 * 6. if [n-1] > array[n] then swap it.
                                 *
                                 * After this step we will have largest element at the last index.
                                 *
                                 * Repeat the same steps for array[1] to array[n-1]
                                 *
                                 */

                                // TODO: logic goes here we need to figure out the length of the array...we do this by the following method
        int arrayLength = intArray.length;
        int temp = 0;

        for (int i = 0; i < arrayLength; i++ ) {            //nested loops...just like the clock in the toolbox....find out why it works this way...
            for (int j = 1; j < (arrayLength - i); j++){
                if (intArray[j-1] > (intArray[j])) {
                    temp = intArray[j-1];               //need a temporary place to hold the variable until we can switch
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        return intArray;
    }
}



























