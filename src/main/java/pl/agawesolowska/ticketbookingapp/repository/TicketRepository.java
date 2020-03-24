package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Ticket;

/**
 * @author Aga Wesołowska
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
