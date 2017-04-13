package demo_event_bus;

import demo_event_bus.events.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fokion on 12/04/17.
 */
public class App {
    private static EventBus<AppEventListener> eventBroker = new EventBus();
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new ThreadedProducerService(eventBroker));
        for(int i = 0 ; i < 3 ; i++){
            service.submit(new ThreadedService(i,eventBroker));
        }

    }
}
