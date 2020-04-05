package pl.agawesolowska.ticketbookingapp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.SeatRepository;
import pl.agawesolowska.ticketbookingapp.model.TicketType;
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
	public Seat reserveSeat(Long id, TicketType ticketType) {

		Optional<Seat> optionalSeat = seatRepository.findById(id);
		if (optionalSeat.isEmpty()) {
			throw new IllegalArgumentException("The ID value is invalid.");
		} else {
			Seat seat = optionalSeat.get();
			seat.setIsReservedToTrue();
			seat.setTicketType(ticketType);
			return seat;
		}

	}

}
