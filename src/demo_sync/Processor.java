package demo_sync;

/**
 * Created by fokion on 10/04/17.
 */
public class Processor extends Thread {
    private volatile boolean running = true;
    public synchronized void shutdown(){
        running = false;
    }
    private boolean isRunning(){
        return running;
    }
    @Override
    public void run() {
        while (isRunning()){
            System.out.println("Hello...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Died...");
            }

        }
    }
}
