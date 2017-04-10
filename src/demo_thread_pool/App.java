package demo_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by fokion on 10/04/17.
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(int i = 0 ; i < 50 ;i++) {
            executor.submit(new Processor(i));
        }
        //waits all the threads and terminates...
        executor.shutdown();
        System.out.println("All tasks submitted");
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong and it did not finish in 1 minute...");
        }
        System.out.println("All tasks completed...");
    }
}
