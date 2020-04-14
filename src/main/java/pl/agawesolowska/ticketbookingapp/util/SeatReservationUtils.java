package pl.agawesolowska.ticketbookingapp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import pl.agawesolowska.ticketbookingapp.model.entity.Seat;

/**
 * @author Aga Wesołowska
 *
 */
public class SeatReservationUtils {

	public static boolean checkWhetherSeatsAreNextToEachOther(Set<Seat> seatReservations) {

		List<Long> seatIds = new ArrayList<>();
		for (Seat seat : seatReservations) {
			Long id = seat.getId();
			seatIds.add(id);
		}
		Collections.sort(seatIds);
		for (int i = 0; i < seatIds.size() - 1; i++) {
			if (seatIds.get(i) != seatIds.get(i + 1) - 1) {
				throw new IllegalArgumentException("Reserved seats must be next to each other.");
			}
		}
		return true;
	}

}
