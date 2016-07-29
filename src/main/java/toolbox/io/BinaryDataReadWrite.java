package main.java.toolbox.io;

/**
 * Created by perrythomson on 7/28/16.
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinaryDataReadWrite {
    public static void main(String[] args) {
        Path myFilePath = Paths.get("StreamedFileReadWrite.txt");
        String myFileContent = "We are writing and reading file content using a Binary Stream.";
        byte[] myFileContentByteArray = myFileContent.getBytes();

        // write the file content using unbuffered binary stream
        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(myFilePath));
            out.write(myFileContentByteArray);
            out.flush();
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // read file using unbuffered binary stream
        try {
            InputStream in = Files.newInputStream(myFilePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
