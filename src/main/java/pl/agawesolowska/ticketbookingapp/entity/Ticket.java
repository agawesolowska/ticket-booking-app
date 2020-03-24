package pl.agawesolowska.ticketbookingapp.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "ticket")
@Getter @Setter
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_of_ticket")
	private TicketType ticketType;
	
	@Embedded
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "screening_id")
	private Screening screening;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
}
