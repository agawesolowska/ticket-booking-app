package pl.agawesolowska.ticketbookingapp.model.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import pl.agawesolowska.ticketbookingapp.model.SeatReservation;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;

/**
 * @author Aga Wesołowska
 *
 */
@Getter @Setter
public class BookingRequestDTO {

	@NotNull
	private Set<SeatReservation> tickets;

	@NotNull
	private Customer customer;

}
