package pl.agawesolowska.ticketbookingapp.model.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "row")
@Getter
public class Row {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "row_index")
	private int rowIndex;

	@Column(name = "number_of_seats")
	private int numberOfSeats;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@OneToMany(mappedBy = "row")
	private Set<Seat> seats;

}
