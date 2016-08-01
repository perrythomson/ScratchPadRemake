package toolbox.io;

/**
 * Created by perrythomson on 7/28/16.
 */

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReadWrite {
    public static void main(String[] args) throws IOException {
        Path myFilePath = Paths.get("Person.json");
        ObjectMapper mapper = new ObjectMapper();       // can reuse, share globally
                                                         // instantiate and populate person object to write
        Person personObject1 = new Person();
        personObject1.setName("Alice Smith");
        personObject1.setAge(30);
                                                            // instantiate an empty person object for the read
        Person personObject2 = new Person();

                                                            // write from Person object to JSON file
        mapper.writeValue(Files.newOutputStream(myFilePath), personObject1);

                                                                // from JSON file to Person object
        personObject2 = mapper.readValue(Files.newInputStream(myFilePath), Person.class);

        System.out.println(personObject2.getName());
        System.out.println(personObject2.getAge());
    }
}
