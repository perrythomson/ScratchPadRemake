package week2.day2;
/**
 * Created by perrythomson on 7/19/16.
 */
public class Day2FixNSwitchStatement {
    private static char branch = 'E'; // C - CSE, E - ECE, M - Mech
    private static int year = 3;

    public static void main(String[] args) {
        switchIt();
    }




    private static String switchIt() {
        String yearString = "";
        String branchString = "";
        switch (year) {
            case 1:
                System.out.println("English, Math, Drawing");
                break;
            case 2:
                switch (branch) // LINE C
                {
                    case 'C':
                        System.out.println("Data structures, Java, Computer Organization");
                        break;
                    case 'E':
                        System.out.println("Micro processors, Logic switching theory");
                        break;
                    case 'M':
                        System.out.println("Drawing, Manufacturing Machines");
                        break;
                    default: branchString = "Invalid.";
                        break;
                }
                return branchString;

            case 3:
                switch (branch) // LINE D
                {
                    case 'C':
                        System.out.println("Operating System, RDBMS");
                        break;
                    case 'E':
                        System.out.println("Fundamentals of Logic Design, Microelectronics");
                        break;
                    case 'Z':
                        System.out.println("Internal Combustion Engines, Mechanical Vibration");
                        break;
                    default: branchString = "Invalid.";
                        break;
                }
                return branchString;

        default: yearString = "Invalid.";
        break;

        }

        return yearString;
    }
}
