package pl.agawesolowska.ticketbookingapp.facade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;
import pl.agawesolowska.ticketbookingapp.model.entity.Screening;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;
import pl.agawesolowska.ticketbookingapp.service.BookingService;
import pl.agawesolowska.ticketbookingapp.service.CustomerService;
import pl.agawesolowska.ticketbookingapp.service.ScreeningService;
import pl.agawesolowska.ticketbookingapp.service.SeatService;
import pl.agawesolowska.ticketbookingapp.util.DateTimeUtils;
import pl.agawesolowska.ticketbookingapp.util.SeatReservationUtils;

/**
 * @author Aga Wesołowska
 *
 */
@Component
public class BookingFacade {

	private final BookingService bookingService;
	private final CustomerService customerService;
	private final ScreeningService screeningService;
	private final SeatService seatService;

	@Autowired
	public BookingFacade(BookingService bookingService, CustomerService customerService,
			ScreeningService screeningService, SeatService seatService) {
		this.bookingService = bookingService;
		this.customerService = customerService;
		this.screeningService = screeningService;
		this.seatService = seatService;
	}

	public void addCustomerBooking(BookingRequestDTO bookingRequestDTO) {

		Screening screening = screeningService.getScreeningById(bookingRequestDTO.getScreening().getId());
		screeningService.checkWhetherReservationIsPossible(screening);

		SeatReservationUtils.checkWhetherSeatsAreNextToEachOther(bookingRequestDTO.getSeatReservations());

		Set<Seat> seatsToBooking = new HashSet<>();
		for (Seat seatReservation : bookingRequestDTO.getSeatReservations()) {
			Seat seat = seatService.getSeatById(seatReservation.getId());
			seatService.checkWhetherSeatIsAvailable(seat);
			seatService.setPriceForTicket(seat, seatReservation.getTicketType());
			seatsToBooking.add(seat);
		}

		Customer customer = bookingRequestDTO.getCustomer();
		customerService.saveCustomer(customer);
		Booking booking = new Booking(seatsToBooking, customer);
		bookingService.saveBooking(booking);

		BigDecimal totalCost = BigDecimal.ZERO;
		for (Seat seat : seatsToBooking) {
			seatService.reserveSeat(booking, seat);
			BigDecimal ticketPrice = seat.getTicketType().getPrice();
			totalCost = totalCost.add(ticketPrice);
			if (DateTimeUtils.isWeekend(screening.getScreeningDateTime())) {
				totalCost = totalCost.add(BigDecimal.valueOf(4.0));
			}
		}
		if (customer.getVoucher() != null) {
			totalCost = totalCost.multiply(BigDecimal.valueOf(0.5));
		}

		System.out.println(totalCost);
		System.out.println(screening.getScreeningExpirationDateTime());

	}

}
