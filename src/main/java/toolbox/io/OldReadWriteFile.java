package toolbox.io;

/**
 * Created by perrythomson on 7/28/16.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OldReadWriteFile {
    public static void main(String[] args) throws IOException {
        File myFile = new File("Names.txt");

        // write content to file using IO libraries
        FileWriter fileWriter = new FileWriter(myFile);
        fileWriter.write("Alice\n"); // overwrites file
        fileWriter.append("Bob\n");
        fileWriter.append("Charlie\n");
        fileWriter.close();

        // read line-by-line
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        // read entire file
        scanner = new Scanner(myFile);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);
    }
}