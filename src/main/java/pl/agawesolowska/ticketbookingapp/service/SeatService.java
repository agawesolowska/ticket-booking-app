package pl.agawesolowska.ticketbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.SeatRepository;
import pl.agawesolowska.ticketbookingapp.model.TicketType;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
 * Service layer that allows booking seats.
 * 
 * @author Aga Wesołowska
 *
 */
@Service
public class SeatService {

	private final SeatRepository seatRepository;

	@Autowired
	public SeatService(SeatRepository seatRepository) {
		this.seatRepository = seatRepository;
	}

	@Transactional
	public Seat getSeatById(Long id) {
		return seatRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("The seat ID is invalid."));
	}

	@Transactional
	public boolean checkWhetherSeatIsAvailable(Seat seat) {
		if (seat.isReserved()) {
			throw new IllegalArgumentException("Seat already reserved.");
		} else {
			return true;
		}
	}

	@Transactional
	public void setPriceForTicket(Seat seat, TicketType ticketType) {
		seat.setTicketType(ticketType);
	}

	@Transactional
	public Seat reserveSeat(Booking booking, Seat seat) {
		seat.setIsReservedToTrue();
		seat.setBooking(booking);
		return seat;
	}

}
