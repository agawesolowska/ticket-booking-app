package pl.agawesolowska.ticketbookingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "customer")
@RequiredArgsConstructor
@Getter @Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}+$",
		message = "The first name should be at least three characters long and start with a capital letter.")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]{2,}+(-[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)?$",
		message = "The last name should be at least three characters long and start with a capital letter."
			+ " It could also consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@Email(regexp = "^(.+)@(.+)$", message = "The email address is invalid.")
	@Column(name = "email_address")
	private String emailAddress;

	@OneToOne(mappedBy = "customer")
	private Booking booking;

}
