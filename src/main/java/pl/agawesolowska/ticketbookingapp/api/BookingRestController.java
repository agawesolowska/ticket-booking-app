package pl.agawesolowska.ticketbookingapp.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.agawesolowska.ticketbookingapp.entity.Customer;
import pl.agawesolowska.ticketbookingapp.entity.TicketType;
import pl.agawesolowska.ticketbookingapp.service.BookingService;

/**
 * @author Aga Wesołowska
 *
 */
@RestController
@RequestMapping("${spring.data.rest.base-path}/customer-booking")
public class BookingRestController {

	private final BookingService bookingService;

	@Autowired
	public BookingRestController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping("/single-seat/{id}/{ticketType}")
	public void addBookingOfOneSeat(@PathVariable Long id, @PathVariable TicketType ticketType, @Valid @NotNull @RequestBody Customer customer) {
		bookingService.addBookingOfOneSeat(id, ticketType, customer);
	}

}
