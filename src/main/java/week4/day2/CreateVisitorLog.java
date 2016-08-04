package week4.day2;

import java.sql.*;

/**
 * Created by perrythomson on 8/2/16.
 */
public class CreateVisitorLog {
    Connection conn;

    public CreateVisitorLog(String registry_file) throws Exception {

        Class.forName("org.hsqldb.jdbcDriver");

        conn = DriverManager.getConnection("jdbc:hsqldb:"+ registry_file, "sa", "");                      // password
    }

    public static void main(String[] args) {

        week4.day2.CreateVisitorLog registry = null;

        try {
            registry = new week4.day2.CreateVisitorLog("registry_file");
        } catch (Exception ex1) {
            ex1.printStackTrace();    // could not start db

            return;                   // bye bye
        }

        try {

            registry.update(
                    "CREATE TABLE VisitorRegistry ( VisitorID INTEGER IDENTITY, GuestName VARCHAR(25), VisitDate VARCHAR(12), Reason VARCHAR(250))");
        } catch (SQLException ex2) {

        }

        try {

            registry.update(
                    "INSERT INTO VisitorRegistry(GuestName,VisitDate,Reason) VALUES('Bill Nye', 'Feb 16 2016', 'Visit VP')");
            registry.update(
                    "INSERT INTO VisitorRegistry(GuestName,VisitDate,Reason) VALUES('Stephen Hawking', 'March 3 2016', 'Seminar')");

            // do a query
            registry.query("SELECT * FROM VisitorRegistry WHERE VisitorID < 100");

            // at end of program
            registry.shutdown();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
    }

    public void shutdown() throws SQLException {

        Statement st = conn.createStatement();

        st.execute("SHUTDOWN");
        conn.close();    // if there are no other open connection
    }

    //use for SQL command SELECT
    public synchronized void query(String expression) throws SQLException {

        Statement st = null;
        ResultSet rs = null;

        st = conn.createStatement();         // statement objects can be reused with

        rs = st.executeQuery(expression);    // run the query

        // do something with the result set.
        dump(rs);
        st.close();    // NOTE!! if you close a statement the associated ResultSet is

    }

    //use for SQL commands CREATE, DROP, INSERT and UPDATE
    public synchronized void update(String expression) throws SQLException {

        Statement st = null;

        st = conn.createStatement();    // statements

        int i = st.executeUpdate(expression);    // run the query

        if (i == -1) {
            System.out.println("db error : " + expression);
        }

        st.close();
    }

    public static void dump(ResultSet rs) throws SQLException {

        // the order of the rows in a cursor
        // are implementation dependent unless you use the SQL ORDER statement
        ResultSetMetaData meta   = rs.getMetaData();
        int               colmax = meta.getColumnCount();
        int               i;
        Object            o = null;

        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // Is SQL the first column is indexed

                // with 1 not 0
                System.out.print(o.toString() + " ");
            }

            System.out.println(" ");
        }
    }

}
