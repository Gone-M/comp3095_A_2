package ca.gbc.roomservice.service;

import ca.gbc.roomservice.model.Room;
import ca.gbc.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        if (roomRepository.existsById(id)) {
            updatedRoom.setId(id);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
