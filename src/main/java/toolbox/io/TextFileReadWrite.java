package toolbox.io;

/**
 * Created by perrythomson on 7/28/16.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileReadWrite {
    public static void main(String[] args) {
        Path myFilePath = Paths.get("TextFileReadWrite.txt");
        String myFileContent = "We are writing and reading a text file.";

        // writing the text file
        try {
            BufferedWriter writer = Files.newBufferedWriter(myFilePath);
            writer.write(myFileContent);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // reading the text file
        try {
            BufferedReader reader = Files.newBufferedReader(myFilePath);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}