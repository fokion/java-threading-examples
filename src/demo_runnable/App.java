package demo_runnable;

/**
 * Created by fokion on 10/04/17.
 */
public class App {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        t1.start();
        t2.start();
    }
}
