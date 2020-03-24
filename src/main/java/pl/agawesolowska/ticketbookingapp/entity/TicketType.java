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

}
