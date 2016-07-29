package week1.day3;

/**
 * Created by perrythomson on 7/28/16.
 */
public class DigitalClock {

    public static void main(String[] args) {

        for(int h = 0; h < 24; h++) {
            System.out.println("hours " + h);

            for(int m = 0; m < 60; m++) {
                System.out.println("minutes " + m);

                for(int s = 0; s < 60; s++) {
                    System.out.println("seconds " + s);
                }

            }

        }
    }

}