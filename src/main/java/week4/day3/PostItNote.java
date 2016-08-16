//package week4.day3;
//
//import java.sql.*;
//import java.util.Scanner;
//
///**
// * Created by perrythomson on 8/4/16.
// */
//public class PostItNote {
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        public static void main(String[] args) {
//            week4.day3.PostItNoteContent pinc = new week4.day3.PostItNoteContent();  //same as rick
//            pinc.dropPostIt_details();
//            pinc.dropPostIt_format();
//
//            pinc.checkDataTables();
//            try {
//                pinc.readAllNotes(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            pinc.checkFormatTables();
//            try {
//                pinc.readAllForms(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("This is where you can design a sticky note, add content or view categories.");
//            System.out.println("What would you like to do?  [Design/Add]");
//
//            String employeeInput = scanner.nextLine();
//
//
//
//            if (employeeInput.equalsIgnoreCase("Design")) {
//                System.out.println("What is your PostIt Title?");
//                String postItTitle = scanner.nextLine();
//                System.out.println("What is the Memo?");
//                String postItMemo = scanner.nextLine();
//                System.out.println("Choose your format (int)");//todo need to identify XXXX to join
//                String postItFormatNum = scanner.nextLine();
//
//                pinc.insertDetailRecord(postItTitle, postItMemo, postItFormatNum);  //todo need to identify XXXX to join
////            PostItNoteContent.insertDetailRecord(String postItTitle, String postItMemo, String refFD, String signinDate);
//            }
//
//            if (employeeInput.equalsIgnoreCase("Add"))
//                System.out.println("What is your PostIt Name?");
//            String postItName = scanner.nextLine();
//            System.out.println("What color?");
//            String postItColor = scanner.nextLine();
//            System.out.println("What is the Description (int)");
//            String postItFormatNum = scanner.nextLine();
//
//            pinc.insertFormRecord(postItName, postItColor, postItFormatNum);
//
////        if (employeeInput.equalsIgnoreCase("View"))
////            System.out.println("Which category (A/B/C/D/New");
////
////            if ()
////            String postItName = scanner.nextLine();
////            System.out.println("What is your PostIt Name?");
////            String postItName = scanner.nextLine();
////            System.out.println("What color?");
////            String postItColor = scanner.nextLine();
////            System.out.println("What is the Description");
////            String postItDesc = scanner.nextLine();
////
////            Date d = new Date(System.currentTimeMillis());
////            pinc.insertRecord(postItName, postItColor,postItDesc, d.toString());
//
//        }
//
//        private void dropPostIt_details() {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPIND", "AA", "");  //todo db and username?
//                Statement stmt = conn.createStatement();
//                stmt.executeUpdate("DROP TABLE postPIND;");
//                stmt.close();
//                conn.close();
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        private void dropPostIt_format() {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPINF", "AB", "");  //todo db and username?
//                Statement stmt = conn.createStatement();
//                stmt.executeUpdate("DROP TABLE postPINF;");
//                stmt.close();
//                conn.close();
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        private void createDataTables() {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPIND","AA","");  //todo db and username?
//                Statement stmt = conn.createStatement();
//                stmt.executeUpdate("CREATE TABLE postIt_details (id INTEGER IDENTITY, postItTitle VARCHAR(256), postItMemo VARCHAR(256), postItFormatNum VARCHAR (256))");
//
//                stmt.close();
//                conn.close();
//            } catch(Exception e) {
//                System.out.println("Table Already Exists");
//            }
//        }
//
//        private void checkDataTables() {
//            try {
//                readAllNotes(false);
//            } catch (Exception e) {
//                createDataTables();
//            }
//        }
//
//
//        private void createFormatTables() {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPINF","AB","");  //todo db and username?
//                Statement stmt = conn.createStatement();
//                stmt.executeUpdate("CREATE TABLE postIt_format ( id INTEGER IDENTITY, postItName VARCHAR(256), postItColor VARCHAR(256), postItFormatNum VARCHAR(256))");
//
//                stmt.close();
//                conn.close();
//            } catch(Exception e) {
//                System.out.println("Table Already Exists");
//            }
//        }
//
//        private void checkFormatTables() {
//            try {
//                readAllForms(false);
//            } catch (Exception e) {
//                createFormatTables();
//            }
//        }
//
//        private void insertDetailRecord(String postItTitle, String postItMemo, String postItFormatNum) { //todo need to identify XXXX to join
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPIND","AA","");
//                PreparedStatement stmt = conn.prepareStatement("INSERT INTO postIt_details (postItTitle, postItMemo, postItFormatNum) VALUES (?,?,?);");
//                stmt.setString(1, postItTitle);
//                stmt.setString(2, postItMemo);
//                stmt.setString(3, postItFormatNum);//todo need to identify XXXX to join
//                stmt.executeUpdate();
//
//                stmt.close();
//                conn.close();
//                System.out.println("NOTE: Finished Update");
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        private void insertFormRecord(String postItName, String postItColor, String postItFormatNum) {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPINF","AB","");
//                PreparedStatement stmt = conn.prepareStatement("INSERT INTO postIt_format (postItName, postItColor, postItFormatNum) VALUES (?,?,?);");
//                stmt.setString(1, postItName);
//                stmt.setString(2, postItColor);
//                stmt.setString(3, postItFormatNum);
//                stmt.executeUpdate();
//
//                stmt.close();
//                conn.close();
//                System.out.println("NOTE: Finished Update");
//            } catch(Exception e) {
//                e.printStackTrace();  //its dropping a table that doesnt exist //instead use system.out.println(no table to drop)
//            }
//        }
//        // this section is for the data on the post-it if I can do it on one page...cant because different main
//
//        private void readAllNotes(boolean printMe) throws Exception {
//            Class.forName("org.hsqldb.jdbcDriver");
//            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPIND","AA","");
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT id, postItTitle, postItMemo, postItFormatNum  FROM postIt_details");
//            while(rs.next()) {
//                String rowResults = rs.getInt("id")+" -- "+rs.getString("postItTitle")+" -- "+rs.getString("postItMemo")+" -- "+rs.getString("postItFormatNum");
//                if(printMe) {
//                    System.out.println(rowResults);
//                }
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        }
//
//
//        private void readAllForms(boolean printMe) throws Exception {
//            Class.forName("org.hsqldb.jdbcDriver");
//            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postPINF","AB","");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT id, postItName, postItColor, postItFormatNum FROM postIt_format");
//            while(rs.next()) {
//                String rowResults = rs.getInt("id")+" -- "+rs.getString("postItName")+" -- "+rs.getString("postItColor")+" -- "+rs.getString("postItFormatNum");
//                if(printMe) {
//                    System.out.println(rowResults);
//                }
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        }
//        private void joinTable() {
//            try {
//                Class.forName("org.hsqldb.jdbcDriver");
//                Connection conn = DriverManager.getConnection("jdbc:hsqldb:postDB","sa","");
//                Statement stmt = conn.createStatement();
//
//                stmt.executeUpdate("SELECT postIt_details.refFD, postIt_format.postItDesc " +
//                        "               FROM postIt_details JOIN postIt_format " +
//                        "               ON postIt_details.refFD = postIt_format.DESC )");
//
//                stmt.close();
//                conn.close();
//            } catch(Exception e) {
//                System.out.println("Table Already Exists");
//            }
//        }
//
//
////
////
////
////
////    public String getPostItTitle() {
////        return postItTitle;
////    }
////
////    public void setPostItTitle(String postItTitle) {
////        this.postItTitle = postItTitle;
////    }
////
////    public String getPostItMemo() {
////        return postItMemo;
////    }
////
////    public void setPostItMemo(String postItMemo) {
////        this.postItMemo = postItMemo;
////    }
////
////    public String getRefFD() {
////        return refFD;
////    }
////
////    public void setRefFD(String refFD) {
////        this.refFD = refFD;
////    }
////
////    public String getPostItName() {
////        return postItName;
////    }
////
////    public void setPostItName(String postItName) {
////        this.postItName = postItName;
////    }
////
////    public String getPostItColor() {
////        return postItColor;
////    }
////
////    public void setPostItColor(String postItColor) {
////        this.postItColor = postItColor;
////    }
////
////    public String getPostItDesc() {
////        return postItDesc;
////    }
////
////    public void setPostItDesc(String postItDesc) {
////        this.postItDesc = postItDesc;
////    }
////
////    private String postItTitle;
////    private String postItMemo;
////    private String refFD;
////    private String postItName;
////    private String postItColor;
////    private String postItDesc;
//    }
//
//}
