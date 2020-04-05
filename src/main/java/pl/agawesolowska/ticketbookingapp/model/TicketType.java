package pl.agawesolowska.ticketbookingapp.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Getter
public enum TicketType {

	@JsonProperty("adult")
	ADULT(BigDecimal.valueOf(25)),
	
	@JsonProperty("student")
	STUDENT(BigDecimal.valueOf(18)),
	
	@JsonProperty("child")
	CHILD(BigDecimal.valueOf(12.50));

	private BigDecimal price;

	private TicketType(BigDecimal price) {
		this.price = price;
	}

	public void setWeekendPrice(TicketType type) {
		switch (type) {
		case ADULT:
			this.price = BigDecimal.valueOf(29);
			break;
		case STUDENT:
			this.price = BigDecimal.valueOf(22);
			break;
		case CHILD:
			this.price = BigDecimal.valueOf(16.50);
			break;
		}
	}

	public String toString(TicketType type) {
		switch (type) {
		case ADULT:
			return "25 PLN";
		case STUDENT:
			return "18 PLN";
		case CHILD:
			return "12.50 PLN";
		}
		return "Invalid ticket type.";
	}

}
