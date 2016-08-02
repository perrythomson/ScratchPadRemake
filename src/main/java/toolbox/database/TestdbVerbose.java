package toolbox.database;

import java.sql.*;

/**
 * Created by perrythomson on 8/2/16.
 */
public class TestdbVerbose {

    Connection conn;                                                            //our connnection to the db - presist for life of program

                                                                            // we dont want this garbage collected until we are done
    public TestdbVerbose(String db_file_name_prefix) throws Exception {    // note more general exception - TODO testdbverbose is a constructor is automatically run...

                                                                    // Load the HSQL Database Engine JDBC driver (java data base connector)
                                                                    // hsqldb.jar should be in the class path or made part of the current jar
        Class.forName("org.hsqldb.jdbcDriver");                     // what is my language how do I work with you...where the driver is located

                                                                    // connect to the database.   This will load the db files and start the
                                                                    // database if it is not alread running.
                                                                    // db_file_name_prefix is used to open or create files that hold the state
                                                                    // of the db.
                                                                    // It can contain directory names relative to the
                                                                    // current working directory
        conn = DriverManager.getConnection("jdbc:hsqldb:"       //database
                        + db_file_name_prefix,                      // filenames
                        "sa",                                       // username
                        "");                                        // password
    }

    public static void main(String[] args) {

        TestdbVerbose db = null;                            //created a new instance of the class so that we dont have to make everything static

        try {
            db = new TestdbVerbose("db_file");              //instantiating this class
        } catch (Exception ex1) {                           //throws exception here rather than in constructor
            ex1.printStackTrace();                                  // could not start db

            return;                                                 // bye bye
        }

        try {

                                                                    //make an empty table
                                                                    //
                                                                    // by declaring the id column IDENTITY, the db will automatically
                                                                    // generate unique values for new rows- useful for row keys
            db.update(
                    "CREATE TABLE sample_table ( id INTEGER IDENTITY, str_col VARCHAR(256), num_col INTEGER)"); //create a table if it is there...throw exception
        } catch (SQLException ex2) {

                                                                    //ignore
                                                                    //ex2.printStackTrace();  // second time we run program
                                                                    //  should throw execption since table
                                                                    // already there
                                                                    //
                                                                    // this will have no effect on the db
        }

        try {

                                                                        // add some rows - will create duplicates if run more then once
                                                                        // the id column is automatically generated
            db.update(
                    "INSERT INTO sample_table(str_col,num_col) VALUES('Ford', 100)");
            db.update(
                    "INSERT INTO sample_table(str_col,num_col) VALUES('Toyota', 200)");
            db.update(
                    "INSERT INTO sample_table(str_col,num_col) VALUES('Honda', 300)");
            db.update(
                    "INSERT INTO sample_table(str_col,num_col) VALUES('GM', 400)");

            // do a query
            db.query("SELECT * FROM sample_table WHERE num_col < 250");

            // at end of program
            db.shutdown();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
    }

    public void shutdown() throws SQLException {

        Statement st = conn.createStatement();

        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        conn.close();    // if there are no other open connection
    }

    //use for SQL command SELECT
    public synchronized void query(String expression) throws SQLException {

        Statement st = null;
        ResultSet rs = null;

        st = conn.createStatement();         // statement objects can be reused with

        // repeated calls to execute but we
        // choose to make a new one each time
        rs = st.executeQuery(expression);    // run the query

        // do something with the result set.
        dump(rs);
        st.close();    // NOTE!! if you close a statement the associated ResultSet is

        // closed too
        // so you should copy the contents to some other object.
        // the result set is invalidated also  if you recycle an Statement
        // and try to execute some other query before the result set has been
        // completely examined.
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

        // the result set is a cursor into the data.  You can only
        // point to one row at a time
        // assume we are pointing to BEFORE the first row
        // rs.next() points to next row and returns true
        // or false if there is no next row, which breaks the loop
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
