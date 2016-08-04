package week4.day2.PVisitorLog;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by perrythomson on 8/3/16.
 */
public class VisitorLogCombo {

    public static void main(String[] args){
        VisitorLogCombo vlc = new VisitorLogCombo();
        vlc.checkTable();
        try {
            vlc.updateTable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);                   //q's to fill in table
        System.out.println("What is your name?");
        String visitorName = scanner.nextLine();
        System.out.println("What is your purpose?");
        String visitorPurpose = scanner.nextLine();
        Date d = new Date(System.currentTimeMillis());              // can input or get current time as done previously
        vlc.insertRecord(visitorName, d.toString(), visitorPurpose);
    }

    private void createTable(){                                     //create a table, (retrieve, update, delete)data
        try { Class.forName("org.hsqldb.jbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:visitorsDB", "AA", "");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE visitor_log (id INTEGER IDENTITY , visitorName VARCHAR(256), signInDate VARCHAR(256), visitorPurpose VARCHAR(256))");
            stmt.close();
            conn.close();

        } catch (Exception e){
            System.out.println("Table Already Exists");
        }
    }

    private void checkTable(){
        try {updateTable(false);
        } catch(Exception e){
            createTable();
        }
    }

    private void updateTable(boolean printMe) throws Exception {
        Class.forName("org.hsqldb.jbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:visitorsDB", "AA", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, visitorName, signInDate, visitPurpose FROM visitor_log");
        while (rs.next()) {
            String rowResults = rs.getInt("id")+" -- "+rs.getString("visitorName")+" -- "+rs.getString("signInDate")+" -- "+rs.getString("visitPurpose");
            if(printMe);
                System.out.println(rowResults);
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    private void insertRecord(String visitorName, String signInDate, String visitPurpose){
        try { Class.forName("org.hsqldb.jbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:visitorsDB", "AA", "");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO visitor_log (visitorName, signInDate, visitPurpose) VALUES (?,?,?);");
            stmt.setString(1,visitorName);
            stmt.setString(2,signInDate);
            stmt.setString(3,visitPurpose);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            System.out.println("Update Complete");
        } catch (Exception e){
            e.printStackTrace();
            // System.out.println("Table Already Exists");
        }
    }

}
