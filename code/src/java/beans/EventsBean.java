package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import models.Event;
import models.EventType;

/**
 *
 * @author Firas.Alhawari
 * 
 */
@Named(value = "eventsBean")
@SessionScoped
public class EventsBean implements Serializable {
    private ArrayList<Event> events;
    private Event selectedEvent;
//    private ArrayList<EventType> eventTypes;

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }
    
    @Inject private SessionBean sessionBean;
    
    public EventsBean() {
//        eventTypes = new ArrayList<>();
//        events = new ArrayList<>();
//        
//        for(int i = 1; i <= 3; i++){
//            switch(i){
//                case 1: eventTypes.add(new EventType(i, "Match", "مباراة"));
//                    break;
//                case 2: eventTypes.add(new EventType(i, "Wedding", "عرس"));
//                    break;
//                case 3: eventTypes.add(new EventType(i, "Other", "غير ذلك"));
//                    break;
//            }
//        }  
    }   
    
    @PostConstruct
    public void init(){
        events = new ArrayList<>();
        events.add(new Event(1,"Soccer Match","مباراة كرة قدم",3000,new Date()));
        events.add(new Event(2,"Wedding","عرس",200,new Date()));
           events.add(new Event(3,"Soccer Match","مباراة كرة قدم",3000,new Date()));
        events.add(new Event(4,"Wedding","عرس",200,new Date()));

    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    } 
    
//    public String viewEvent(){
//        sessionBean.
//    }

//    public ArrayList<EventType> getEventTypes() {
//        return eventTypes;
//    }

//    public void setEventTypes(ArrayList<EventType> eventTypes) {
//        this.eventTypes = eventTypes;
//    }        
}