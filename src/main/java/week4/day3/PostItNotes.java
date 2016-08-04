//package week4.day3;
//
//import week4.day2.RickVLog.TrooperTracker;
//
//import java.sql.*;
//import java.util.Date;
//import java.util.Scanner;
//import java.util.Date;
//import java.util.Scanner;
//
//import java.sql.*;
//import java.util.Scanner;
//import java.util.concurrent.SynchronousQueue;
///**
// * Created by perrythomson on 8/3/16.
// */
//public class PostItNotes {
//
//    public static void postItNotes() {
//        PostItNotes postItNotes = new PostItNotes();
//        postItNotes.checkTable();
//        try {
//            postItNotes.readAllRecords(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // ask questions
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is your PostIt Name?");
//        String postItName = scanner.nextLine();
//        System.out.println("What color?");
//        String postItColor = scanner.nextLine();
//        System.out.println("What is the Description");
//        String postItDesc = scanner.nextLine();
//
//        Date d = new Date(System.currentTimeMillis());
//        postItNotes.insertRecord(postItName, postItColor,postItDesc, d.toString());
//
//
//
//    }
//
//    private void createTable() {
//        try {
//            Class.forName("org.hsqldb.jdbcDriver");
//            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postItProgram","sa","");
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE postIt_format ( id INTEGER IDENTITY, postItName VARCHAR(256), postItColor VARCHAR(256), postItDesc VARCHAR(256), dateOfPost VARCHAR(256))");
//
//            stmt.close();
//            conn.close();
//        } catch(Exception e) {
//            System.out.println("Table Already Exists");
//        }
//    }
//
//    private void checkTable() {
//        try {
//            readAllRecords(false);
//        } catch (Exception e) {
//            createTable();
//        }
//    }
//
//    private void readAllRecords(boolean printMe) throws Exception {
//        Class.forName("org.hsqldb.jdbcDriver");
//        Connection conn = DriverManager.getConnection("jdbc:hsqldb:postItProgram","sa","");
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT id,postItName, postItColor, postItDesc,signinDate FROM postIt_format");
//        while(rs.next()) {
//            String rowResults = rs.getInt("id")+" -- "+rs.getString("postItName")+" -- "+rs.getString("postItColor")+" -- "+rs.getString("postItMemo")+" -- "+rs.getString("signinDate");
//            if(printMe) {
//                System.out.println(rowResults);
//            }
//        }
//
//        rs.close();
//        stmt.close();
//        conn.close();
//    }
//
//    private void insertRecord(String postItName, String postItColor, String postItDesc, String signinDate) {
//        try {
//            Class.forName("org.hsqldb.jdbcDriver");
//            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postItProgram","sa","");
//            PreparedStatement stmt = conn.prepareStatement("INSERT INTO postIt_format (postItName, postItColor, postItDesc, signinDate) VALUES (?,?,?,?);");
//            stmt.setString(1,postItName);
//            stmt.setString(2, postItColor);
//            stmt.setString(3, postItDesc);
//            stmt.setString(4, signinDate);
//            stmt.executeUpdate();
//
//            stmt.close();
//            conn.close();
//            System.out.println("NOTE: Finished Update");
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // this section is for the data on the post-it if I can do it on one page...cant because different main
//
//}
