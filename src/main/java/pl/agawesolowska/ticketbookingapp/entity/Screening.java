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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "screening")
@Getter @Setter
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "screening_date")
	private LocalDate screeningDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "screening_time")
	private LocalTime screeningTime;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	@OneToMany(mappedBy = "screening")
	private Set<Ticket> tickets;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie; 
	
}
