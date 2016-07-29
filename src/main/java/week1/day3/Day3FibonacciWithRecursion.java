package week1.day3;

/**
 * Created by perrythomson on 7/28/16.
 */
public class Day3FibonacciWithRecursion {

    int n1=0, n2=1, n3=0;

    public static void main(String args[]){
        Day3FibonacciWithRecursion d3f = new Day3FibonacciWithRecursion();
        int count=10;
        System.out.print(d3f.n1+" "+d3f.n2);//printing 0 and 1
        d3f.printFibonacci(count-2);//n-2 because 2 numbers are already printed
    }

    void printFibonacci(int count){
        if(count>0){
            // Start by setting n3, n2, and n1
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            // print out a space and n3
            System.out.print(" "+n3);
            // use recursion and pass in the new count
            printFibonacci(count-1);
        }
    }
}
