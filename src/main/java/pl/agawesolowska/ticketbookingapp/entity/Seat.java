package pl.agawesolowska.ticketbookingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "seat")
@Getter
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private int number;

	// TODO setter in case of booking
	@Column(name = "is_reserved")
	private boolean isReserved;
	
	// TODO setter in case of booking
	@Enumerated(EnumType.STRING)
	@Column(name = "type_of_ticket")
	private TicketType ticketType;
	
	@ManyToOne
	@JoinColumn(name = "row_id")
	private Row row;
	
}
