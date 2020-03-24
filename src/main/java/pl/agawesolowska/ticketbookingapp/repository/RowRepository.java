package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Row;

/**
 * @author Aga Wesołowska
 *
 */
public interface RowRepository extends JpaRepository<Row, Long> {

}
