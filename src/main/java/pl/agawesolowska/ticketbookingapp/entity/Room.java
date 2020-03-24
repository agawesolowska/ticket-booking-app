package pl.agawesolowska.ticketbookingapp.entity;

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
import lombok.Setter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "room")
@Getter @Setter
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
	private Set<Row> rows;

	@OneToMany(mappedBy = "room")
	private Set<Screening> screenings;

}
