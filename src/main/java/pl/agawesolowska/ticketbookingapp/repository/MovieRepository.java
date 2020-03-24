package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Movie;

/**
 * @author Aga Wesołowska
 *
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
