package beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.daos.EventTypesDao;
import java.daos.EventsDao;
import java.io.Serializable;
import java.models.Event;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Firas.Alhawari
 */
@Named(value = "manageEventsBean")
@ViewScoped
public class ManageEventsBean implements Serializable {
    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private Event selectedEvent;
    private ArrayList<Event> events;

    @Inject
    private beans.SessionBean sessionBean;

    public ManageEventsBean() {
    }

    @PostConstruct
    public void init() {
        try {
            events = eventsDao.buildEvents(eventTypesDao.buildEventTypesMap());
        } catch (Exception ex) {
            Logger.getLogger(ManageEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void searchEvents() {
    }

    public void saveSelectedItemId() {
        sessionBean.setSelectedItemId(selectedEvent.getEventId());
    }

    public void deleteSelectedEvent() {
        try {
            eventsDao.deleteEvent(selectedEvent.getEventId());
        } catch (Exception ex) {
            Logger.getLogger(ManageEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
