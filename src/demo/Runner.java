package demo;

/**
 * Created by fokion on 10/04/17.
 */
public class Runner extends Thread {
    private String name;
    Runner(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for(int i =0 ; i < 10; i++){
            System.out.println("Hello from "+name+" "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Died..." + name);
            }
        }
        super.run();
    }
}
