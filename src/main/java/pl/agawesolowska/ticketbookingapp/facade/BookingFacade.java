package pl.agawesolowska.ticketbookingapp.facade;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;
import pl.agawesolowska.ticketbookingapp.service.BookingService;
import pl.agawesolowska.ticketbookingapp.service.CustomerService;
import pl.agawesolowska.ticketbookingapp.service.SeatService;

/**
 * @author Aga Wesołowska
 *
 */
@Component
public class BookingFacade {

	private final BookingService bookingService;
	private final CustomerService customerService;
	private final SeatService seatService;

	@Autowired
	public BookingFacade(BookingService bookingService, CustomerService customerService, SeatService seatService) {
		this.bookingService = bookingService;
		this.customerService = customerService;
		this.seatService = seatService;
	}

	public void seatReservation(BookingRequestDTO bookingRequestDTO) {

		Set<Seat> seatReservations = bookingRequestDTO.getSeatReservations();

		for (Seat seatReservation : seatReservations) {
			seatService.reserveSeat(seatReservation.getId(), seatReservation.getTicketType());
		}

		Customer customer = bookingRequestDTO.getCustomer();
		customerService.saveCustomer(customer);

		Booking booking = new Booking(seatReservations, customer);
		bookingService.saveBooking(booking);

		seatService.saveReservation(seatReservations, booking);
		
	}

	// TODO methods of total amount to pay and reservation expiration time

}
