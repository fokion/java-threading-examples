package demo_event_bus;

import demo_event_bus.events.AppEventInterface;
import demo_event_bus.events.EventTopic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by fokion on 12/04/17.
 */
public class EventBus<T extends AppEventListener> implements AppEventInterface<T> {
    private final ConcurrentMap<EventTopic,BlockingQueue<T>> listeners = new ConcurrentHashMap<>();

    @Override
    public void subscribe(EventTopic topic, T receiver) {
        if(!listeners.containsKey(topic)){
            listeners.put(topic,new LinkedBlockingQueue<T>());
        }
        BlockingQueue queue = listeners.get(topic);
        if(!queue.contains(receiver)){
            try {
                queue.put(receiver);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listeners.put(topic,queue);
        }
    }

    @Override
    public void publish(EventTopic topic, AppMessage message) {

    }
}
