package pl.agawesolowska.ticketbookingapp.model.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;
import pl.agawesolowska.ticketbookingapp.model.entity.Screening;
import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
 * @author Aga Wesołowska
 *
 */
@Getter @Setter
public class BookingRequestDTO {
	
	@NotNull
	private Screening screening;

	@NotNull
	private Set<Seat> seatReservations;

	@NotNull
	private Customer customer;

}
