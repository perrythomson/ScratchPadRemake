package week3.JsonWeek3WeekendAssignment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by perrythomson on 8/1/16.
 */
public class CarEntry {

    public static void main(String[] args) {
        Car car = new Car();                            //instantiation of car - this is where the variables of Manu, Make and Model are get/set
        Path myFilePath = Paths.get("Car.json");        // path is needed to identify the file where info stored json
        ObjectMapper mapper = new ObjectMapper();       //ObjectMapper is the main actor class of Jackson library. ObjectMapper class provides functionalities to convert Java objects to matching JSON constructs and vice versa
        readfile(car, myFilePath, mapper);              //reads file from json...if nothing on the file or no file will return nothing

        Scanner scanner = new Scanner(System.in);           //needed for scanning info from system.in or input
        System.out.println("What to update your auto? Yes/No ");
        String changeAuto = scanner.nextLine();
        if (changeAuto.equalsIgnoreCase("yes")) {
            System.out.println("Car Manufacturer: ");
            car.setCarManufacturer(scanner.nextLine()); // asks and then saves information
            System.out.println("Car Make: ");
            car.setCarMake(scanner.nextLine());         // asks and then saves information
            System.out.println("Car Model: ");
            car.setCarModel(scanner.nextLine());            // asks and then saves information

            writeFiles(car, myFilePath, mapper);        //writes info to the Car file

            System.out.println("This is your last entry: ");
            readfile(car, myFilePath, mapper);              //displays info from the Car file
        }
    }

    private static void readfile(Car car, Path myFilePath, ObjectMapper mapper) {   //needed a read and write file method
        try {                                                                       // can rename from Car car to Car c ...left this way to understand better
            car = mapper.readValue(Files.newInputStream(myFilePath), Car.class);    //if name change to Car c ...c needs to replace variable inputs
            System.out.println("Car Manufacturer: " + car.getCarManufacturer());
            System.out.println("Car Make: " + car.getCarMake());
            System.out.println("Car Model: " + car.getCarModel());
        } catch (IOException e){                                                    //io is a class of Exception that was raised due to all Input/Output contingencies . The file operations like read(), write() and close() etc. are OS dependent and are declared as native methods
            System.out.println("No such file");                                     // this is needed in the case where no file can be found IO - mac
        }
    }

    private static void writeFiles(Car car, Path myFilePath, ObjectMapper mapper ){
        try{
            mapper.writeValue(Files.newOutputStream(myFilePath), car);              //again mapper converts java to json
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
