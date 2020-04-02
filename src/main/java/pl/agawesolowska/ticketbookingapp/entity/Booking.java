package pl.agawesolowska.ticketbookingapp.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.mail.SimpleMailMessage;

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

	// TODO methods of total amount to pay and reservation expiration time

	public SimpleMailMessage confirmationMailMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getEmailAddress());
		message.setSubject("Booking confirmation");
		message.setText(bookingCode.toString());
		// TODO total amount to pay and reservation expiration time
		return message;
	}

}
