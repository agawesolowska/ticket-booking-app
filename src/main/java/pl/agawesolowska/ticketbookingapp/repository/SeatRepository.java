package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Seat;

/**
 * @author Aga Wesołowska
 *
 */
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
