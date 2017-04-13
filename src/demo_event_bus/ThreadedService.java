package demo_event_bus;

import demo_event_bus.events.EventBus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by fokion on 13/04/17.
 */
public class ThreadedService extends AppEventListener implements Runnable {
    private EventBus<AppEventListener> broker;
    private BlockingQueue<AppMessage> messages = new LinkedBlockingQueue<>();
    private int id;
    public ThreadedService(int id , EventBus<AppEventListener> eventBroker) {
        this.id = id;
        broker = eventBroker;
        broker.subscribe(APP_TOPIC.NEW_USER,this);
    }

    @Override
    public void run() {
        while(true){
            if(messages.size() > 0) {
                processMessage();
            }
        }
    }
    private void processMessage(){
        try {
            System.out.println(id+" processed message... "+messages.take().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleEvent(AppMessage message) {
        try {
            messages.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
