package pl.agawesolowska.ticketbookingapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@OneToMany(mappedBy = "room")
	private Set<Row> rows;

	@ManyToMany(mappedBy = "screeningRooms")
	private Set<Screening> screenings;

}
