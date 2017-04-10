package demo_runnable;

/**
 * Created by fokion on 10/04/17.
 */
public class Runner implements Runnable {

    @Override
    public void run() {
        for(int i =0 ; i < 10; i++){
            System.out.println("Hello " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Died...");
            }
        }
    }
}
