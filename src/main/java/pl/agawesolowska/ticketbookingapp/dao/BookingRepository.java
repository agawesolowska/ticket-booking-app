package pl.agawesolowska.ticketbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.model.entity.Booking;

/**
 * @author Aga Wesołowska
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
