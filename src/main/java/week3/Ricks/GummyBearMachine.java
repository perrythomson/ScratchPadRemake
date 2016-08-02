package week3.Ricks;

/**
 * Created by perrythomson on 8/1/16.
 */
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GummyBearMachine {

    public static void main(String[] args) {
        GummyBear gummyBear = new GummyBear();
        Path myFilePath = Paths.get("GummyBear.json");
        ObjectMapper mapper = new ObjectMapper();
        readfile(gummyBear,myFilePath,mapper);
        System.out.println("------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to change your order?  [YES/NO]");
        String changeOrder = scanner.nextLine();
        if(changeOrder.equalsIgnoreCase("yes")) {
            System.out.println("What color?");
            gummyBear.setColor(scanner.nextLine());
            System.out.println("What weight?");
            gummyBear.setWeight(scanner.nextLine());
            System.out.println("What flavor?");
            gummyBear.setFlavor(scanner.nextLine());
            writeFiles(gummyBear,myFilePath,mapper);

            System.out.println("------------------------");
            System.out.println("This is what you wrote");
            readfile(gummyBear,myFilePath,mapper);
        }
    }

    private static void readfile(GummyBear gb, Path p, ObjectMapper m) {
        try {
            gb = m.readValue(Files.newInputStream(p), GummyBear.class);
            System.out.println("COLOR: "+gb.getColor());
            System.out.println("WEIGHT: "+gb.getWeight());
            System.out.println("FLAVOR: "+gb.getFlavor());
        } catch (IOException e) {
            System.out.println("Files does not exist yet...");
        }
    }

    private static void writeFiles(GummyBear gb, Path p, ObjectMapper m) {
        try {
            m.writeValue(Files.newOutputStream(p), gb);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

