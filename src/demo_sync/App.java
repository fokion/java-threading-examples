package demo_sync;


import demo_volatile.Processor;

import java.util.Scanner;

/**
 * Created by fokion on 10/04/17.
 */
public class App {
    private int count = 0;

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public synchronized void incrementValue() {
        count++;
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 40000; i++) {
                incrementValue();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 40000; i++) {
                incrementValue();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count is " + count);
    }

}
