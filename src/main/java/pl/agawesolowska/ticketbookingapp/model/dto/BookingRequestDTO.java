package pl.agawesolowska.ticketbookingapp.model.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import pl.agawesolowska.ticketbookingapp.model.TicketType;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
 * @author Aga Wesołowska
 *
 */
@Getter @Setter
public class BookingRequestDTO {

	@NotNull
	private Map<Seat, TicketType> tickets;

	@NotNull
	private Customer customer;

}
