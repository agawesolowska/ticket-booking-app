package pl.agawesolowska.ticketbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.model.entity.Room;

/**
 * @author Aga Wesołowska
 *
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

}
