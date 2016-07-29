package toolbox;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        // Exists only to defeat instantiation.
    }
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    // --- Must Have 3 Things ---
    // 1) Constructor must be private - to defeat instantiation
    // 2) Must have a Private Static instance of itself
    // 3) Must have a Public Static Synchronized getInstance method to control access
}