package week2.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by perrythomson on 7/18/16.
 */
public class Day1Palindrome {


    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);                     // name with a class with input
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);                      //take the input we type in...and reads it line by line

        System.out.println("Enter a word to test. Use 'exit' to stop application");
        while(true) {                                                                               //infinitely true...like 1 is always 1...this isn't  a boolean...
            try {
                String inputString = bufferedReader.readLine();
                if(inputString.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(isPalindromeStringBuilder(inputString));                                //same as commented lines but saves lines of code


// System.out.print(isPalindromeArrayLoop(inputString));
//     if(isPalindromeArrayLoop(inputString)) {
//                    System.out.println("true");
//                }  else {                                                                                     // TODO: logic
//                    System.out.println("die you dirt bag!");
//                }
            } catch (Exception e) {                                                                 //Exception pulls all exceptions to
                e.printStackTrace();                                                                //stack trace starts when input is received ***LOOK UP***
            }
        }                                                                                           //
    }

    private static boolean isPalindromeArrayLoop(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using an array loop and see if there is a match
        char[] inputStringCopy = inputString.toCharArray();                                         // ****Research CHAR ARRAY****
        int i = 0;
        for (int j = inputStringCopy.length - 1; j >= 0; j--){
            ;                                      //(counter boolean incrementer)
            inputStringCopy[i] = inputString.charAt(j);
            i++;                                                        // TODO: logic

        }
        if(inputString.equalsIgnoreCase(new String(inputStringCopy))) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    private static boolean isPalindromeStringBuilder(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using StringBuilder and see if it matches itself
        StringBuilder inputStringCopy = new StringBuilder();
        inputStringCopy.append(inputString);
        inputStringCopy = inputStringCopy.reverse();
        if (inputString.equalsIgnoreCase(inputStringCopy.toString())){
            isPalindrome = true;
        }

        return isPalindrome;
    }
}


