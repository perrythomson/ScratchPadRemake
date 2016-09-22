package toolbox.concurrency;

/**
 * Created by perrythomson on 7/28/16.
 */
public class ImplementRunnable {
    public static void main(String a[]) {
        System.out.println("Starting other.Main Thread...");
        MyRunnableThread mrt = new MyRunnableThread();
        Thread t = new Thread(mrt);
        t.start();
        while(MyRunnableThread.myCount <= 10) {
            try {
                System.out.println("other.Main Thread: "+(++MyRunnableThread.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of other.Main Thread...");
    }
}

class MyRunnableThread implements Runnable {  //inner class declared inside a file named something different...
                                              // becomes a class is only visable/access to that class
                                              //this is a child thread which has to be accessed through parent

    public static int myCount = 0;
    public MyRunnableThread() { }

    public void run() {
        while(MyRunnableThread.myCount <= 10){
            try{
                System.out.println("Expl Thread: "+(++MyRunnableThread.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    }
}