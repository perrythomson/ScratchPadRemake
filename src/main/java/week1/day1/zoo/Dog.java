package week1.day1.zoo;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Dog extends Mammal {

    public Dog() {
        this.name = "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}