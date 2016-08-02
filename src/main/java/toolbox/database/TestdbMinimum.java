package toolbox.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by perrythomson on 8/2/16.
 */
public class TestdbMinimum {
    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");                     //setting the driver ...where it is
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:db_file","sa","");       //passing all 5 items
            Statement st = conn.createStatement();                                             // create a statement to send down the pipe
            ResultSet rs = st.executeQuery("SELECT id, str_col, num_col * FROM sample_table");                       //instead of instead of ("SELECT * FROM sample_table");              //data to get back from statement from query select * from sample_table
            while(rs.next()) {                                                                  // while the results
                String rowResults = rs.getInt("id")+" -- "+rs.getString("str_col")+" -- "+rs.getInt("num_col");  //dont use number from column but column id  //three columns id, string call, num call... without col number but put in column name
                System.out.println(rowResults);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
