package demo_blocking_queues;

import java.util.concurrent.*;

/**
 * Created by fokion on 11/04/17.
 */
public class App {
    private static BlockingQueue<Item> queue = new ArrayBlockingQueue<>(100);

    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Producer(queue, latch));
        service.submit(new Consumer(1, queue, latch));
        service.submit(new Consumer(2, queue, latch));

        Thread t1 = new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(true) {
                try {
                    Thread.sleep(200);
                    System.out.println("QUEUE is " + queue.size()+ " items");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
