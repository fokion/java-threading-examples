package demo_blocking_queues;

import java.security.SecureRandom;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by fokion on 11/04/17.
 */
public class Producer implements Runnable {
    private BlockingQueue queue;
    private CountDownLatch latch;
    public Producer(BlockingQueue queue, CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
    }
    @Override
    public void run() {
        SecureRandom random = new SecureRandom();
        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            if (((queue.size() + 1) < queue.remainingCapacity())) {
                try {
                    System.out.println("Producing...");
                    queue.put(new Item(random.nextInt(1000)));
                    Thread.sleep(random.nextInt(100)*random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
