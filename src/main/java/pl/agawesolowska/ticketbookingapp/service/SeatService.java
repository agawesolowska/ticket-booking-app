package pl.agawesolowska.ticketbookingapp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.SeatRepository;
import pl.agawesolowska.ticketbookingapp.model.TicketType;
import pl.agawesolowska.ticketbookingapp.model.entity.Booking;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
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
		Optional<Seat> optionalSeat = seatRepository.findById(id);
		if (optionalSeat.isEmpty()) {
			throw new IllegalArgumentException("The seat ID is invalid.");
		} else {
			return optionalSeat.get();
		}
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
