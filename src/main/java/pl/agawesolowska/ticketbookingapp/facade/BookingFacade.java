package pl.agawesolowska.ticketbookingapp.facade;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.agawesolowska.ticketbookingapp.model.TicketType;
import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;
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

		for (Map.Entry<Seat, TicketType> entry : bookingRequestDTO.getTickets().entrySet()) {
			Seat seatToReserve = entry.getKey();
			TicketType ticketToReserve = entry.getValue();
			seatService.reserveSeat(seatToReserve.getId(), ticketToReserve);
		}

		bookingService.saveBooking(bookingRequestDTO.getTickets().keySet(), bookingRequestDTO.getCustomer());

		customerService.saveCustomer(bookingRequestDTO.getCustomer());

	}

	// TODO methods of total amount to pay and reservation expiration time

	// TODO zapisać booking do miejsca !!!
}
