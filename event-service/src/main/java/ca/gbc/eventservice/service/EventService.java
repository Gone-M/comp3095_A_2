package ca.gbc.eventservice.service;

import ca.gbc.eventservice.model.Event;
import ca.gbc.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(String id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByRoom(String roomId) {
        return eventRepository.findByRoomId(roomId);
    }

    public List<Event> getEventsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findByStartTimeBetween(start, end);
    }
}
