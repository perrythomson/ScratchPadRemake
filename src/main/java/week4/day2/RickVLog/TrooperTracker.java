package week4.day2.RickVLog;

import java.util.Date;
import java.util.Scanner;

        import java.sql.*;
        import java.util.Scanner;
        import java.util.concurrent.SynchronousQueue;

public class TrooperTracker {

    public static void main(String[] args) {
        TrooperTracker trooperTracker = new TrooperTracker();
        trooperTracker.checkTable();
        try {
            trooperTracker.readAllRecords(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ask questions
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your Trooper Code?");
        String trooperCode = scanner.nextLine();
        System.out.println("Why are you here?");
        String note = scanner.nextLine();
        Date d = new Date(System.currentTimeMillis());
        trooperTracker.insertRecord(trooperCode,d.toString(),note);
    }

    private void createTable() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:troopers","sa","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE trooper_tracker ( id INTEGER IDENTITY, troopCode VARCHAR(256), signinDate VARCHAR(256),note VARCHAR(256))");

            stmt.close();
            conn.close();
        } catch(Exception e) {
            System.out.println("Table Already Exists");
        }
    }

    private void checkTable() {
        try {
            readAllRecords(false);
        } catch (Exception e) {
            createTable();
        }
    }

    private void readAllRecords(boolean printMe) throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:troopers","sa","");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id,troopCode,signinDate,note FROM trooper_tracker");
        while(rs.next()) {
            String rowResults = rs.getInt("id")+" -- "+rs.getString("troopCode")+" -- "+rs.getString("signinDate")+" -- "+rs.getString("note");
            if(printMe) {
                System.out.println(rowResults);
            }
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    private void insertRecord(String trooperCode, String signinDate, String note) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:troopers","sa","");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO trooper_tracker (troopCode, signinDate, note) VALUES (?,?,?);");
            stmt.setString(1,trooperCode);
            stmt.setString(2, signinDate);
            stmt.setString(3,note);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            System.out.println("NOTE: Finished Update");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}

