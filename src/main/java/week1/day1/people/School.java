package week1.day1.people;

/**
 * Created by perrythomson on 7/28/16.
 */
public class School {

    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("Phill");
        t.setAge(99);
        t.setGender("Male");
        t.setSalary(42000.65);
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getGender());
        System.out.println(t.getSalary());



        Teacher t2 = new Teacher();
        t2.setName("Jenny");
        t2.setAge(22);
        t2.setGender("Female");
        t2.setSalary(49000.98);
        System.out.println(t2.getName());
        System.out.println(t2.getAge());
        System.out.println(t2.getGender());
        System.out.println(t2.getSalary());


        Student s = new Student();
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getGender());
        System.out.println(s.getGpa());

//        Parent p = new Parent();
//        System.out.println(p.getHasStudent());

        Parent.getHasStudent();

    }
}
