package pl.agawesolowska.ticketbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.entity.Customer;

/**
 * @author Aga Wesołowska
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
