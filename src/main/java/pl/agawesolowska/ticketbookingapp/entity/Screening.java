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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	@Column(name = "movie_title")
	private String movieTitle;

	@Column(name = "duration_time_in_minutes")
	private int durationTimeInMinutes;

	@ManyToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;

	@ManyToMany
	@JoinTable(name = "screening_room", joinColumns = @JoinColumn(name = "screening_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
	Set<Room> screeningRooms;

}
