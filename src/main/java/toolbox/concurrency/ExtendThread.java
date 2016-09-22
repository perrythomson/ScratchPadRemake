package toolbox.concurrency;

/**
 * Created by perrythomson on 7/28/16.
 */

public class ExtendThread {
    public static void main(String a[]) {
        System.out.println("Starting other.Main Thread...");
        MySmpThread mst = new MySmpThread();
        mst.start();
        while(MySmpThread.myCount <= 10) {
            try {
                System.out.println("other.Main Thread: "+(++MySmpThread.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of other.Main Thread...");
    }
}

class MySmpThread extends Thread {
    public static int myCount = 0;
    public void run() {
        while(MySmpThread.myCount <= 10) {
            try {
                System.out.println("Expl Thread: "+(++MySmpThread.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    }
}
