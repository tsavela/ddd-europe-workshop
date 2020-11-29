package info.dddeurope.lab.Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.dddeurope.lab.utils.dtos.Event;

public class EventQueue {

    private Map<String, List<Event>> store = new HashMap<>();

    public void addEvent(String id, Event event) {
        List<Event> events = store.get(id);
        if (events == null) {
            events = new ArrayList<Event>();
            events.add(event);
            store.put(id, events);
        } else {
            events.add(event);
        }
    }

    public List<Event> getEvents(String id) {
        return store.get(id);
    }

}