package demo_sync;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fokion on 10/04/17.
 */
public class Worker {
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    private Object lockForStage1 = new Object();
    private Object lockForStage2 = new Object();
    private SecureRandom random = new SecureRandom();

    public void stageOne() {
        synchronized (lockForStage1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            list1.add(random.nextInt(1000000));
        }
    }
    public void stageTwo() {
        synchronized (lockForStage2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            list2.add(random.nextInt(1000000));
        }
    }
    public void process(){
        for(int i = 0 ; i < 1000 ; i++){
            stageOne();
            stageTwo();
        }
    }
    public void init(){
        System.out.println("Starting");
        final long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->process());
        Thread t2 = new Thread(()->process());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final long end =  System.currentTimeMillis();
        System.out.println("It took "+(end -start));
        System.out.println("List 1 : "+list1.size()+" , List 2 "+list2.size());
    }
}
