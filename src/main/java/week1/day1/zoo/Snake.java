package week1.day1.zoo;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Snake extends Reptile {

    public Snake() {
        this.name = "Snake";
    }

    @Override
    public void makeSound() {
        System.out.println("Sssssssssssss!");
    }
}
