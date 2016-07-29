package week1.day1.people;

/**
 * Created by perrythomson on 7/28/16.
 */
public final class Student extends Person {
    private double gpa;

    public Student() {
        gpa = 4.0;
        setName("Bob");
        setGender("Male");
        setAge(12);
    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
