package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.models.Event;
import java.models.EventType;
import java.util.ArrayList;

/**
 * @author Firas.Alhawari
 */
@Named(value = "eventsBean")
@SessionScoped
public class EventsBean implements Serializable {
    private ArrayList<Event> events;
    private ArrayList<EventType> eventTypes;

    public EventsBean() {
        eventTypes = new ArrayList<>();
        events = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    eventTypes.add(new EventType(i, "Match", "مباراة"));
                    break;
                case 2:
                    eventTypes.add(new EventType(i, "Wedding", "عرس"));
                    break;
                case 3:
                    eventTypes.add(new EventType(i, "Other", "غير ذلك"));
                    break;
            }
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(ArrayList<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }
}