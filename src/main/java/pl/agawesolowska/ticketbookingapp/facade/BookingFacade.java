package pl.agawesolowska.ticketbookingapp.facade;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.agawesolowska.ticketbookingapp.model.SeatReservation;
import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;
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

	public void seatReservation(@Valid BookingRequestDTO bookingRequestDTO) {

		Set<Seat> seats = new HashSet<>();

		Set<SeatReservation> seatReservations = bookingRequestDTO.getTickets();

		for (SeatReservation reservation : seatReservations) {
			Seat seatToReserve = reservation.getSeat();
			seatService.reserveSeat(seatToReserve.getId(), reservation.getTicketType());
			seats.add(seatToReserve);
		}

		Customer customer = bookingRequestDTO.getCustomer();
		customerService.saveCustomer(customer);

		bookingService.saveBooking(seats, customer);

	}

	// TODO methods of total amount to pay and reservation expiration time

	// TODO zapisać booking do miejsca !!!
}
