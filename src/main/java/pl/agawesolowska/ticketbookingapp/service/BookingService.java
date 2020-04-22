package pl.agawesolowska.ticketbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.BookingRepository;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;

/**
 * Service layer that allows saving reservations.
 * 
 * @author Aga Wesołowska
 *
 */
@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Transactional
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

}
