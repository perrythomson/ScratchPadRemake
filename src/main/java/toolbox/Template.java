package toolbox;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Template {

    // variable - access modifier_type_name = value;
    public int a;

    public boolean isCat = true;

    double mark = 22.5;

    String name = "Chaz";

    double chaz() {
        a = 7;
        return a+mark;
    }

    double chaz(int i, double d) {
        double e = i+d;
        return e;
    }

    // method - access modifier_returns_name_receives
    // method - access modifier_result_name_parameter(s)
    public double newby(int firstNumber, int secondNumber) {
        double z = firstNumber+secondNumber+chaz(1,1.1);
        return z;
    }

    public String car() {
        return "Honk";
    }

    public String truck(){
        return "Vroom"+newby(5,6);
    }

    public static void main(String[] args) {
        Template t = new Template();
        System.out.println("chaz() "+t.chaz());
        System.out.println("chaz(int, double) "+t.chaz(3,3.3));
        System.out.println("newby(int, int) "+t.newby(5,9));
        System.out.println("car() "+t.car());
        System.out.println("truck() "+t.truck());
    }


}