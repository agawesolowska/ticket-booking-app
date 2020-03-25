package pl.agawesolowska.ticketbookingapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

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

	@NotBlank(message = "Please provide a first name.")
	@Min(value = 3, message = "The first name should be at least three characters long.")
	@Pattern(regexp = "^[A-Z][a-z]+$", flags = Flag.UNICODE_CASE, message = "The first name should start with a capital letter.")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Please provide a last name.")
	@Min(value = 3, message = "The last name should be at least three characters long.")
	@Pattern(regexp = "^[A-Z][-a-zA-Z]+$", flags = Flag.UNICODE_CASE, message = "The last name should start with a capital letter"
			+ " and could consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Please provide an email address.")
	@Email(regexp = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$", 
		flags = Flag.UNICODE_CASE, message = "The email address is invalid.")
	@Column(name = "email_address")
	private String emailAddress;
	
	@OneToMany(mappedBy = "customer")
	private Set<Booking> bookings;

}
