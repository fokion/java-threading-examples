package demo_wait_and_notify;

import java.util.Scanner;

/**
 * Created by root on 12/04/17.
 */
public class Processor  {
    private Scanner scanner = new Scanner(System.in);
    private volatile String value;
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread is running");
            //wait gives back control of the lock.
            wait();
            System.out.println("Producer thread resumed");
            System.out.println("You have typed : "+value);
        }
    }
    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for the return key");
            value = scanner.nextLine();
            notify();
        }
    }
}
