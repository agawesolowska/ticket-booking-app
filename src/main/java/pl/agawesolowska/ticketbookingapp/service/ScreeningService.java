package pl.agawesolowska.ticketbookingapp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.ScreeningRepository;
import pl.agawesolowska.ticketbookingapp.model.entity.Screening;

/**
 * @author Aga Wesołowska
 *
 */
@Service
public class ScreeningService {

	private final ScreeningRepository screeningRepository;

	@Autowired
	public ScreeningService(ScreeningRepository screeningRepository) {
		this.screeningRepository = screeningRepository;
	}

	@Transactional
	public boolean checkWhetherReservationIsPossible(Long id) {

		Optional<Screening> optionalScreening = screeningRepository.findById(id);
		if (optionalScreening.isEmpty()) {
			throw new IllegalArgumentException("The screening ID is invalid.");
		} else if (LocalDateTime.now().isAfter(optionalScreening.get().getScreeningExpirationDateTime())) {
			throw new IllegalArgumentException(
					"Reservation is not possible. Seats can be booked at the latest 15 minutes before the screening begins.");
		} else {
			return true;
		}
	}

}
