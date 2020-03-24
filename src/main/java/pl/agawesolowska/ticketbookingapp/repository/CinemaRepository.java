package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Cinema;

/**
 * @author Aga Wesołowska
 *
 */
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
