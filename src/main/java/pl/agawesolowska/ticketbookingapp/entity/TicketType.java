package pl.agawesolowska.ticketbookingapp.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@AllArgsConstructor
@Getter
public enum TicketType {

	adult(BigDecimal.valueOf(25)), student(BigDecimal.valueOf(18)), child(BigDecimal.valueOf(12.50));

	private BigDecimal price;

	public void setWeekendPrice(TicketType type) {
		switch (type) {
		case adult:
			this.price = BigDecimal.valueOf(29);
			break;
		case student:
			this.price = BigDecimal.valueOf(22);
			break;
		case child:
			this.price = BigDecimal.valueOf(16.50);
			break;
		}
	}

	public String toString(TicketType type) {
		switch (type) {
		case adult:
			return "25 PLN";
		case student:
			return "18 PLN";
		case child:
			return "12.50 PLN";
		}
		return "Invalid ticket type.";
	}

}
