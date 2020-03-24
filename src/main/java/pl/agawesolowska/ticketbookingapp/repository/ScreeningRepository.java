package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Screening;

/**
 * @author Aga Wesołowska
 *
 */
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

}
