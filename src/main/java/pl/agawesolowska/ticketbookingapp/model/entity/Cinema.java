package pl.agawesolowska.ticketbookingapp.model.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;

/**
 * @author Aga Wesołowska
 *
 */
@Entity
@Table(name = "cinema")
@Getter
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "cinema")
	private Set<Screening> screenings;

}
