package pl.agawesolowska.ticketbookingapp.entity;

import java.util.Date;
import java.util.UUID;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "booking")
@RequiredArgsConstructor
@Getter @Setter
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "booking_timestamp")
	private Date bookingTimestamp;
	
	@Column(name = "confirmed", nullable = false)
	private Boolean confirmed;
	
	@Column(name = "confirmation_code")
	private UUID confirmationCode;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type_of_ticket")
	private TicketType ticketType;
	
	@Embedded
	private Seat seat;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "screening_id")
	private Screening screening;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
}
