package demo_blocking_queues;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by fokion on 11/04/17.
 */
public class Consumer implements Runnable {
    private BlockingQueue<Item> queue;
    private List<Item> innerQueue= new ArrayList<>();
    private CountDownLatch latch;
    private  int id;
    public Consumer(int id , BlockingQueue queue, CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
        this.id = id;
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
        while(true) {
            try {
                Thread.sleep(random.nextInt(100)*random.nextInt(40));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                innerQueue.add(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.id + " did :" + innerQueue.size());
        }
    }
}
