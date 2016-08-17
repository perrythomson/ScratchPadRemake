package toolbox.collection;


import java.util.ArrayList;

/**
 * Created by perrythomson on 7/28/16.
 */
public class ArrayListExample {


    // Create a new ArrayList named names that holds Strings
    ArrayList<String> names = new ArrayList<>();

    public static void main(String[] args) {
        ArrayListExample arrayListExample = new ArrayListExample();
        arrayListExample.addElement("Bob");
        arrayListExample.addElement("Sally");
        arrayListExample.addElement("Tom");
        arrayListExample.addElement("Jill");
        arrayListExample.addElement("Twinkle Toes");
        System.out.println("Element at 4: "+arrayListExample.getElement(4));
        System.out.println("---------------------------");
        arrayListExample.printAllElements();

    }

    // add another String to the ArrayList
    public void addElement(String name) {
        names.add(name);
    }

    // get a String from the ArrayList at a specific index
    public String getElement(int index) {
        return names.get(index);
    }

    // print out all the Strings in the ArrayList
    public void printAllElements() {

//        System.out.println(names);

        for(String name : names) {
            System.out.println(name);
        }
    }
}
