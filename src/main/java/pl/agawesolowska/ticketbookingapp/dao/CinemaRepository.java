package pl.agawesolowska.ticketbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.model.entity.Cinema;

/**
 * @author Aga Wesołowska
 *
 */
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
