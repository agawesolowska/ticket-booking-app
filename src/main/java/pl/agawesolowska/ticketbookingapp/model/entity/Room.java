package pl.agawesolowska.ticketbookingapp.model.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "room")
@Getter
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private int number;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;
	
	@OneToMany(mappedBy = "room")
	private Set<Screening> screenings;

}
