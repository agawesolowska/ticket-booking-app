package pl.agawesolowska.ticketbookingapp.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "screening_id")
	private Screening screening;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	// TODO seats !!!
	
	// TODO methods of total amount to pay and reservation expiration time

	public SimpleMailMessage confirmationMailMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getEmailAddress());
		message.setSubject("Booking confirmation");
		message.setText(confirmationCode.toString());
		return message;
	}
	
}
