package toolbox;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Switches {

    // switches are an alternative to if-then-else statements when many flows can be chosen from a single value
    // a switch works with (primitives) char, byte, short  ----  (wrappers) Character, Byte, Short  ----  (Object) String


    public static void main(String[] args) {
        Switches switches = new Switches();
        switches.stringSwitch("Monday");
    }


    // This method is an example of a very simple case
    public void intSwitch(int month) {
        switch (month) {
            case 1: System.out.println("Jan"); break;
            case 2: System.out.println("Feb"); break;
            case 3: System.out.println("Mar"); break;
            case 4: System.out.println("Apr"); break;
            case 5: System.out.println("May"); break;
            case 6: System.out.println("Jun"); break;
            case 7: System.out.println("Jul"); break;
            case 8: System.out.println("Aug"); break;
            case 9: System.out.println("Sep"); break;
            case 10: System.out.println("Oct"); break;
            case 11: System.out.println("Nov"); break;
            case 12: System.out.println("Dec"); break;
        }
    }

    // allow the selected case to fall through where a block of cases have the same result and then break.
    // So if the month is 1, 3, 5, 7... they will all net the same result, numDays=31 and break.
    public void fallThroughCases(int month, int year) {
        int numDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            default:
                System.out.println("Invalid Month");
                break;
        }
        System.out.println("Number of day: "+numDays);
    }

    // The same thing, but using Strings instrad of ints. Requires Java 7 or greater
    public void stringSwitch(String dayOfWeek) {
        String typeOfDay ="";
        switch(dayOfWeek) {
            case "Monday" :
                typeOfDay = "The Start of the work week.";
                break;
            case "Tuesday" :
            case "Wednesday" :
            case "Thursday" :
                typeOfDay = "Midweek.";
                break;
            case "Friday" :
                typeOfDay = "End of the work week.";
                break;
            case "Saturday" :
            case "Sunday" :
                typeOfDay = "The weekend.";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: "+dayOfWeek);
        }
        System.out.println(dayOfWeek+" --- Type of Day: "+typeOfDay);
    }
}