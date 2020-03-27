package pl.agawesolowska.ticketbookingapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.agawesolowska.ticketbookingapp.service.BookingService;

/**
 * @author Aga Wesołowska
 *
 */
@RestController
@RequestMapping("/api/v1/customer-booking")
public class BookingRestController {
	
	private BookingService bookingService;

	@Autowired
	public BookingRestController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	

}
