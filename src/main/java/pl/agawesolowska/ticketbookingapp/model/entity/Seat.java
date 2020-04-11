package pl.agawesolowska.ticketbookingapp.model.entity;

import javax.persistence.*;

import lombok.Getter;
import pl.agawesolowska.ticketbookingapp.model.TicketType;

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

	@Column(name = "is_reserved")
	private boolean isReserved;

	@Enumerated(EnumType.STRING)
	@Column(name = "ticket_type")
	private TicketType ticketType;

	@ManyToOne
	@JoinColumn(name = "row_id")
	private Row row;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public void setIsReservedToTrue() {
		this.isReserved = true;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public void setBookingId(Booking booking) {
		this.booking = booking;
	}

}
