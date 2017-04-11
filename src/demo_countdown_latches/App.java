package demo_countdown_latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fokion on 11/04/17.
 */
public class App {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService service = Executors.newFixedThreadPool(4);
        for(int i = 0 ; i < 4 ; i++) {
         service.submit(new Process(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed...");
    }
}
