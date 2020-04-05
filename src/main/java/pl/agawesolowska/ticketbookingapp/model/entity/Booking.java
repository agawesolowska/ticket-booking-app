package pl.agawesolowska.ticketbookingapp.model.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "booking")
@Getter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@CreationTimestamp
	@Column(name = "creation_date_time")
	private LocalDateTime creationDateTime;

	@Column(name = "booking_code")
	private UUID bookingCode;

	@OneToMany(mappedBy = "booking")
	private Set<Seat> seats;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	public Booking(Set<Seat> seats, Customer customer) {
		this.bookingCode = UUID.randomUUID();
		this.seats = seats;
		this.customer = customer;
	}

}
