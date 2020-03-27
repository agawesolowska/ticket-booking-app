package pl.agawesolowska.ticketbookingapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "screening")
@Getter
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "screening_date")
	private LocalDate screeningDate;

	@Column(name = "screening_time")
	private LocalTime screeningTime;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie; 

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	@OneToMany(mappedBy = "screening")
	private Set<Booking> bookings;

}
