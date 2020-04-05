package pl.agawesolowska.ticketbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.model.entity.Row;

/**
 * @author Aga Wesołowska
 *
 */
public interface RowRepository extends JpaRepository<Row, Long> {

}
