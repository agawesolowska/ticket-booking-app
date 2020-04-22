package pl.agawesolowska.ticketbookingapp.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.ticketbookingapp.dao.ScreeningRepository;
import pl.agawesolowska.ticketbookingapp.model.entity.Screening;

/**
 * Service layer that allows finding information about screenings.
 * 
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
	public Screening getScreeningById(Long id) {
		return screeningRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("The screening ID is invalid."));
	}

	@Transactional
	public boolean checkWhetherReservationIsPossible(Screening screening) {
		if (LocalDateTime.now().isAfter(screening.getScreeningExpirationDateTime())) {
			throw new IllegalArgumentException(
					"Reservation is not possible. Seats can be booked at the latest 15 minutes before the screening begins.");
		} else {
			return true;
		}
	}

}
