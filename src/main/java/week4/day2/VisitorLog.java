//package week4.day2;
//
//import java.sql.*;
//import java.util.Scanner;
//
//import static week4.day2.CreateVisitorTable.CreateVisitorTable;
//import static week4.day2.VisitorQuery.VisitorQuery;
//
///**
// * Created by perrythomson on 8/2/16.
// */
//public class VisitorLog {
//    private String GuestName;
//    private String VisitDate;
//    private String Reason;
//    private String CheckInTime;
//    private String CheckOutTime;
//
//    public String getGuestName() {
//        return GuestName;
//    }
//    public void setGuestName(String guestName) {
//        GuestName = guestName;
//    }
//
//    public String getVisitDate() {
//        return VisitDate;
//    }
//    public void setVisitDate(String visitDate) {
//        VisitDate = visitDate;
//    }
//
//    public String getReason() {
//        return Reason;
//    }
//    public void setReason(String reason) {
//        Reason = reason;
//    }
//
//    public String getCheckInTime() {return CheckInTime;}
//    public void setCheckInTime(String checkInTime) {CheckInTime = checkInTime;}
//
//    public String getCheckOutTime() {return CheckOutTime;}
//    public void setCheckOutTime(String checkOutTime) {CheckOutTime = checkOutTime;}
//
//
//    public static void main(String[] args){
//        Connection conn = null;
//
//        try{Class.forName("org.hsqldb.jbcDriver");  //registrating the driver?
//            conn = DriverManager.getConnection("jdbc:hsqldb:patronDB", "AA", ""); //the url is where the database is stored...will add username and password for protection
//
//            Scanner scanner=new Scanner(System.in);
//            System.out.println("Welcome, please type in your selection: \n [Sign In/Sign Out/View Records]");
//            String guest = scanner.nextLine();
//            VisitorLog vl = new VisitorLog();
//
//            if (guest.equalsIgnoreCase("patron")){
//                guestTableCreator();
//            }
//
//            if (guest.equalsIgnoreCase("Sign Out")){
//                PreparedStatement signOut = conn.prepareStatement("UPDATE visitor_log SET guestOut = ? WHERE guestName = ?");
//                System.out.println("Re-enter your name: ");
//                vl.setGuestName(scanner.nextLine());
//                System.out.println("Enter your Check Out Time");
//                vl.setCheckOutTime(scanner.nextLine());
//                signOut.setString(1,vl.getCheckOutTime());
//                signOut.setString(2,vl.getGuestName());
//                signOut.executeUpdate();
//                System.out.println("Thank you have a great day.");
//                signOut.close();
//            }
//
//            if (guest.equalsIgnoreCase("Sign In")) {
//                PreparedStatement signIn = conn.prepareStatement("INSERT INTO visitor_log (guestName, visitDate, reason, checkIn) VALUES (?, ?, ?, ?)");
//                System.out.println("What is your name?");
//                vl.setGuestName(scanner.nextLine());
//                System.out.println("What is the date?");
//                vl.setVisitDate(scanner.nextLine());
//                System.out.println("What is your purpose of your visit?");
//                vl.setReason(scanner.nextLine());
//                System.out.println("Arrival Time?");
//                vl.setCheckInTime(scanner.nextLine());
//
//                signIn.setString(1, vl.getGuestName()); //first ?, =
//                signIn.setString(2, vl.getVisitDate()); // second ?, =
//                signIn.setString(3, vl.getReason());
//                signIn.setString(4, vl.getCheckInTime());
//                signIn.executeUpdate();
//                System.out.println("Thank You!");
//                signIn.close();
//            }
//            if (guest.equalsIgnoreCase("View")){
//                guestTableQuery;
//            }
//            conn.close();
//
//        }catch (SQLException se){
//            se.printStackTrace();
//        }catch (Exception e){
//            e.printStackTrace();
//        } finally {                 //last thing to do to close
//            try{if (conn!=null)
//                conn.close();
//            }catch (SQLException se){
//                se.printStackTrace();
//            }
//         //   System.out.println("conn closed");  //see if code works to this point
//        }
//
//
//
//    }
//
//}
