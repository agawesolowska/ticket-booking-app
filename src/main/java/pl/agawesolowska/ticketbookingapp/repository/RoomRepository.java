package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Room;

/**
 * @author Aga Wesołowska
 *
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

}
