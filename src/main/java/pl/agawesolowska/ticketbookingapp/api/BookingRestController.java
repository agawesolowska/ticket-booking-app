package pl.agawesolowska.ticketbookingapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.agawesolowska.ticketbookingapp.facade.BookingFacade;
import pl.agawesolowska.ticketbookingapp.model.dto.BookingRequestDTO;

/**
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
	public @ResponseBody String addBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
		bookingFacade.seatReservation(bookingRequestDTO);
		return "test"; // TODO change to BookingResultDTO !!!
	}

}
