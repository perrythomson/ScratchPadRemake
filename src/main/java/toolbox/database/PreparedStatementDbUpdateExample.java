package toolbox.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by perrythomson on 8/2/16.
 */
public class PreparedStatementDbUpdateExample {
    static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
    static final String DB_URL = "jdbc:hsqldb:db_file";
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            stmt = conn.prepareStatement("UPDATE sample_table SET str_col = ? WHERE num_col = ?");
            stmt.setString(1,"Tesla");
            stmt.setInt(2,300);
            stmt.executeUpdate();

            //STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
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
