package demo_event_bus.events;

import demo_event_bus.AppMessage;


/**
 * Created by fokion on 12/04/17.
 */
public interface AppEventInterface<T extends EventReceiver> {
    void subscribe(EventTopic topic , T receiver);
    void publish(EventTopic topic , AppMessage message);
}
