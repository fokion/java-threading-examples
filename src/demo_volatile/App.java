package demo_volatile;


import java.util.Scanner;

/**
 * Created by fokion on 10/04/17.
 */
public class App {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutdown();
    }

}
