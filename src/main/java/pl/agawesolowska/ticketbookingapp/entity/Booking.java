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
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "booking")
@RequiredArgsConstructor
@Getter
@Setter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	// TODO setter in case of booking
	@CreationTimestamp
	@Column(name = "booking_timestamp")
	private LocalDateTime bookingTimestamp;

	// TODO setter in case of booking
	@Column(name = "is_confirmed")
	private boolean isConfirmed;

	// TODO setter in case of booking
	// TODO change to link !!!
	@Column(name = "confirmation_code")
	private UUID confirmationCode;

	@OneToMany(mappedBy = "booking")
	private Set<Seat> seats;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	// TODO methods of total amount to pay and reservation expiration time

	public SimpleMailMessage confirmationMailMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getEmailAddress());
		message.setSubject("Booking confirmation");
		message.setText(confirmationCode.toString());
		// TODO total amount to pay, reservation exp time, confirmation link
		return message;
	}

}
