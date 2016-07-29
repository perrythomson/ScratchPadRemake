package week1.day1.people;

/**
 * Created by perrythomson on 7/28/16.
 */
public abstract class Person {
    private String name = "Bob";
    private int age = 15 / 25 * 32;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSame(int newAge) {
        if(((this.age > newAge) || this.age < 100) && this.age == 50) {
            return true;
        } else {
            return false;
        }
    }
}