package pl.agawesolowska.ticketbookingapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "customer")
@RequiredArgsConstructor
@Getter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}+$", message = "The first name should be at least three characters long and start with a capital letter.")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}+(-[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)?$", message = "The last name should be at least three characters long and start with a capital letter."
			+ " It could also consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@Email(regexp = "^(.+)@(.+)$", message = "The email address is invalid.")
	@Column(name = "email_address")
	private String emailAddress;

	@Pattern(regexp = "^[A-Z]{4}/[0-9]{4}$", message = "The voucher code is invalid.")
	@Column(name = "voucher")
	private String voucher;

	@OneToOne(mappedBy = "customer")
	private Booking booking;

}
