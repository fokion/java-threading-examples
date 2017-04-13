package demo_countdown_latches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fokion on 11/04/17.
 */
public class Process implements Runnable {
    private CountDownLatch latch;
    public  Process(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Started...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("Latch is : "+latch.getCount());

    }
}
