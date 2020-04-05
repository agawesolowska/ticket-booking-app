package pl.agawesolowska.ticketbookingapp.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.BookingRepository;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
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
	public Booking saveBooking(Set<Seat> seats, Customer customer) {

		Booking booking = new Booking(seats, customer);
		return bookingRepository.save(booking);

	}

}
