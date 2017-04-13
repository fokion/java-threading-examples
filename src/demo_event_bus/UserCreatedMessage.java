package demo_event_bus;

/**
 * Created by fokion on 13/04/17.
 */
public class UserCreatedMessage extends AppMessage {
    private int id;
    public UserCreatedMessage(int i) {
        super();
        id = i;
    }
    public String toString(){
        return String.valueOf(this.id);
    }
}
