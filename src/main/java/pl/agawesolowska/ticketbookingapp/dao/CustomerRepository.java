package pl.agawesolowska.ticketbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.agawesolowska.ticketbookingapp.model.entity.Customer;

/**
 * @author Aga Wesołowska
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
