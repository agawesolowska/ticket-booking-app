package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Booking;

/**
 * @author Aga Wesołowska
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
