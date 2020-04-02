package pl.agawesolowska.ticketbookingapp.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.entity.Booking;
import pl.agawesolowska.ticketbookingapp.entity.Customer;
import pl.agawesolowska.ticketbookingapp.entity.Seat;
import pl.agawesolowska.ticketbookingapp.entity.TicketType;
import pl.agawesolowska.ticketbookingapp.repository.BookingRepository;
import pl.agawesolowska.ticketbookingapp.repository.CustomerRepository;
import pl.agawesolowska.ticketbookingapp.repository.SeatRepository;

/**
 * @author Aga Wesołowska
 *
 */
@Service
public class BookingService {

	private final BookingRepository bookingRepository;
	private final CustomerRepository customerRepository;
	private final SeatRepository seatRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, SeatRepository seatRepository) {
		this.bookingRepository = bookingRepository;
		this.customerRepository = customerRepository;
		this.seatRepository = seatRepository;
	}

	@Transactional
	public void addBookingOfOneSeat(Long id, TicketType ticketType, Customer customer) {

		customerRepository.save(customer);

		Seat seat = seatRepository.getOne(id);
		seat.setIsReservedToTrue();
		seat.setTicketType(ticketType);

		Set<Seat> seats = new HashSet<>();
		seats.add(seat);

		Booking booking = new Booking(seats, customer);
		bookingRepository.save(booking);
		
		seat.setBooking(booking);

	}

}
