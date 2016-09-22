package week4.day3.anotherPostItNote;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by perrythomson on 9/1/16.
 */
public class postItMemo {
    private static String noteCategory;
    private static String categoryColor;
    private static String categoryDescription;
    private static String noteTitle;
    private static String noteContent;

    public static void main(String[] args) {
        userPrompt();

    }

    private static void userPrompt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sticky Notes Database!!! \nAccess options: \n" +
                "Build Database for the first time: [BUILD] \n" +
                "Create new category: [CREATE] \n"+
                "Add new post it note: [NEW] \n" +
                "View current note categories: [VIEW]  \n" +
                "Quit Post it notes: [QUIT]");

        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("build")) {
            createPostItNotesDb();
            System.out.println("Your Post it note database has been generated!");
            userPrompt();
        }
        if (userInput.equalsIgnoreCase("create")) {
            System.out.println("Generate category name:");
            noteCategory = scanner.nextLine();
            System.out.println("Assign category a color:");
            categoryColor = scanner.nextLine();
            System.out.println("Add a brief description:");
            categoryDescription = scanner.nextLine();
            generateCategory(noteCategory, categoryColor, categoryDescription);
            userPrompt();

        }
        if (userInput.equalsIgnoreCase("new")) {
            System.out.println("Category?");
            noteCategory = scanner.nextLine();
            System.out.println("Title?");
            noteTitle = scanner.nextLine();
            System.out.println("Input your note: (limit 300 characters)");
            noteContent = scanner.nextLine();
            postItSaver(noteCategory, noteTitle, noteContent);
            userPrompt();

        }
        if (userInput.equalsIgnoreCase("view")) {
            viewCategories();
            System.out.println("Select a category: ");
            noteCategory = scanner.nextLine();
            viewNotesByCategory(noteCategory);
            userPrompt();

        }
        if (userInput.equalsIgnoreCase("quit")){
            System.out.println("Session complete");

        }

    }

    private static void postItSaver(String noteCategory, String noteTitle, String noteContent) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:notesDb", "admin", "");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO note_table(noteCategory, noteTitle, noteContent) VALUES (?,?,?);");
            stmt.setString(1, noteCategory);
            stmt.setString(2, noteTitle);
            stmt.setString(3, noteContent);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("NOTE SAVED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateCategory(String noteCategory,String categoryColor,String categoryDescription){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:notesDb", "admin", "");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO category_table (noteCategory, categoryColor, categoryDescription) VALUES (?,?,?);");
            stmt.setString(1, noteCategory);
            stmt.setString(2, categoryColor);
            stmt.setString(3, categoryDescription);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPostItNotesDb() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:notesDb", "admin", "");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE category_table ( id INTEGER IDENTITY, noteCategory VARCHAR(30), categoryColor VARCHAR(20),categoryDescription VARCHAR(40))");
            stmt.executeUpdate("CREATE TABLE note_table ( id INTEGER IDENTITY, noteCategory VARCHAR(30), noteTitle VARCHAR(20),noteContent VARCHAR(300))");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database Tables Already Exist");
        }

    }

    private static void viewCategories() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:notesDb", "admin", "");
            PreparedStatement stmt = conn.prepareCall("SELECT noteCategory FROM category_table ORDER BY id");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                noteCategory = rs.getString("noteCategory");
                String resultString = "Category: " + noteCategory;
                System.out.println(resultString);
                stmt.close();
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewNotesByCategory(String selection) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:notesDb", "admin", "");
            PreparedStatement stmt = conn.prepareCall("SELECT note_table.noteCategory, category_table.categoryColor, " +
                    "category_table.categoryDescription, note_table.noteTitle, note_table.noteContent"  +
                    " FROM category_table  FULL OUTER JOIN note_table " +
                    "ON category_table.noteCategory = note_table.noteCategory " +
                    "WHERE noteCategory = ? ORDER BY note_table.noteTitle");
            stmt.setString(1, selection);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String noteCategory = rs.getString("note_table.noteCategory");
                String categoryColor = rs.getString("category_table.categoryColor");
                String categoryDescription = rs.getString("category_table.categoryDescription");
                String noteTitle = rs.getString("note_table.noteTitle");
                String noteContent = rs.getString("note_table.noteContent");
                System.out.println(noteCategory + "||" + categoryColor+"||"+categoryDescription+"||"+noteTitle + "||" + noteContent);
            }
            System.out.println();
            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
