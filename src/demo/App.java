package demo;

/**
 * Created by fokion on 10/04/17.
 */
public class App {
    public static void main(String[] args){
        Runner runner1 = new Runner("Tester");
        Runner runner2 = new Runner("Tester2");
        Runner runner3 = new Runner("Tester3");
        runner1.start();
        runner2.start();
        runner3.start();
    }
}
