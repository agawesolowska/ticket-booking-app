package pl.agawesolowska.ticketbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.CustomerRepository;
import pl.agawesolowska.ticketbookingapp.model.entity.Customer;

/**
 * Service layer that allows saving customers.
 * 
 * @author Aga Wesołowska
 *
 */
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
