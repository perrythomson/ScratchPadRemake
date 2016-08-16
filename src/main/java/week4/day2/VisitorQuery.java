package week4.day2;

import java.sql.*;

/**
 * Created by perrythomson on 8/2/16.
 */
public class VisitorQuery {

        static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
        static final String DB_URL = "jdbc:hsqldb:db_file";
        static final String USER = "AA";
        static final String PASS = "";



        public static void VisitorQuery () {
            Connection conn = null;
            PreparedStatement stmt = null;                      //secure statment different from other database examples
            try {
                //STEP 1: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 2: Open a connection
                System.out.println("Connecting to the visitor database...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 3: Execute a query

                stmt = conn.prepareStatement("SELECT id, guestName, visitDate, reason, checkIn, " +
                        "checkOut FROM visitor_log WHERE id<?");
                stmt.setInt(1,100);
                ResultSet rs = stmt.executeQuery();

                //STEP 4: Extract data from result set
                while(rs.next()) {
                    //Retrieve by column name
                    int id  = rs.getInt("VisitorID");
                    String guestName = rs.getString("GuestName");
                    String visitDate = rs.getString("VisitDate");
                    String reason = rs.getString("Reason");
                    String checkIn = rs.getString("CheckIn");
                    String checkOut = rs.getString("CheckOut");

                    //Display values
                    String resultString = "Visitor ID: " + id;
                    resultString += ", Guest First and Last Name: " + guestName;
                    resultString += ", Date of Visit: " + visitDate;
                    resultString += ", Reason: " + reason;
                    resultString += ", Check In: " + checkIn;
                    resultString += ", Check Out: " + checkOut;
                    System.out.println(resultString);
                }
                //STEP 5: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();

            } catch(SQLException se) {
                se.printStackTrace();
                //todo change exception e
//            }  catch(ClassNotFoundException cnfe) { //understand differences
//                cnfe.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    if(stmt!=null)
                        stmt.close();
                } catch(SQLException se2) {
                } try {
                    if(conn!=null)
                        conn.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }

    }


