//package week4.day2;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import week3.JsonWeek3WeekendAssignment.Car;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//
///**
// * Created by perrythomson on 8/2/16.
// */
//public class UpdateCreateVisitorLog {
//
//    static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
//    static final String DB_URL = "jdbc:hsqldb:db_file";
//    static final String USER = "sa";
//    static final String PASS = "";
//
//    public static void main(String[] args) {
//        VisitorPerson vp = new VisitorPerson();                            //instantiation of car - this is where the variables of Manu, Make and Model are get/set
////        Path myFilePath = Paths.get("VisitorPerson.json");        // path is needed to identify the file where info stored json
////        ObjectMapper mapper = new ObjectMapper();       //ObjectMapper is the main actor class of Jackson library. ObjectMapper class provides functionalities to convert Java objects to matching JSON constructs and vice versa
////        readfile(vp, myFilePath, mapper);
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        Scanner scanner = new Scanner(System.in);           //needed for scanning info from system.in or input
//        System.out.println("Would you like to sign in? [Yes/No]");
//        String enterVisitor = scanner.nextLine();
//        if (enterVisitor.equalsIgnoreCase("yes")) {
//            System.out.println("Guest Name: ");
//            vp.setGuestName(scanner.nextLine()); // asks and then saves information
//            System.out.println("Date of Visit: ");
//            vp.setVisitDate(scanner.nextLine());         // asks and then saves information
//            System.out.println("Purpose of Visit: ");
//            vp.setReason(scanner.nextLine());            // asks and then saves information
//
//        }
////            writeFiles(vp, myFilePath, mapper);        //writes info to the Car file
//
//            try {
//                //STEP 1: Register JDBC driver
//                Class.forName(JDBC_DRIVER);
//
//                //STEP 2: Open a connection
//                System.out.println("Thank you...");
//                conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//
//                //STEP 3: Execute a query
//                stmt = conn.prepareStatement("INSERT INTO VisitorRegistry VALUE VisitorID=?, GuestName = ?,VisitDate = ?,Reason = ?");
//                stmt.setString( getGuestName);
//                stmt.setInt(2, 300);
//                stmt.executeUpdate();
//
//                //STEP 4: Clean-up environment
//                stmt.close();
//                conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (stmt != null)
//                        stmt.close();
//                } catch (SQLException se2) {
//                }
//                try {
//                    if (conn != null)
//                        conn.close();
//                } catch (SQLException se) {
//                    se.printStackTrace();
//                }
//            }
//            System.out.println("Goodbye!");
//        }
//
//    }
////    private static void readfile(VisitorPerson vp, Path myFilePath, ObjectMapper mapper) {   //needed a read and write file method
////        try {                                                                       // can rename from Car car to Car c ...left this way to understand better
////            vp = mapper.readValue(Files.newInputStream(myFilePath), VisitorPerson.class);    //if name change to Car c ...c needs to replace variable inputs
////            System.out.println("Visitor Name: " + vp.getGuestName());
////            System.out.println("Date of Visit: " + vp.getVisitDate());
////            System.out.println("Purpose of Visit: " + vp.getReason());
////        } catch (IOException e){                                                    //io is a class of Exception that was raised due to all Input/Output contingencies . The file operations like read(), write() and close() etc. are OS dependent and are declared as native methods
////            System.out.println("No such file");                                     // this is needed in the case where no file can be found IO - mac
////        }
////    }
////
////    private static void writeFiles(VisitorPerson vp, Path myFilePath, ObjectMapper mapper ){
////        try{
////            mapper.writeValue(Files.newOutputStream(myFilePath), vp);              //again mapper converts java to json
////        } catch(IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//
//
//
