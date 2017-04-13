package demo_event_bus;

import demo_event_bus.events.EventBus;

import java.security.SecureRandom;

/**
 * Created by fokion on 13/04/17.
 */
public class ThreadedProducerService implements Runnable {
    private EventBus<AppEventListener> broker;
    private static SecureRandom randomNumber = new SecureRandom();
    public ThreadedProducerService(EventBus<AppEventListener> eventBroker) {
        broker = eventBroker;
    }

    @Override
    public void run() {
        while(true){
            final int id = randomNumber.nextInt(1000);
            System.out.println("Producing... "+ id);
            broker.publish(APP_TOPIC.NEW_USER,new UserCreatedMessage(id));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
