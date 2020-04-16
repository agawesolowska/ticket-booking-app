package pl.agawesolowska.ticketbookingapp.model.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

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

	@Column(name = "screening_date_time")
	private LocalDateTime screeningDateTime;

	@Column(name = "movie_title")
	private String movieTitle;

	@Column(name = "duration_time_in_minutes")
	private int durationTimeInMinutes;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	@OneToMany(mappedBy = "screening")
	private Set<Row> rows;

	public LocalDateTime getScreeningExpirationDateTime() {
		return screeningDateTime.minusMinutes(15);
	}

}
