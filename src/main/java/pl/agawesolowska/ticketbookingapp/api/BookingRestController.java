package pl.agawesolowska.ticketbookingapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.agawesolowska.ticketbookingapp.facade.BookingFacade;
import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;
import pl.agawesolowska.ticketbookingapp.model.dto.BookingResultDTO;

/**
 * Rest Controller responding to POST HTTP request which is a customer booking.
 * Thanks to Spring Data REST a GET method is available to get information about screenings, seats, etc.
 * 
 * @author Aga Wesołowska
 *
 */
@RestController
@RequestMapping("${spring.data.rest.base-path}/customerBooking")
public class BookingRestController {

	private final BookingFacade bookingFacade;

	@Autowired
	public BookingRestController(BookingFacade bookingFacade) {
		this.bookingFacade = bookingFacade;
	}

	@PostMapping
	@ResponseBody
	public BookingResultDTO addCustomerBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
		return bookingFacade.addCustomerBooking(bookingRequestDTO);
	}

}
