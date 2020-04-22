package pl.agawesolowska.ticketbookingapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object class that allows giving back the total amount to pay
 * and reservation expiration time as a JSON.
 * 
 * @author Aga Wesołowska
 *
 */
@Getter
@Setter
public class BookingResultDTO {

	private BigDecimal totalCost;

	private LocalDateTime reservationExpirationTime;

	public BookingResultDTO(BigDecimal totalCost, LocalDateTime reservationExpirationTime) {
		this.totalCost = totalCost;
		this.reservationExpirationTime = reservationExpirationTime;
	}

}
