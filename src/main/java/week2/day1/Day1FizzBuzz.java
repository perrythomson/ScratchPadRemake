package week2.day1;

/**
 * Created by perrythomson on 7/18/16.
 */
public class Day1FizzBuzz {
    public static void main(String[] args) {
        thisWay();
        thatWay();
        yetAnotherWay();
        yetAnotherNotherWay();
    }
    public static void yetAnotherWay() {
        String returnThis = "";
        for (int i = 1; i <= 100; i++) {              // (variable, boolean, incrementer)
            returnThis = "";                        // this returns a blank state of being empty otherwise it would print out fizz
            if (i % 3 == 0) {
                returnThis = "Fizz";
            }
            if (i % 5 == 0) {
                returnThis = "Buzz";

            }
            if ((i % 3 == 0) && (i % 5 == 0)) {     //or change the && statement to one statement with 15
                returnThis = "FizzBuzz";

            } else {
                if (returnThis.isEmpty()) {
                    System.out.println(i);
                } else {
                    System.out.println(returnThis);
                }

            }
        }
    }

    public static void thisWay() {
        String returnThis = "";
        for (int i = 1; i <= 100; i++) {              // (variable, boolean, incrementer)
            returnThis = "";                        // this returns a blank state of being empty otherwise it would print out fizz
            if (i % 3 == 0) {
                returnThis += "Fizz";               //adding the += injects the fizz first into all lines divided by 3 and then adds the buzz
            }
            if (i % 5 == 0) {
                returnThis += "Buzz";

            } else {
                if (returnThis.isEmpty()) {
                    System.out.println(i);
                } else {
                    System.out.println(returnThis);
                }

            }
        }
    }

    public static void thatWay() {
        for (int i = 1; i <= 100; i++) {                // (variable, boolean, incrementer)
            if (i % 3 == 0) {
                System.out.println("Fizz");

            }
            if (i % 5 == 0) {

                System.out.println("Buzz");
            }
            if (i % 15 == 0) {

                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);

            }

        }
    }

    public static void yetAnotherNotherWay() {
        for (int i = 1; i<=100; i++){
            if (i % 15 ==0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Fizz");
            } else if (i % 3 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }



}

