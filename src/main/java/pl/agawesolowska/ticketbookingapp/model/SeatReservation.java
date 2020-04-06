package pl.agawesolowska.ticketbookingapp.model;

import lombok.Getter;
import lombok.Setter;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
 * @author Aga Wesołowska
 *
 */
@Getter @Setter
public class SeatReservation {

	private Seat seat;

	private TicketType ticketType;

}
