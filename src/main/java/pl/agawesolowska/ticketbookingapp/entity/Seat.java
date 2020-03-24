package pl.agawesolowska.ticketbookingapp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Embeddable
@Getter @Setter
public class Seat {
	
	@Column(name = "number")
	private int number;
	
	@ManyToOne
	@JoinColumn(name = "row_id")
	private Row row;
	
}
