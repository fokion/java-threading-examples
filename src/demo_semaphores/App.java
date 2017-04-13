package demo_semaphores;

import java.util.concurrent.Semaphore;

/**
 * Created by fokion on 13/04/17.
 */
public class App {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(1);
        System.out.println("Available permits "+semaphore.availablePermits());
        try {
            //will wait if we dont have any permits...
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //acts as a lock...
        //semaphore.release();
        System.out.println("Available permits "+semaphore.availablePermits());
    }
}
