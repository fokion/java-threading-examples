package demo_thread_pool;

/**
 * Created by fokion on 10/04/17.
 */
public class Processor implements Runnable {
    private int id;
    public Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting Processor "+id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed Processor "+id);
    }
}
