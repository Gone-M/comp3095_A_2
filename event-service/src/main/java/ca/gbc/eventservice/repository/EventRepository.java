package ca.gbc.eventservice.repository;

import ca.gbc.eventservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByRoomId(String roomId);
    List<Event> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
