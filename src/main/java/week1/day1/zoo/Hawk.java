package week1.day1.zoo;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Hawk extends Bird {

    public Hawk() {
        this.name = "Hawk";
    }

    @Override
    public void makeSound() {
        System.out.println("Cawwww!");
    }
}